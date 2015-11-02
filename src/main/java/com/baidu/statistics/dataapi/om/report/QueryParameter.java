package com.baidu.statistics.dataapi.om.report;

import java.util.List;

import com.baidu.statistics.dataapi.core.ParameterType;

public class QueryParameter extends ParameterType {
	/**
	 * 受访页面报告
	 */
	public final static int REPROTID_PAGEVIEW = 1;
	
	/**
	 * 查询报告的 id （必填）
	 * 取值范围：1：受访页面报告
	 */
	private Integer reportid;
	/**
	 * 站点的 siteid（必填）
	 * 取值范围：用户名下的 siteid，可通过profileService 的 getsites 方法查询
	 */
	private Integer siteid;
	/**
	 * 开始时间 （必填）
	 * 格式为 YYYYmmddHHiiss，例如：20130218000000不大于当前时间
	 */
	private String start_time;
	/**
	 * 结束时间（必填）
	 * 格式为 YYYYmmddHHiiss，例如：
	 *	20130218000000
	 *	不大于当前时间
	 *	不小于 start_time
	 *	end_time 与 start_time 间隔不超过一年
	 */
	private String end_time;
	/**
	 * groupby 的维度（选填）
	 * 取值范围：pageid
	 */
	private List<String> dimensions;
	/**
	 * 查询的指标（必填）
	 * 取值范围：
	 * pageviews 浏览量（ PV）
	 * visitors 访客数（ UV）
	 * ips IP 数
	 * entrances 入口页次数
	 * outwards 贡献下游流量
	 * exits 退出页次数
	 * stayTime 平均停留时长
	 * exitRate 退出率
	 */
	private List<String> metrics;
	/**
	 * 过滤条件（选填）
	 * fromType=1 直达
 	 * 2 搜索引擎
 	 * 3 外部链接
	 * newVisitor=1 新访客
 	 * 2 老访客
	 */
	private List<String> filters;
	/**
	 * 排序条件（选填）
	 * 排序的指标必须在查询的指标中
	 * 排序方式可以是 asc 正序（默认值）
	 * desc 逆序
	 */
	private List<String> sort;
	/**
	 * 开始游标（必填）
	 * ≥0
	 */
	private Integer start_index;
	/**
	 * 最大返回记录数（必填）
	 * 取值范围[0, 10000]
	 */
	private Integer max_results;
	
	public Integer getReportid() {
		return reportid;
	}
	public void setReportid(Integer reportid) {
		this.reportid = reportid;
	}
	public Integer getSiteid() {
		return siteid;
	}
	public void setSiteid(Integer siteid) {
		this.siteid = siteid;
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
