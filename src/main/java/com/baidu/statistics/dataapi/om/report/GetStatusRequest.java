package com.baidu.statistics.dataapi.om.report;

import com.baidu.statistics.dataapi.core.ApiRequest;

public class GetStatusRequest extends ApiRequest {
	/**
	 * 查询相关参数（必填）
	 * JSON 格式
	 */
	private GetStatusParameter parameterJSON;

	public GetStatusRequest(GetStatusParameter parameterJSON) {
		this();
		this.parameterJSON = parameterJSON;
	}

	public GetStatusRequest() {
		this.serviceName = "report";
		this.methodName = "getstatus";
	}
	
	public GetStatusParameter getParameterJSON() {
		return parameterJSON;
	}
	public void setParameterJSON(GetStatusParameter parameterJSON) {
		this.parameterJSON = parameterJSON;
	}
}
