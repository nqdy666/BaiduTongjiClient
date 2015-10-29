package com.baidu.statistics.dataapi.core;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ValueFilter;
import com.baidu.statistics.config.Config;
import com.baidu.statistics.config.ConfigFactory;
import com.baidu.statistics.exception.StaticsException;

/**
 * 调用前提：成功登录获取用户id（ucid）及会话id（st）。
 * 请求地址：https://api.baidu.com/json/tongji/v1/ProductService/api
 * 仅支持post请求，设置编码为UTF-8
 * @author nianqin
 */
public class DataApiConnection {
	private String url;
	private Integer ucid;
	
	private String postData;
	
	private Config config;
	private DataApiLog log;
	
	public DataApiConnection(Integer ucid) {
		super();
		init(ucid);
	}

	private void init(Integer ucid) {
		config = new ConfigFactory().getConfig();
		log = new DataApiLog();
		this.url = config.getString(Config.K_API_URL);
		this.ucid = ucid;
	}
	
	private void genPostData(HolmesRequest<?> data) {
		this.postData = JSON.toJSONString(data, new ValueFilter() {
			public Object process(Object object, String name, Object value) {
				if (value instanceof ParameterType) {
					return JSON.toJSONString(value);
				}
				return value;
			}
		}, new SerializerFeature[0]);
	}
	
	public <T extends ApiResponse> HolmesResponse<T> post(HolmesRequest<?> data, final Class<T> clazz) throws StaticsException {
		log.setStartTime(System.currentTimeMillis());
		genPostData(data);
		log.setRequest(this.postData);
		CloseableHttpClient client = HttpClients.createMinimal();
		HttpPost hp = new HttpPost(this.url);
		
		//UUID 必填，唯一标识符，与登录时一致
		hp.addHeader("UUID", config.getString(Config.K_UUID)); //必填，唯一标识符，与登录时一致
		//USERID 必填，成功登录后获取的用户id（ucid）
		hp.addHeader("USERID", String.valueOf(this.ucid)); //必填，成功登录后获取的用户id（ ucid）
		//tracker选填，请求定位符，可用于定位请求
		hp.addHeader("tracker", ""); //选填，请求定位符，可用于定位请求
		hp.addHeader("Content-Type", "data/json;charset=UTF-8");
		
		HttpEntity entity;
		entity = new StringEntity(this.postData, "UTF-8");
		hp.setEntity(entity);
		try {
			return client.execute(hp, new ResponseHandler<HolmesResponse<T>>() {
				public HolmesResponse<T> handleResponse(HttpResponse response)
						throws ClientProtocolException, IOException {
					if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
						throw new StaticsException("响应报文状态码异常:" + response.getStatusLine().getStatusCode());
					}
					HttpEntity entity = response.getEntity();
					String retStr = EntityUtils.toString(entity, "UTF-8");
					
					log.setResponse(retStr);
					log.setEndTime(System.currentTimeMillis());
					log.print();
					
					JSONObject retJson = JSON.parseObject(retStr);
					HolmesResponse<T> holmesRs = new HolmesResponse<T>();
					ResHeader header = JSON.parseObject(retJson.getString("header"), ResHeader.class);
					holmesRs.setHeader(header);
					JSONObject bodyJson = retJson.getJSONObject("body");
					if (bodyJson != null && !bodyJson.isEmpty()) {
						T body = JSON.parseObject(retJson.getJSONObject("body").getString("responseData"), clazz);
						holmesRs.setBody(body);
					}
					return holmesRs;
				}
			});
		} catch (ClientProtocolException e) {
			throw new StaticsException(e.getMessage());
		} catch (IOException e) {
			throw new StaticsException(e.getMessage());
		}
	}
}
