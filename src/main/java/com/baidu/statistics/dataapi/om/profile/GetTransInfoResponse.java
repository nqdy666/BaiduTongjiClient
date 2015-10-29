package com.baidu.statistics.dataapi.om.profile;

import java.util.List;

import com.baidu.statistics.dataapi.core.ApiResponse;

public class GetTransInfoResponse extends ApiResponse {
	/**
	 * 查询相关参数（必填）JSON 格式
	 */
	List<TransInfo> trans_info;
}
