package com.baidu.statistics.dataapi.core;

/**
 * 注意： ApiRequest格式取决于不同的服务、方法
 * @author nianqin
 */
public abstract class ApiRequest {
	/**
	 * 服务名（必填）
	 */
	protected String serviceName;
	/**
	 * 方法名（必填）
	 */
	protected String methodName;
	
	public String getServiceName() {
		return serviceName;
	}
	public String getMethodName() {
		return methodName;
	}
}
