package com.baidu.statistics.login.om;

import com.baidu.statistics.login.core.RealDataLoginRequest;

/**
 * 用户在终止访问统计API时，可以选择主动进行登出操作。登出请求的地址为（与登入一致）
 * @author nianqin
 */
public class DoLogoutRequest extends RealDataLoginRequest {
	/**
	 * 用户ID（必填）
	 */
	private Integer ucid; 
	/**
	 * 会话ID（必填）
	 */
	private String st;
	
	public DoLogoutRequest() {
		this.functionName = "doLogout";
	}
	
	public DoLogoutRequest(Integer ucid, String st) {
		this();
		this.ucid = ucid;
		this.st = st;
	}
	public Integer getUcid() {
		return ucid;
	}
	public void setUcid(Integer ucid) {
		this.ucid = ucid;
	}
	public String getSt() {
		return st;
	}
	public void setSt(String st) {
		this.st = st;
	}
}
