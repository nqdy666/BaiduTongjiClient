package com.baidu.statistics.dataapi.svc;

import com.baidu.statistics.dataapi.core.AuthHeader;
import com.baidu.statistics.dataapi.core.DataApiConnection;
import com.baidu.statistics.dataapi.core.HolmesRequest;
import com.baidu.statistics.dataapi.core.HolmesResponse;
import com.baidu.statistics.dataapi.om.report.GetStatusParameter;
import com.baidu.statistics.dataapi.om.report.GetStatusRequest;
import com.baidu.statistics.dataapi.om.report.GetStatusResponse;
import com.baidu.statistics.dataapi.om.report.QueryParameter;
import com.baidu.statistics.dataapi.om.report.QueryRequest;
import com.baidu.statistics.dataapi.om.report.QueryResponse;
import com.baidu.statistics.dataapi.om.report.QueryTransParameter;
import com.baidu.statistics.dataapi.om.report.QueryTransRequest;
import com.baidu.statistics.dataapi.om.report.QueryTransResponse;

public class Report extends Base {

	public Report(Integer ucid, String st) {
		super(ucid, st);
	}

	/**
	 * query方法根据请求时提供的报告查询条件
	 * 
	 * @param ucid
	 * @param st
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public HolmesResponse<QueryResponse> query(QueryParameter param) throws Exception {
		DataApiConnection conn = new DataApiConnection(ucid);
		AuthHeader header = new AuthHeader(st);
		QueryRequest body = new QueryRequest(param);
		HolmesRequest<QueryRequest> holmesRq = new HolmesRequest<QueryRequest>(header, body);
		HolmesResponse<QueryResponse> holmesRs = conn.post(holmesRq, QueryResponse.class);
		return holmesRs;
	}

	/**
	 * 使用query得到的result_id查询报告生成状态，当状态为已生成、可下载时，同时获得报告生成结果的下载地址。
	 * 
	 * @param ucid
	 * @param st
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public HolmesResponse<GetStatusResponse> getStatus(GetStatusParameter param) throws Exception {
		DataApiConnection conn = new DataApiConnection(ucid);
		AuthHeader header = new AuthHeader(st);
		GetStatusRequest body = new GetStatusRequest(param);
		HolmesRequest<GetStatusRequest> holmesRq = new HolmesRequest<GetStatusRequest>(header, body);
		HolmesResponse<GetStatusResponse> holmesRs = conn.post(holmesRq, GetStatusResponse.class);
		return holmesRs;
	}

	/**
	 * 
	 * @param ucid
	 * @param st
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public HolmesResponse<QueryTransResponse> queryTrans(QueryTransParameter param) throws Exception {
		DataApiConnection conn = new DataApiConnection(ucid);
		AuthHeader header = new AuthHeader(st);
		QueryTransRequest body = new QueryTransRequest(param);
		HolmesRequest<QueryTransRequest> holmesRq = new HolmesRequest<QueryTransRequest>(header, body);
		HolmesResponse<QueryTransResponse> holmesRs = conn.post(holmesRq, QueryTransResponse.class);
		return holmesRs;
	}

}
