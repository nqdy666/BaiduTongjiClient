package com.apexsoft.baidutongji;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import com.baidu.statistics.dataapi.svc.ProfileSvc;
import com.baidu.statistics.dataapi.svc.ReportSvc;
import com.baidu.statistics.login.om.DoLoginResponse;

public class BaseApiTest {

	protected Integer ucid;
	protected String st;
	
	private LoginConnectionTest loginConn;
	
	protected ProfileSvc profileSvc = new ProfileSvc();
	protected ReportSvc reportSvc = new ReportSvc();
	
	@Before
	public void login() throws Exception {
		loginConn = new LoginConnectionTest();
		DoLoginResponse retData = loginConn.doLogin();
		Assert.assertNotNull(retData);
		ucid = retData.getUcid();
		st = retData.getSt();
	}
	
	@After
	public void logout() throws Exception {
		boolean ret = loginConn.doLogout(ucid, st);
		Assert.assertSame(ret, true);
	}
}
