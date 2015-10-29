package com.baidu.statistics.login.om;

public class Question {
	/**
	 * 安全问题id
	 */
	private Integer qid;
	/**
	 * 安全问题字面
	 */
	private String content;
	
	public Integer getQid() {
		return qid;
	}
	public void setQid(Integer qid) {
		this.qid = qid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
