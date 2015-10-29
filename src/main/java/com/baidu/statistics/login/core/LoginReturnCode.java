package com.baidu.statistics.login.core;

import java.util.HashMap;
import java.util.Map;

public class LoginReturnCode {
	public static int OK = 0; //成功
	public static int INVALID_ENCODING = 2; //请求数据的编码错误，非 UTF-8
	public static int DAMAGED_DATA = 3; //请求数据损坏
	public static int DATA_TOO_LARGE = 4; //请求数据过大
	public static int INVALID_REQUEST = 6; //请求数据不符合规范
	public static int FUNCTION_NOT_SUPPORTED = 7; //未知的functionName
	public static int DAMAGED_RESPONSE = 8; //响应数据损坏
	public static int INVALID_TOKEN = 9; //token 无效
	public static int INVALID_USER = 10; //用户无效
	public static int ERROR_PROCESSING = 11; //登录请求处理异常
	public static int INVALID_ACCOUNTTYPE = 12; //账户类型无效
	
	public static Map<Integer, String> MSG_MAP = new HashMap<Integer, String>();
	static {
		MSG_MAP.put(OK, "成功");
		MSG_MAP.put(INVALID_ENCODING, "请求数据的编码错误，非 UTF-8");
		MSG_MAP.put(DAMAGED_DATA, "请求数据损坏");
		MSG_MAP.put(DATA_TOO_LARGE, "请求数据过大");
		MSG_MAP.put(INVALID_REQUEST, "请求数据不符合规范");
		MSG_MAP.put(FUNCTION_NOT_SUPPORTED, "未知的functionName");
		MSG_MAP.put(DAMAGED_RESPONSE, "响应数据损坏");
		MSG_MAP.put(INVALID_TOKEN, "token 无效");
		MSG_MAP.put(INVALID_USER, "用户无效");
		MSG_MAP.put(ERROR_PROCESSING, "登录请求处理异常");
		MSG_MAP.put(INVALID_ACCOUNTTYPE, "账户类型无效");
	}
}
