package com.baidu.statistics.login.svc;

import com.baidu.statistics.config.Config;
import com.baidu.statistics.config.ConfigFactory;
import com.baidu.statistics.login.core.LoginConnection;
import com.baidu.statistics.login.core.LoginRequest;
import com.baidu.statistics.login.core.LoginResponse;
import com.baidu.statistics.login.om.DoLoginRequest;
import com.baidu.statistics.login.om.DoLoginResponse;
import com.baidu.statistics.login.om.DoLogoutRequest;
import com.baidu.statistics.login.om.DoLogoutResponse;
import com.baidu.statistics.login.om.PreLoginRequest;
import com.baidu.statistics.login.om.PreLoginResponse;

public class LoginSvc {
	
	/**
	 * 预登入
	 * @return
	 * @throws Exception
	 */
	public LoginResponse<PreLoginResponse> preLogin(PreLoginRequest request) throws Exception {
		LoginConnection conn = new LoginConnection();
		LoginRequest<PreLoginRequest> postData = new LoginRequest<PreLoginRequest>();
		postData.initPartDataUseConfig();
		postData.setRequest(request);
		LoginResponse<PreLoginResponse> response = conn.post(postData, PreLoginResponse.class);
		return response;
	}
	
	/**
	 * 登入
	 * @return
	 * @throws Exception
	 */
	public LoginResponse<DoLoginResponse> doLogin() throws Exception {
		Config config = new ConfigFactory().getConfig();
		LoginConnection conn = new LoginConnection();
		LoginRequest<DoLoginRequest> postData = new LoginRequest<DoLoginRequest>();
		postData.initPartDataUseConfig();
		postData.setRequest(new DoLoginRequest(config.getString(Config.K_PASSWORD)));
		LoginResponse<DoLoginResponse> response= conn.post(postData, DoLoginResponse.class);
		return response;
	}
	
	/**
	 * 登出
	 * @param ucid 用户ID
	 * @param st 会话ID
	 * @return
	 * @throws Exception
	 */
	public LoginResponse<DoLogoutResponse> doLogout(DoLogoutRequest request) throws Exception {
		LoginConnection conn = new LoginConnection();
		LoginRequest<DoLogoutRequest> postData = new LoginRequest<DoLogoutRequest>();
		postData.initPartDataUseConfig();
		postData.setRequest(request);
		LoginResponse<DoLogoutResponse> response = conn.post(postData, DoLogoutResponse.class);
		return response;
	}
}
