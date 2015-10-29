package com.apexsoft.baidutongji;

import java.util.ArrayList;
import java.util.Arrays;

import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.baidu.statistics.config.Config;
import com.baidu.statistics.config.ConfigFactory;
import com.baidu.statistics.dataapi.core.HolmesResponse;
import com.baidu.statistics.dataapi.core.ResHeader;
import com.baidu.statistics.dataapi.om.profile.GetsitesResponse;
import com.baidu.statistics.dataapi.om.report.GetStatusParameter;
import com.baidu.statistics.dataapi.om.report.GetStatusResponse;
import com.baidu.statistics.dataapi.om.report.GetStatusResult;
import com.baidu.statistics.dataapi.om.report.QueryParameter;
import com.baidu.statistics.dataapi.om.report.QueryResponse;
import com.baidu.statistics.dataapi.om.report.QueryTransParameter;
import com.baidu.statistics.dataapi.om.report.QueryTransResponse;

public class ReprotSvcTest extends BaseApiTest {

	private GetsitesResponse getSites() throws Exception {
		HolmesResponse<GetsitesResponse> sitesInfo = profileSvc.getSites(ucid, st);
		GetsitesResponse sites = sitesInfo.getBody();
		if (sites == null || sites.getSites().size() <= 0) {
			System.out.println("getSites failed!");
			return null;
		}
		System.out.println("getSites successfully!");
		return sites;
	}
	
	public HolmesResponse<QueryResponse> query() throws Exception {
		GetsitesResponse sitesResponse = getSites();
		if (sitesResponse == null) {
			return null;
		}
		QueryParameter queryParam = new QueryParameter();
		queryParam.setReportid(1);
		queryParam.setMetrics(Arrays.asList("pageviews", "visitors"));
		queryParam.setDimensions(Arrays.asList("pageid"));
		queryParam.setStart_time("20130801000000");
		queryParam.setEnd_time("20130830235959");
		queryParam.setFilters(new ArrayList<String>());
		queryParam.setStart_index(0);
		queryParam.setMax_results(10);
		queryParam.setSort(Arrays.asList("pageviews desc"));
		queryParam.setSiteid(sitesResponse.getSites().get(0).getSiteid());
		HolmesResponse<QueryResponse> response = reportSvc.query(ucid, st, queryParam);
		
		ResHeader header = response.getHeader();
		QueryResponse queryRetData = response.getBody();
		if (header == null || queryRetData == null) {
			System.out.println("query failed!");
			return null;
		}
		if (header.getStatus() != 0 || StringUtils.isBlank(queryRetData.getQuery().getResult_id())) {
			System.out.println("data error, query failed!");
			return null;
		}
		System.out.println("query successfully!");
		return response;
	}
	
	public GetStatusResponse getStatus() throws Exception {
		HolmesResponse<QueryResponse> queryResponse = this.query();
		if (queryResponse.getBody() == null) {
			return null;
		}
		HolmesResponse<GetStatusResponse> response = reportSvc.getStatus(ucid, st, 
				new GetStatusParameter(queryResponse.getBody().getQuery().getResult_id()));
		GetStatusResponse retData = response.getBody();
		if (retData == null) {
			System.out.println("getStatus failed");
			return null;
		}
		Integer status = retData.getResult().getStatus();
		if (status == null || status == GetStatusResult.STATUS_INVALID ) {
			System.out.println("status invalid");
			return null;
		} else if (status == GetStatusResult.STATUS_GENERATIN) {
			System.out.println("status generating");
			return null;
		} else if (status == GetStatusResult.STATUS_FAILED ) {
			System.out.println("status failed");
			return null;
		} else if (status == GetStatusResult.STATUS_SUCCESS ) {
			System.out.println("getStatus success");
			return retData;
		} else {
			System.out.println("unkown status");
			return null;
		}
	}
	
	@Test
	public void queryTest() throws Exception {
		HolmesResponse<QueryResponse> response = this.query();
		Assert.assertNotNull(response);
	}
	
	@Test
	public void getSitesTest() throws Exception {
		GetStatusResponse retData = getStatus();
		Assert.assertNotNull(retData);
	}
	
	@Test
	public void queryTrans() throws Exception {
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
