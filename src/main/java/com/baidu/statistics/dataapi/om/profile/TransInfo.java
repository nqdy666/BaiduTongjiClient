package com.baidu.statistics.dataapi.om.profile;

/**
 * 如果以 name 为参数请求，则返回的结果中带有 name；如果以 url 为参数请求，则返回
 * 的结果中带有 url。 mode 为转化记录方式（ 0 代表：按 PV， 1 代表：按访问次数， 2 代表：
 * 按参数，如：订单转化）。 expt_revenue 是预期收入。 expt_trans_rate 是预期转化率。
 * is_path_necessary 代表是否是必须经过路径。 Status 代表转化的状态（ 0：正常， 1：暂停， 2：
 * 删除）。
 * @author nianqin
 */
public class TransInfo {
	/**
	 * 如果以 name 为参数请求，则返回的结果中带有 name
	 */
	private String name;
	/**
	 * 如果以 url 为参数请求，则返回的结果中带有 url
	 */
	private String url;
	/**
	 * mode 为转化记录方式（ 0 代表：按 PV， 1 代表：按访问次数， 2 代表：按参数，如：订单转化）
	 */
	private Integer mode;
	/**
	 * 预期收入
	 */
	private Integer expt_revenue;
	/**
	 * 预期转化率
	 */
	private Integer expt_trans_rate;
	/**
	 * 代表是否是必须经过路径
	 */
	private Integer is_path_necessary;
	/**
	 * Status 代表转化的状态（ 0：正常， 1：暂停， 2：删除）。
	 */
	private Integer status;
	
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
	public Integer getMode() {
		return mode;
	}
	public void setMode(Integer mode) {
		this.mode = mode;
	}
	public Integer getExpt_revenue() {
		return expt_revenue;
	}
	public void setExpt_revenue(Integer expt_revenue) {
		this.expt_revenue = expt_revenue;
	}
	public Integer getExpt_trans_rate() {
		return expt_trans_rate;
	}
	public void setExpt_trans_rate(Integer expt_trans_rate) {
		this.expt_trans_rate = expt_trans_rate;
	}
	public Integer getIs_path_necessary() {
		return is_path_necessary;
	}
	public void setIs_path_necessary(Integer is_path_necessary) {
		this.is_path_necessary = is_path_necessary;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
}
