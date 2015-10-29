package com.baidu.statistics.dataapi.om.report;

import com.baidu.statistics.dataapi.core.ApiResponse;

public class QueryResponse extends ApiResponse {
	private QueryResult query;

	public QueryResult getQuery() {
		return query;
	}
	public void setQuery(QueryResult query) {
		this.query = query;
	}
}
