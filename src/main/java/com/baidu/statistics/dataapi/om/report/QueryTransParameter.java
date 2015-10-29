package com.baidu.statistics.dataapi.om.report;

import java.util.List;

import com.baidu.statistics.dataapi.core.ParameterType;

public class QueryTransParameter extends ParameterType {
	/**
	 * 站点的 siteid（必填）
	 * 取值范围：
	 * 用户名下的 siteid，可通过profileService 的 getsites 方法查询
	 */
	private Integer siteid;
	/**
	 * 转化名
	 * name 和 url 必填其一
	 */
	private String name;
	/**
	 * 转化页面
	 * name 和 url 必填其一
	 * 取值范围: 字符， SQL 能接受的通配符
	 */
	private String url;
	/**
	 * 开始时间（必填）
	 * 格式为 YYYYmmddHHiiss，例如：20130218000000
	 * 不大于当前时间
	 */
	private String start_time;
	/**
	 * 结束时间（必填）
	 * 格式为 YYYYmmddHHiiss，例如：20130218000000
	 * 不大于当前时间，不小于 start_time
	 * end_time 与 start_time 间隔不超过一年
	 */
	private String end_time;
	/**
	 * 查询的指标（选填）
	 * 取值范围：
	 * 用户名下的 targetid 可通过
	 * profileService 的 get_trans_info 方法查询
	 */
	private List<String> dimensions;
	/**
	 * 查询的指标 （必填）
	 * 取值范围：transformNum 转化数
	 */
	private List<String> metrics;
	/**
	 * 取值范围：（选填）
	 * newVisitor=1 新访客，2 老访客
	 */
	private List<String> filters;
	/**
	 * 过滤条件（选填）
	 * 取值范围：
	 *　transformNum 转化数
	 * 排序方式可以是 asc 正序（默认值）desc 逆序
	 */
	private List<String> sort;
	/**
	 * 开始游标（必填）
	 * ≥0
	 */
	private Integer start_index;
	/**
	 * 最大返回记录数 （必填）
	 */
	private Integer max_results;
	
	public Integer getSiteid() {
		return siteid;
	}
	public void setSiteid(Integer siteid) {
		this.siteid = siteid;
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
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public List<String> getDimensions() {
		return dimensions;
	}
	public void setDimensions(List<String> dimensions) {
		this.dimensions = dimensions;
	}
	public List<String> getMetrics() {
		return metrics;
	}
	public void setMetrics(List<String> metrics) {
		this.metrics = metrics;
	}
	public List<String> getFilters() {
		return filters;
	}
	public void setFilters(List<String> filters) {
		this.filters = filters;
	}
	public List<String> getSort() {
		return sort;
	}
	public void setSort(List<String> sort) {
		this.sort = sort;
	}
	public Integer getStart_index() {
		return start_index;
	}
	public void setStart_index(Integer start_index) {
		this.start_index = start_index;
	}
	public Integer getMax_results() {
		return max_results;
	}
	public void setMax_results(Integer max_results) {
		this.max_results = max_results;
	}
}
