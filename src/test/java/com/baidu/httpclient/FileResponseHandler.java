package com.baidu.httpclient;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;

/**
 * http请求,返回文件类型时的处理类
 * @author qjzd
 */
public class FileResponseHandler implements ResponseHandler<File> {
	private File file;

	/**
	 * @param destFile 下载下来文件存放的目标文件
	 */
	public FileResponseHandler(File destFile) {
		super();
		this.file = destFile;
	}

	public File handleResponse(HttpResponse response) throws ClientProtocolException, ServerErrorException {
		if (response.getStatusLine().getStatusCode() == 200) {
			HttpEntity entity = response.getEntity();
			if (entity.isStreaming()) {
				File folder = file.getParentFile();
				if (!folder.exists()) {
					folder.mkdirs();
				}
				InputStream is = null;
				FileOutputStream fos = null;
				try {
					if (!file.exists()) {
						file.createNewFile();
					}
					is = entity.getContent();
					fos = new FileOutputStream(file);
					byte[] bytes = new byte[1024 * 8];
					int length = 0;
					while ((length = is.read(bytes)) != -1) {
						fos.write(bytes, 0, length);
					}
					return file;
				} catch (IOException e) {
					e.printStackTrace();
					throw new ServerErrorException("文件下载失败", e);
				} finally {
					if (is != null) {
						try {
							is.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					if (fos != null) {
						try {
							fos.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			} else {
				throw new ServerErrorException("响应报文不是文件流");
			}
		} else {
			throw new ServerErrorException("响应报文状态码异常:" + response.getStatusLine().getStatusCode());
		}
	}
}
