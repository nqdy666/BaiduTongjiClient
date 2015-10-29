package com.baidu.statistics.dataapi.om.profile;

import java.util.List;

import com.baidu.statistics.dataapi.core.ApiResponse;

public class GetsitesResponse extends ApiResponse {
	private List<Site> sites;

	public List<Site> getSites() {
		return sites;
	}
	public void setSites(List<Site> sites) {
		this.sites = sites;
	}
}
