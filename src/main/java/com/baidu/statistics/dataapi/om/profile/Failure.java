package com.baidu.statistics.dataapi.om.profile;

public class Failure {
	/**
	 * error code
	 */
	private int code;
	/**
	 * 错误信息
	 */
	private String message;
	/**
	 * 错误参数提示
	 */
	private String position;
	private String content;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
