package com.baidu.statistics.dataapi.constant;

/**
 * SE开头：
 * System Error是指在权限验证阶段的错误。
 * 在其中，对于status=3的错误，content字段会包含一个字符串（ticket）作为系统定位错误的识别符，
 * 如果您需要向百度反应和排查此系统错误，只需提供该ticket给百度即可。
 * @author nianqin
 */
public class ApiError {
	/**
	 * Server internal error, please try again later 
	 * 系统错误
	 */
	public static final int SE800 = 800;
	/**
	 * Request forbidden on this IP for frequent username password or token errors
	 * 错误的用户名、密码或者token 请求过于频繁
	 */
	public static final int SE801 = 801;
	/**
	 * Request forbidden for frequent password errors
	 * 错误的密码请求过于频繁
	 */
	public static final int SE802 = 802;
	/**
	 * The Json message you provided is invalid
	 * Json message不合法
	 */
	public static final int SE8002 = 8002;
	/**
	 *  Username is not set in request header
	 *  缺少用户名信息
	 */
	public static final int SE8101 = 8101;
	/**
	 *  The username is invalid, please contact administrator
	 *  用户名不合法
	 */
	public static final int SE8102 = 8102;
	/**
	 * The username is invalid, please contact administrator
	 * 用户名不合法
	 */
	public static final int SE8103 = 8103;
	/**
	 * The username in request header is not authorized to login
	 * 没有权限操作该用户
	 */
	public static final int SE8104 = 8104;
	/**
	 * Password is not set in request header
	 * 缺少密码信息
	 */
	public static final int SE8201 = 8201;
	/**
	 * The password is invalid
	 * 密码不合法
	 */
	public static final int SE8202 = 8202;
	/**
	 * The target in request header is invalid
	 * 被操作的用户不合法
	 */
	public static final int SE8301 = 8301;
	/**
	 *  he target in request header is not authorized to login
	 *  没有权限操作该用户
	 */
	public static final int SE8303 = 8303;
	/**
	 * Token is not set in request header
	 * 缺少token信息
	 */
	public static final int SE8401 = 8401;
	/**
	 * The token is invalid, please contact administrator
	 * token不合法
	 */
	public static final int SE8402 = 8402;
	/**
	 * The token is deleted, please contact administrator
	 * token已删除
	 */
	public static final int SE8403 = 8403;
	/**
	 * You are not authorized to use the token provided in request header
	 * 没有权限使用该token
	 */
	public static final int SE8408 = 8408;
	/**
	 * You are not authorized to operate the target provided in request header
	 * 没有权限操作该用户
	 */
	public static final int SE8409 = 8409;
	/**
	 * You are not authorized to use the token provided in request header
	 * 没有权限使用该token
	 */
	public static final int SE8410 = 8410;
	/**
	 * You are not authorized to operate other users
	 * 没有权限操作其他用户
	 */
	public static final int SE8411 = 8411;
	/**
	 * You are not authorized to use this token
	 * 没有权限使用该token
	 */
	public static final int SE8412 = 8412;
	/**
	 * You do not have enough quota
	 * 配额不足
	 */
	public static final int SE8501 = 8501;
	/**
	 * We are unable to serve your request, please try again later
	 * 未知服务器错误，稍后再试
	 */
	public static final int SE8601 = 8601;
	/**
	 * We are unable to serve your request, please try again later
	 * 未知服务器错误，稍后再试
	 */
	public static final int SE8602 = 8602;
	/**
	 * The request header you provided is isvalid
	 * 请求头信息不合法
	 */
	public static final int SE8603 = 8603;
	/**
	 * We are unable to serve your request, please try again later
	 * 未知服务器错误，稍后再试
	 */
	public static final int SE8604 = 8604;
	/**
	 * We are unable to serve your request, please try again later
	 * 未知服务器错误，稍后再试
	 */
	public static final int SE8605 = 8605;
	/**
	 * We are unable to serve your request, please try again later
	 * 未知服务器错误，稍后再试
	 */
	public static final int SE8606 = 8606;

	/**
	 * system error
	 * 系统错误
	 */
	public static final int GE9104 = 9104;
	/**
	 * request parameter format error
	 * 请求参数格式错误
	 */
	public static final int GE9105 = 9105;
	/**
	 * invalid serviceName
	 * serviceName
	 */
	public static final int GE9106 = 9106;
	/**
	 * invalid methodName
	 * methodName不合法
	 */
	public static final int GE9107 = 9107;
	/**
	 * parameterJson format error
	 * parameterJSON格式错误
	 */
	public static final int GE9108 = 9108;
	
	/**
	 * no data under username
	 * 用户名下无站点数据
	 */
	public static final int PSE9101101 = 9101101;
	
	/**
	 * no right to operate current siteid
	 * 没有权限操作此siteid
	 */
	public static final int RSE9102101 = 9102101;
	/**
	 * report_id error
	 * report_id不合法
	 */
	public static final int RSE9102102= 9102102;
	/**
	 * start_time error
	 * start_time格式错误
	 */
	public static final int RSE9102103 = 9102103;
	/**
	 * end_time error
	 * end_time格式错误
	 */
	public static final int RSE9102104 = 9102104;
	/**
	 * The end_time is earlier than start_time
	 * end_time早于start_time
	 */
	public static final int RSE91021051 = 91021051;
	/**
	 * start_time is latter than now
	 * start_tim晚于当前时间
	 */
	public static final int RSE91021052 = 91021052;
	/**
	 * end_time is latter than now
	 * end_time晚于当前时间
	 */
	public static final int RSE91021053 = 91021053;
	/**
	 * time range is too longer
	 * 时间跨度大于限制（一年）
	 */
	public static final int RSE91021054 = 91021054;
	/**
	 * dimensions error
	 * dimensions不合法
	 */
	public static final int RSE9102106 = 9102106;
	/**
	 * metricserror
	 * metrics不合法
	 */
	public static final int RSE9102107 = 9102107;
	/**
	 * filters error
	 * filters 不合法
	 */
	public static final int RSE9102108 = 9102108;
	/**
	 * sort error
	 * sort 不合法
	 */
	public static final int RSE9102109 = 9102109;
	/**
	 * start_index error
	 * start_index不合法
	 */
	public static final int RSE9102110 = 9102110;
	/**
	 * max_results error
	 * max_results不合法
	 */
	public static final int RSE9102111 = 9102111;
}
