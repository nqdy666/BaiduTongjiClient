package com.baidu.httpclient;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 * 秦晋之巅HttpClient
 * http客户端
 * @author qjzd
 */
public class HttpClientUtils {

	/**
	 * post发送请求
	 * 请求参数使用map包装
	 * @param url 请求地址
	 * @param params 请求参数列表, 每一个请求参数为String类型
	 * @param handler 请求返回数据处理类
	 * @return 返回对象handler处理后的数据
	 * @throws ServerErrorException
	 */
	public static <T> T post(String url, ResponseHandler<T> handler) throws ServerErrorException {
		CloseableHttpClient client = HttpClients.createMinimal();
		HttpPost hp = new HttpPost(url);
		try {
			return client.execute(hp, handler);
		} catch (ClientProtocolException e) {
			throw new ServerErrorException("服务器[" + url + "]连接不通", e);
		} catch (IOException e) {
			throw new ServerErrorException("服务器[" + url + "]访问异常", e);
		}
	}
}
