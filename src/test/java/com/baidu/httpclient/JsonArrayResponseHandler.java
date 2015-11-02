package com.baidu.httpclient;

import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

/**
 * http请求,返回json数据处理类
 * @author qjzd
 */
public class JsonArrayResponseHandler implements ResponseHandler<JSONArray> {
	private Charset charset = Charset.forName("UTF-8");

	/**
	 * @param charset 编码
	 */
	public JsonArrayResponseHandler(String charset) {
		super();
	}

	/**
	 * 默认使用UTF-8编码
	 */
	public JsonArrayResponseHandler() {
		super();
	}

	public JSONArray handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
		if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
			HttpEntity entity = response.getEntity();
			String resStr = EntityUtils.toString(entity, charset);
			try {
				return JSON.parseArray(resStr);
			} catch (Exception e) {
				throw new ServerErrorException("响应报文数据异常\n" + resStr);
			}
		} else {
			throw new ServerErrorException("响应报文状态码异常:" + response.getStatusLine().getStatusCode());
		}
	}
}
