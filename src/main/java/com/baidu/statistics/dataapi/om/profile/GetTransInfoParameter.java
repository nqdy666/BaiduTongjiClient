package com.baidu.statistics.dataapi.om.profile;

import com.baidu.statistics.dataapi.core.ParameterType;

public class GetTransInfoParameter extends ParameterType {
	/**
	 * 转化名
	 * name 和 url 必填其一
	 */
	private String name;
	/**
	 * 转化页面
	 * name 和 url 必填其一取值范围：字符和 SQL 通配符
	 * Sql 通配符说明：
	 * 通配符                              			描述
	 *  %           				替代一个或多个字符
	 *	_           				仅替代一个字符
	 *	[charlist]  				字符列中的任何单一字符
	 *	[^charlist]或者[!charlist]  不在字符列中的任何单一字符
	 */
	private String url;
	
	public GetTransInfoParameter() {
		super();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
