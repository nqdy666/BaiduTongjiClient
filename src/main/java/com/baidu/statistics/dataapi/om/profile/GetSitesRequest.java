package com.baidu.statistics.dataapi.om.profile;

import com.baidu.statistics.dataapi.core.ApiRequest;

/**
 * getsites方法返回账号下管理的站点、子目录信息。
 * @author nianqin
 */
public class GetSitesRequest extends ApiRequest {
	
	public GetSitesRequest() {
		this.serviceName = "profile";
		this.methodName = "getsites";
	}
}
