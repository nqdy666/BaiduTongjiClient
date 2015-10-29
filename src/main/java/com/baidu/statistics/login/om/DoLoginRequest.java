package com.baidu.statistics.login.om;

import com.baidu.statistics.login.core.RealDataLoginRequest;

public class DoLoginRequest extends RealDataLoginRequest {
	/**
	 * 用户输入密码 （必填）
	 */
	private String password;
	/**
	 * 验证码字面 （选填）
	 */
	private String imageCode;
	/**
	 * 验证码会话id （选填）
	 */
	private String imageSsid;
	
	public DoLoginRequest() {
		this.functionName = "doLogin";
	}

	public DoLoginRequest(String password) {
		this();
		this.password = password;
	}
	
	public DoLoginRequest(String password, String imageCode, String imageSsid) {
		this();
		this.password = password;
		this.imageCode = imageCode;
		this.imageSsid = imageSsid;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getImageCode() {
		return imageCode;
	}
	public void setImageCode(String imageCode) {
		this.imageCode = imageCode;
	}
	public String getImageSsid() {
		return imageSsid;
	}
	public void setImageSsid(String imageSsid) {
		this.imageSsid = imageSsid;
	}
}
