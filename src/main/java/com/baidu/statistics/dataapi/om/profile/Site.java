package com.baidu.statistics.dataapi.om.profile;

import java.util.List;

/**
 * 其中 type 表示是否是子目录； conf 为一个数组，若是子目录且子目录配置了多条规则，
 * conf 数组就有多个元素，否则只有一个元素； 
 * SiteConf中的flag 表示黑白名单（ 0：白名单， 1：黑名单；type 为站点时， flag 为 0）； 
 * SiteConf中的pattern 表示站点域名或者子目录配置的 url 规则。
 * @author nianqin
 */
public class Site {
	/**
	 * siteid
	 */
	private Integer siteid;
	/**
	 * 是否是子目录
	 */
	private Integer type;
	/**
	 * 数组就有多个元素，否则只有一个元素
	 */
	private List<SiteConf> conf;
	
	public Integer getSiteid() {
		return siteid;
	}
	public void setSiteid(Integer siteid) {
		this.siteid = siteid;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public List<SiteConf> getConf() {
		return conf;
	}
	public void setConf(List<SiteConf> conf) {
		this.conf = conf;
	}
}
