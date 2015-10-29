package com.baidu.statistics.dataapi.om.report;

import java.util.List;

import com.baidu.statistics.dataapi.core.ApiResponse;

public class QueryTransResponse extends ApiResponse {
	
	private List<QueryTransResult> query_trans;

	public List<QueryTransResult> getQuery_trans() {
		return query_trans;
	}

	public void setQuery_trans(List<QueryTransResult> query_trans) {
		this.query_trans = query_trans;
	}
}
