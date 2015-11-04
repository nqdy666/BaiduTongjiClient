package com.baidu.statistics.dataapi.core;

public class HolmesResponse<T extends ApiResponse> {
	/**
	 * 响应头
	 */
	private ResHeader header;
	/**
	 * api 响应数据
	 */
	private T body;
	
	public ResHeader getHeader() {
		return header;
	}
	public void setHeader(ResHeader header) {
		this.header = header;
	}
	public T getBody() {
		return body;
	}
	public void setBody(T body) {
		this.body = body;
	}
}
