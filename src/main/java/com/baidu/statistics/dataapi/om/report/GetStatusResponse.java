package com.baidu.statistics.dataapi.om.report;

import com.baidu.statistics.dataapi.core.ApiResponse;

public class GetStatusResponse extends ApiResponse {
	private GetStatusResult result;

	public GetStatusResult getResult() {
		return result;
	}

	public void setResult(GetStatusResult result) {
		this.result = result;
	}
}
