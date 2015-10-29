package com.baidu.statistics.login.core;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.baidu.statistics.config.Config;
import com.baidu.statistics.config.ConfigFactory;
import com.baidu.statistics.exception.StaticsException;
import com.baidu.statistics.login.gzip.GZipUtils;
import com.baidu.statistics.login.rsa.Rsa;
import com.baidu.statistics.login.rsa.RsaFactory;
import com.baidu.statistics.utils.FileUtil;

/**
 * 使用方需要首先将登录请求对象转换成JSON格式，编码采用UTF-8，
 * 然后用GZIP对消息JSON串进行压缩。
 * 压缩完毕后，采用RSA算法的公钥进行加密。（公钥见文档附录）
 * 由于密钥为1024位，所以最多对117个字符进行加密，若压缩后的数据超过117个字符，则进行分块（117字符为1块）加密，再拼接。
 * 最多支持加密2047个字符。 
 * 
 * 服务器响应都包含消息头和数据。消息头由8个字节组成，分成4个整数，每个整数包含2个字节高位在前。
 * 第一个整数表示return code，表明请求成功与否及错误的具体代码。return code的说明见附录。第二~第四个整数位保留字段 
 * @author nianqin
 */
public class LoginConnection {
	
	private final static String DEF_CHARSET = "UTF-8";
	private final static String PUBLIK_KEY_NAME = "apiPub.key";
	
	private String url;
	private byte[] postData;
	
	private Config config;
	private Rsa rsa;
	private LoginLog log;
	
	public LoginConnection() {
		super();
		init();
	}

	private void init() {
		log = new LoginLog();
		config = new ConfigFactory().getConfig();
		rsa = new RsaFactory().getRsa();
		this.url = config.getString(Config.K_LOGIN_URL);
		try {
			rsa.loadPublicKeyFromFile(FileUtil.getFileFromResource("/" + PUBLIK_KEY_NAME));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void genPostData(String data) {
		try {
			byte[] bytes = GZipUtils.compress(data.getBytes(DEF_CHARSET));
			bytes = rsa.encrypt(bytes);
			this.postData = bytes;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static int twoByte2Int(byte[] bytes) {
		int out = 0;
		out = ((bytes[0] & 0xFF) << 8) + bytes[1];
		return out;
	}
	
	public <T extends RealDataLoginResponse> LoginResponse<T> post(LoginRequest<?> postData, final Class<T> clazz) throws StaticsException {
		String requestData = JSON.toJSONString(postData);
		this.genPostData(requestData);
		log.setStartTime(System.currentTimeMillis());
		log.setRequest(requestData);
		CloseableHttpClient client = HttpClients.createMinimal();
		HttpPost hp = new HttpPost(this.url);
		
		hp.addHeader("UUID", config.getString(Config.K_UUID));
		hp.addHeader("account_type", config.getString(Config.K_ACCOUNT_TYPE));
		hp.addHeader("Content-Type", "data/gzencode and rsa public encrypt;charset=UTF-8");
		
		HttpEntity entity = new ByteArrayEntity(this.postData);
		hp.setEntity(entity);
		try {
			return client.execute(hp, new ResponseHandler<LoginResponse<T>>() {
				public LoginResponse<T> handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
					if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
						HttpEntity entity = response.getEntity();
						byte[] bytes = EntityUtils.toByteArray(entity);
						LoginResponse<T> retObj = new LoginResponse<T>();
						
						if (bytes.length < 8) {
							throw new StaticsException("返回数据大小不足8位");
						}
						byte[] tmpBytes = new byte[2];
						System.arraycopy(bytes, 0, tmpBytes, 0, 2);
						retObj.setReturnCode(twoByte2Int(tmpBytes));
						System.arraycopy(bytes, 2, tmpBytes, 0, 2);
						retObj.setEncryptVersion(twoByte2Int(tmpBytes));
						System.arraycopy(bytes, 4, tmpBytes, 0, 2);
						retObj.setResevred(twoByte2Int(tmpBytes));
						System.arraycopy(bytes, 6, tmpBytes, 0, 2);
						retObj.setResevred2(twoByte2Int(tmpBytes));
						
						tmpBytes = new byte[bytes.length - 8];
						if (tmpBytes.length != 0) {
							System.arraycopy(bytes, 8, tmpBytes, 0, tmpBytes.length);
							try {
								String realData = new String(GZipUtils.decompress(tmpBytes), "UTF-8");
								retObj.setRealData(JSON.parseObject(realData, clazz));
							} catch (Exception e) {
								throw new StaticsException(e.getMessage());
							}
						}
						log.setResponse(JSON.toJSONString(retObj));
						log.setEndTime(System.currentTimeMillis());
						log.print();
						return retObj;
					} else {
						throw new StaticsException("响应报文状态码异常:" + response.getStatusLine().getStatusCode());
					}
				}
			});
		} catch (ClientProtocolException e) {
			throw new StaticsException(e.getMessage());
		} catch (IOException e) {
			throw new StaticsException(e.getMessage());
		}
	}
}
