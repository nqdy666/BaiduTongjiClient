package com.baidu.statistics.dataapi.om.report;

import com.baidu.statistics.dataapi.core.ApiRequest;

/**
 * query_trans 方法根据请求时提供的报告查询条件，返回所查转化的转化数。
 * @author nianqin
 */
public class QueryTransRequest extends ApiRequest {
	/**
	 * 查询相关参数（必填）
	 * JSON 格式
	 */
	private QueryTransParameter parameterJSON;

	public QueryTransRequest(QueryTransParameter parameterJSON) {
		this();
		this.parameterJSON = parameterJSON;
	}

	public QueryTransRequest() {
		this.serviceName = "report";
		this.methodName = "query_trans";
	}

	public QueryTransParameter getParameterJSON() {
		return parameterJSON;
	}
	public void setParameterJSON(QueryTransParameter parameterJSON) {
		this.parameterJSON = parameterJSON;
	}
}
