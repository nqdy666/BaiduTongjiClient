package com.baidu.statistics.dataapi.svc;

public abstract class Base {
	protected Integer ucid;
	protected String st;
	
	public Base(Integer ucid, String st) {
		this.ucid = ucid;
		this.st = st;
	}
	
	public Integer getUcid() {
		return ucid;
	}
	public String getSt() {
		return st;
	}
}
