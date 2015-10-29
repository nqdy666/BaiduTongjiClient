package com.baidu.statistics.dataapi.om.report;

import com.baidu.statistics.dataapi.core.ApiRequest;

public class QueryRequest extends ApiRequest {
	/**
	 * 查询相关参数（必填）
	 * JSON 格式
	 */
	private QueryParameter parameterJSON;

	public QueryRequest(QueryParameter parameterJSON) {
		this();
		this.parameterJSON = parameterJSON;
	}

	public QueryRequest() {
		this.serviceName = "report";
		this.methodName = "query";
	}
	
	public QueryParameter getParameterJSON() {
		return parameterJSON;
	}

	public void setParameterJSON(QueryParameter parameterJSON) {
		this.parameterJSON = parameterJSON;
	}
}
