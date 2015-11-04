package com.baidu.statistics.login.svc;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.baidu.statistics.login.om.DoLoginResponse;

public class LoginTest {

	private BaseLoginTest login;
	
	@Before
	public void loginInit() {
		login = new BaseLoginTest();
	}
	
	@Test
	public void testPreLogin() throws Exception {
		Boolean ret = login.preLogin();
		assertSame(ret, true);
	}

	@Test
	public void testDoLogin() throws Exception {
		if (login.preLogin()) {
			DoLoginResponse ret = login.doLogin();
			assertNotNull(ret);
		}
	}

	@Test
	public void testDoLogout() throws Exception {
		if (!login.preLogin()) {
			return;
		}
		DoLoginResponse loginRetData = login.doLogin();
		if (loginRetData == null) {
			return;
		}
		Boolean ret = login.doLogout(loginRetData.getUcid(), loginRetData.getSt());
		assertSame(ret, true);
	}
}
