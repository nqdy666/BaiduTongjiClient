package com.baidu.statistics.login.om;

import com.baidu.statistics.login.core.RealDataLoginRequest;

public class PreLoginRequest extends RealDataLoginRequest {
	public PreLoginRequest() {
		this.functionName = "preLogin";
	}
	
	public PreLoginRequest(String osVersion, String deviceType, String clientVersion) {
		this();
		this.osVersion = osVersion;
		this.deviceType = deviceType;
		this.clientVersion = clientVersion;
	}
	/**
	 * 客户端载体操作系统
	 */
	private String osVersion;
	/**
	 * 客户端载体类型
	 */
	private String deviceType;
	/**
	 * 客户端版本
	 */
	private String clientVersion;
	
	public String getOsVersion() {
		return osVersion;
	}
	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}
	public String getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}
	public String getClientVersion() {
		return clientVersion;
	}
	public void setClientVersion(String clientVersion) {
		this.clientVersion = clientVersion;
	}
}
