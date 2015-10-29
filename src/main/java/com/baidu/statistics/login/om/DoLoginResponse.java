package com.baidu.statistics.login.om;

import java.util.List;

import com.baidu.statistics.login.core.RealDataLoginResponse;

/**
 * 统计API的登录服务不触发密保问题策略，当用户调用统计的预登录返回retcode为191（需要回答密保问题）时，请联系管理员。
 * @author nianqin
 */
public class DoLoginResponse extends RealDataLoginResponse {
	public static final Integer RETCODE_OK = 0; //成功
	public static final Integer RETCODE_FORCED_CHANGE_PASSWORD = 134; //强制修改密码
	public static final Integer RETCODE_USER_LOCKED = 135; //用户被锁定
	public static final Integer RETCODE_IP_FORBIDDEN = 3; //登录 IP 被封禁
	public static final Integer RETCODE_USER_NOT_EXIST = 133; //用户不存在
	public static final Integer RETCODE_USER_OR_PASSWORD_ERROR = 132; //用户名或密码错误
	public static final Integer RETCODE_NEED_ANSWER_QUESTIONS = 191; //需要回答密保问题
	/**
	 * 登录返回码 
	 * 0:成功， 134:强制修改密码， 135:用户被锁定，
	 * 3：登录 IP 被封禁， 133：用户不存在， 132：用户名或密码错误，
	 * 191： 需要回答密保问题。
	 * 其他 code 请联系管理员
	 */
	private Integer retcode;
	/**
	 * 错误信息
	 */
	private String retmsg;
	/**
	 * 用户 id
	 * 用户需记录该信息，后续请求统计 API 需要
	 */
	private Integer ucid;
	/**
	 * 会话 Id
	 * 用户需记录该信息，后续请求统计 API 需要
	 */
	private String st;
	/**
	 * 是否是 token 登陆用户
	 */
	private Integer istoken;
	/**
	 * 是否需要设置 Pin 码
	 */
	private Integer setpin;
	/**
	 * 安全问题列表
	 */
	private List<Question> questions;
	public Integer getRetcode() {
		return retcode;
	}
	public void setRetcode(Integer retcode) {
		this.retcode = retcode;
	}
	public String getRetmsg() {
		return retmsg;
	}
	public void setRetmsg(String retmsg) {
		this.retmsg = retmsg;
	}
	public Integer getUcid() {
		return ucid;
	}
	public void setUcid(Integer ucid) {
		this.ucid = ucid;
	}
	public String getSt() {
		return st;
	}
	public void setSt(String st) {
		this.st = st;
	}
	public Integer getIstoken() {
		return istoken;
	}
	public void setIstoken(Integer istoken) {
		this.istoken = istoken;
	}
	public Integer getSetpin() {
		return setpin;
	}
	public void setSetpin(Integer setpin) {
		this.setpin = setpin;
	}
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
}
