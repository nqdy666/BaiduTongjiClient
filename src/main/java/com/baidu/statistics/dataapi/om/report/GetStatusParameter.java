package com.baidu.statistics.dataapi.om.report;

import com.baidu.statistics.dataapi.core.ParameterType;

public class GetStatusParameter extends ParameterType {
	/**
	 * 使用 query得到的 result_id查询编号
	 * （必填）
	 */
	private String result_id;

	public GetStatusParameter(String result_id) {
		this.result_id = result_id;
	}

	public String getResult_id() {
		return result_id;
	}

	public void setResult_id(String result_id) {
		this.result_id = result_id;
	}
}
