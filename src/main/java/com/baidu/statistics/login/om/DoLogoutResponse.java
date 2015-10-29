package com.baidu.statistics.login.om;

import com.baidu.statistics.login.core.RealDataLoginResponse;

public class DoLogoutResponse extends RealDataLoginResponse {
	public static final Integer RETCODE_OK = 0; //成功
	public static final Integer RETCODE_FAILED = 1; //失败
	/**
	 * 0：成功， 1：失败
	 */
	private Integer retcode;
	/**
	 * error 具体信息
	 */
	private String retmsg;
	
	public Integer getRetcode() {
		return retcode;
	}
	public void setRetcode(Integer retcode) {
		this.retcode = retcode;
	}
	public String getRetmsg() {
		return retmsg;
	}
	public void setRetmsg(String retmsg) {
		this.retmsg = retmsg;
	} 
}
