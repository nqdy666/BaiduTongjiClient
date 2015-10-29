package com.baidu.statistics.dataapi.om.profile;

import com.baidu.statistics.dataapi.core.ApiRequest;

public class GetTransInfoRequest extends ApiRequest {
	/**
	 * 查询相关参数（必填）JSON 格式
	 */
	private GetTransInfoParameter parameterJSON;

	public GetTransInfoRequest(GetTransInfoParameter parameterJSON) {
		this();
		this.parameterJSON = parameterJSON;
	}
	public GetTransInfoRequest() {
		this.serviceName = "profile";
		this.methodName = "get_trans_info";
	}
	public GetTransInfoParameter getParameterJSON() {
		return parameterJSON;
	}
	public void setParameterJSON(GetTransInfoParameter parameterJSON) {
		this.parameterJSON = parameterJSON;
	}
}
