package com.baidu.statistics.dataapi.core;

import java.util.List;

import com.baidu.statistics.dataapi.om.profile.Failure;

public class ResHeader {
	/**
	 * 响应描述
	 */
	private String desc;
	/**
	 * 失败信息
	 */
	private List<Failure> failures;
	/**
	 * 操作数
	 */
	private Integer oprs;
	/**
	 * 请求耗时
	 */
	private Integer oprtime;
	/**
	 * 请求消耗的配额数
	 */
	private Integer quota;
	/**
	 * 剩余配额数
	 */
	private Integer rquota;
	/**
	 * 响应状态
	 */
	private Integer status;
	
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public List<Failure> getFailures() {
		return failures;
	}
	public void setFailures(List<Failure> failures) {
		this.failures = failures;
	}
	public Integer getOprs() {
		return oprs;
	}
	public void setOprs(Integer oprs) {
		this.oprs = oprs;
	}
	public Integer getOprtime() {
		return oprtime;
	}
	public void setOprtime(Integer oprtime) {
		this.oprtime = oprtime;
	}
	public Integer getQuota() {
		return quota;
	}
	public void setQuota(Integer quota) {
		this.quota = quota;
	}
	public Integer getRquota() {
		return rquota;
	}
	public void setRquota(Integer rquota) {
		this.rquota = rquota;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
}
