package com.baidu.statistics.login.core;

import com.alibaba.fastjson.annotation.JSONField;
import com.baidu.statistics.config.Config;
import com.baidu.statistics.config.ConfigFactory;

public class LoginRequest<T extends RealDataLoginRequest> {
	/**
	 * 登入用户名（必填）
	 */
	@JSONField(ordinal = 1)
	private String username;
	/**
	 * Drapi权限码（必填）
	 */
	@JSONField(ordinal = 2)
	private String token;
	/**
	 * 登入阶段（必填）
	 */
	@JSONField(ordinal = 3)
	private String functionName;
	/**
	 * 唯一标识码（必填）
	 */
	@JSONField(ordinal = 4)
	private String uuid;
	/**
	 * 请求内容（必填）
	 */
	@JSONField(ordinal = 5)
	private T request;
	
	public LoginRequest() {
	}

	public void initPartDataUseConfig() {
		Config config = new ConfigFactory().getConfig();
		this.username = config.getString(Config.K_USERNAME);
		this.token = config.getString(Config.K_TOKEN);
		this.uuid = config.getString(Config.K_UUID);
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getFunctionName() {
		return functionName;
	}
	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public T getRequest() {
		return request;
	}
	public void setRequest(T request) {
		this.request = request;
		if (request != null) {
			this.functionName = request.functionName;
		}
	}
}
