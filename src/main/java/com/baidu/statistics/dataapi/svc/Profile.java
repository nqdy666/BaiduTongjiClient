package com.baidu.statistics.dataapi.svc;

import com.baidu.statistics.dataapi.core.AuthHeader;
import com.baidu.statistics.dataapi.core.DataApiConnection;
import com.baidu.statistics.dataapi.core.HolmesRequest;
import com.baidu.statistics.dataapi.core.HolmesResponse;
import com.baidu.statistics.dataapi.om.profile.GetSitesRequest;
import com.baidu.statistics.dataapi.om.profile.GetTransInfoParameter;
import com.baidu.statistics.dataapi.om.profile.GetTransInfoRequest;
import com.baidu.statistics.dataapi.om.profile.GetTransInfoResponse;
import com.baidu.statistics.dataapi.om.profile.GetsitesResponse;

public class Profile extends Base {

	public Profile(Integer ucid, String st) {
		super(ucid, st);
	}

	/**
	 * getsites方法返回账号下管理的站点、子目录信息
	 * @param ucid
	 * @param st
	 * @return
	 * @throws Exception
	 */
	public HolmesResponse<GetsitesResponse> getSites() throws Exception {
		DataApiConnection conn = new DataApiConnection(ucid);
		AuthHeader header = new AuthHeader(st);
		GetSitesRequest body = new GetSitesRequest();
		HolmesRequest<GetSitesRequest> holmesRq = new HolmesRequest<GetSitesRequest>(header, body);
		HolmesResponse<GetsitesResponse> holmesRs = conn.post(holmesRq, GetsitesResponse.class);
		return holmesRs;
	}

	public HolmesResponse<GetTransInfoResponse> getTransInfo(GetTransInfoParameter param)
			throws Exception {
		DataApiConnection conn = new DataApiConnection(ucid);
		AuthHeader header = new AuthHeader(st);
		GetTransInfoRequest body = new GetTransInfoRequest(param);
		HolmesRequest<GetTransInfoRequest> holmesRq = new HolmesRequest<GetTransInfoRequest>(header, body);
		HolmesResponse<GetTransInfoResponse> holmesRs = conn.post(holmesRq, GetTransInfoResponse.class);
		return holmesRs;
	}
}
