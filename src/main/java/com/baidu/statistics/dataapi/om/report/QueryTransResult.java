package com.baidu.statistics.dataapi.om.report;

/**
 * 如果以 name 为参数请求，则返回的结果中带有 name；
 * 如果以 url 为参数请求，则返回的结果中带有 url。 transformNum 为相应的转化数。
 * @author nianqin
 */
public class QueryTransResult {
	/**
	 * name
	 */
	private String name;
	/**
	 * url
	 */
	private String url;
	/**
	 * 转换数
	 */
	private Integer transformNum;
	
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
	public Integer getTransformNum() {
		return transformNum;
	}
	public void setTransformNum(Integer transformNum) {
		this.transformNum = transformNum;
	} 
}
