package com.baidu.statistics.dataapi.svc;

import static org.junit.Assert.*;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.baidu.statistics.config.Config;
import com.baidu.statistics.config.ConfigFactory;
import com.baidu.statistics.dataapi.core.HolmesResponse;
import com.baidu.statistics.dataapi.om.profile.GetTransInfoParameter;
import com.baidu.statistics.dataapi.om.profile.GetTransInfoResponse;
import com.baidu.statistics.dataapi.om.profile.GetsitesResponse;

public class ProfileSvcTest extends BaseApiTest {

	@Test
	public void testGetSites() throws Exception {
		GetsitesResponse ret = getSites();
		assertNotNull(ret);
	}

	@Test
	public void testGetTransInfo() throws Exception {
		GetTransInfoParameter param = new GetTransInfoParameter();
		Config config = new ConfigFactory().getConfig();
		if ("name".equals(config.getString(Config.K_QUERY_TRANS_TYPE))) {
			param.setName(config.getString(Config.K_TRANS_NAME));
		} else if ("url".equals(config.getString(Config.K_QUERY_TRANS_TYPE))) {
			param.setUrl(config.getString(Config.K_TRANS_URL));
		}
		HolmesResponse<GetTransInfoResponse> transInfo = profileSvc.getTransInfo(ucid, st, param);
		System.out.println(JSON.toJSONString(transInfo));
		assertNotNull(transInfo);
	}

}
