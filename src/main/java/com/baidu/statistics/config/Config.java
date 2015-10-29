package com.baidu.statistics.config;

public interface Config {
	
	//preLogin,doLogin URL
	public static final String K_LOGIN_URL = "login_url";
	//DataApi URL
	public static final String K_API_URL = "api_ul";
	//USERNAME
	public static final String K_USERNAME = "username";
	//PASSWORD
	public static final String K_PASSWORD = "password";
	//TOKEN
	public static final String K_TOKEN = "token";
	//UUID, used to identify your device, for instance: MAC address 
	public static final String K_UUID = "uuid";
	//ACCOUNT_TYPE
	public static final String K_ACCOUNT_TYPE = "account_type";
	//TRANS_NAME
	public static final String K_TRANS_NAME = "trans_name";
	//TRANS_URL
	public static final String K_TRANS_URL = "trans_url";
	//QUERY_TRANS_TYPE, 'name' or 'url'
	public static final String K_QUERY_TRANS_TYPE = "query_trans_type";
	
	public void loadConfig();
	public String getString(String key);
	public Integer getInteger(String key);
}
