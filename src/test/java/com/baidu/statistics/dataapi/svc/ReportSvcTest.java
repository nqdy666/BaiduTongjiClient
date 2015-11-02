package com.baidu.statistics.dataapi.svc;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.baidu.httpclient.FileResponseHandler;
import com.baidu.httpclient.HttpClientUtils;
import com.baidu.httpclient.JsonArrayResponseHandler;
import com.baidu.statistics.config.Config;
import com.baidu.statistics.config.ConfigFactory;
import com.baidu.statistics.dataapi.core.HolmesResponse;
import com.baidu.statistics.dataapi.om.profile.GetsitesResponse;
import com.baidu.statistics.dataapi.om.report.GetStatusResponse;
import com.baidu.statistics.dataapi.om.report.QueryResponse;
import com.baidu.statistics.dataapi.om.report.QueryTransParameter;
import com.baidu.statistics.dataapi.om.report.QueryTransResponse;

public class ReportSvcTest extends BaseApiTest {

	@Test
	public void testQuery() throws Exception {
		HolmesResponse<QueryResponse> response = query();
		Assert.assertNotNull(response);
	}

	@Test
	public void testGetStatus() throws Exception {
		GetStatusResponse retData = getStatus();
		Assert.assertNotNull(retData);
	}
	
	@Test
	public void testGetStatusAndDownloadResult() throws Exception {
		GetStatusResponse retData = getStatus();
		Assert.assertNotNull(retData);
		
		String url = retData.getResult().getResult_url();
		String filename = retData.getResult().getResult_id() + ".json"; 
		File destFile = new File("./tmp/" + filename);
		HttpClientUtils.post(url, new FileResponseHandler(destFile));
	}
	
	@Test
	public void testGetStatusAndResult2JsonArray() throws Exception {
		GetStatusResponse retData = getStatus();
		Assert.assertNotNull(retData);
		String url = retData.getResult().getResult_url();
		JSONArray retJSON = (JSONArray) HttpClientUtils.post(url, new JsonArrayResponseHandler());
		System.out.println(retJSON);
	}

	@Test
	public void testQueryTrans() throws Exception {
		GetsitesResponse sitesResponse = getSites();
		if (sitesResponse == null) {
			return;
		}
		Integer siteid = sitesResponse.getSites().get(0).getSiteid();
		
		QueryTransParameter param = new QueryTransParameter();
		param.setMetrics(Arrays.asList("transformNum"));
		param.setDimensions(Arrays.asList("targetid"));
		param.setStart_time("20130801000000");
		param.setEnd_time("20130830235959");
		param.setFilters(new ArrayList<String>());
		param.setStart_index(0);
		param.setMax_results(10);
		param.setSort(Arrays.asList("transformNum desc"));
		param.setSiteid(siteid);
		Config config = new ConfigFactory().getConfig();
		if ("name".equals(config.getString(Config.K_QUERY_TRANS_TYPE))) {
			param.setName(config.getString(Config.K_TRANS_NAME));
		} else if ("url".equals(config.getString(Config.K_QUERY_TRANS_TYPE))) {
			param.setUrl(config.getString(Config.K_TRANS_URL));
		}
		HolmesResponse<QueryTransResponse> response = reportSvc.queryTrans(ucid, st, param);
		System.out.println(JSON.toJSONString(response));
	}

}
