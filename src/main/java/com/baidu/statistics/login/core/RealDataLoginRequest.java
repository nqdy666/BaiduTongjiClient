package com.baidu.statistics.login.core;

import com.alibaba.fastjson.annotation.JSONField;

public abstract class RealDataLoginRequest {
	
	@JSONField(serialize=false)
	protected String functionName;

	public String getFunctionName() {
		return functionName;
	}
}
