package com.baidu.statistics.dataapi.core;

public class HolmesRequest<T extends ApiRequest> {
	/**
	 * 认证信息（必填）
	 */
	private AuthHeader header;
	/**
	 * api 请求（必填）
	 */
	private T body;
	
	public HolmesRequest() {
		super();
	}

	public HolmesRequest(AuthHeader header, T body) {
		super();
		this.header = header;
		this.body = body;
	}
	
	public AuthHeader getHeader() {
		return header;
	}
	public void setHeader(AuthHeader header) {
		this.header = header;
	}
	public T getBody() {
		return body;
	}
	public void setBody(T body) {
		this.body = body;
	}
}
