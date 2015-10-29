package com.baidu.statistics.dataapi.om.profile;

/**
 * 
 * @author nianqin
 */
public class SiteConf {
	public static final int FLAG_WHILE_LIST = 0; //白名单
	public static final int FLAG_BLACK_LIST = 1; //黑名单
	/**
	 * flag 表示黑白名单（ 0：白名单， 1：黑名单；
	 * Site类中的type 为站点时， flag 为 0
	 */
	private Integer flag;
	/**
	 * 表示站点域名或者子目录配置的 url
	 */
	private String pattern;
	
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	public String getPattern() {
		return pattern;
	}
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
}
