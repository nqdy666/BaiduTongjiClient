package com.baidu.statistics.login.svc;

import com.alibaba.fastjson.JSON;
import com.baidu.statistics.common.StatisticConstant;
import com.baidu.statistics.login.core.LoginResponse;
import com.baidu.statistics.login.core.LoginReturnCode;
import com.baidu.statistics.login.om.DoLoginResponse;
import com.baidu.statistics.login.om.DoLogoutRequest;
import com.baidu.statistics.login.om.DoLogoutResponse;
import com.baidu.statistics.login.om.PreLoginRequest;
import com.baidu.statistics.login.om.PreLoginResponse;

public class BaseLoginTest {
	
	private LoginSvc loginSvc = new LoginSvc();
	
	public boolean preLogin() throws Exception {
		PreLoginRequest request = new PreLoginRequest(StatisticConstant.OS_VERSION_WINDOWS, StatisticConstant.DEVICE_TYPE_PC, "1.0");
		LoginResponse<PreLoginResponse> response = loginSvc.preLogin(request);
		if (LoginReturnCode.OK != response.getReturnCode()) {
			System.out.println("[error] preLogin unsuccessfully with return code: " + response.getReturnCode());
			return false;
		}
		PreLoginResponse retData = response.getRealData();
		if (retData.getNeedAuthCode() == null) {
			System.out.println("[error] unexpected preLogin return data: " + JSON.toJSONString(response.getRealData()));
			return false;
		}
		if (retData.getNeedAuthCode() == true) {
			System.out.println("[error] preLogin return data format error: " + JSON.toJSONString(response.getRealData()));
			return false;
		}
		System.out.println("[notice] preLogin successfully!");
		return true;
	}
	
	public DoLoginResponse doLogin() throws Exception {
		LoginResponse<DoLoginResponse> response = loginSvc.doLogin();
		if (LoginReturnCode.OK != response.getReturnCode()) {
			System.out.println("[error] doLogin unsuccessfully with return code: " + response.getReturnCode());
			return null;
		}
		DoLoginResponse retData = response.getRealData();
		if (retData.getRetcode() == null || retData.getUcid() == null
				|| retData.getSt() == null) {
			System.out.println("[error] doLogin return data format error: " + retData);
			return null;
		}
		if (retData.getRetcode() != DoLoginResponse.RETCODE_OK) {
			System.out.println("[error] doLogin unsuccessfully with retcode: " + retData);
			return null;
		}
		System.out.println("[notice] doLogin successfully!");
		return retData;
	}
	
	public boolean doLogout(Integer ucid, String st) throws Exception {
		DoLogoutRequest request = new DoLogoutRequest(ucid, st);
		LoginResponse<DoLogoutResponse> response = loginSvc.doLogout(request);
		if (LoginReturnCode.OK != response.getReturnCode()) {
			System.out.println("[error] doLogout unsuccessfully with return code: " + response.getReturnCode());
			return false;
		}
		DoLogoutResponse retData = response.getRealData();
		if (retData.getRetcode() == null) {
			System.out.println("[error] doLogout return data format error: " + retData);
			return false;
		}
		System.out.println("[notice] doLogout successfully!");
		return true;
	}
}
