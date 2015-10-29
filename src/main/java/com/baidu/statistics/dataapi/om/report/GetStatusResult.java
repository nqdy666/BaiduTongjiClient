package com.baidu.statistics.dataapi.om.report;

/**
 * 其中 status 为生成状态（ 0：无效， 1：报告结果生成中， 2：生成失败， 3 已生成、可下载），
 * 当状态为已生成、可下载的时候， result_url 就是可以下载报告结果的 URL 地址，只
 * 有当 status 为 3 的时候 result_url 才非空。
 * @author nianqin
 */
public class GetStatusResult {
	public static final Integer STATUS_INVALID = 0; //无效
	public static final Integer STATUS_GENERATIN = 1; //报告结果生成中
	public static final Integer STATUS_FAILED = 2; //生成失败
	public static final Integer STATUS_SUCCESS = 3; //已生成、可下载
	/**
	 * 结果ID
	 */
	private String result_id;
	/**
	 * 生成状态（ 0：无效， 1：报告结果生成中， 2：生成失败， 3 已生成、可下载）
	 */
	private Integer status;
	/**
	 * 消息
	 */
	private String message;
	/**
	 * 当状态为已生成、可下载的时候，下载报告结果的 URL 地址
	 */
	private String result_rul;
	
	public String getResult_id() {
		return result_id;
	}
	public void setResult_id(String result_id) {
		this.result_id = result_id;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getResult_rul() {
		return result_rul;
	}
	public void setResult_rul(String result_rul) {
		this.result_rul = result_rul;
	}
}
