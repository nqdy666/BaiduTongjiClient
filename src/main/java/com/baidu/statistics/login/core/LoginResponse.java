package com.baidu.statistics.login.core;

public class LoginResponse<T extends RealDataLoginResponse> {
	/**
	 * 表明成功与否及错误的具体代码
	 */
	private int returnCode;
	/**
	 * 加密版本
	 */
	private int encryptVersion;
	/**
	 * 保留字段1
	 */
	private int resevred;
	/**
	 * 保留字段2
	 */
	private int resevred2;
	/**
	 * 真实的返回数据
	 */
	private T realData;
	
	public int getReturnCode() {
		return returnCode;
	}
	public void setReturnCode(int returnCode) {
		this.returnCode = returnCode;
	}
	public int getEncryptVersion() {
		return encryptVersion;
	}
	public void setEncryptVersion(int encryptVersion) {
		this.encryptVersion = encryptVersion;
	}
	public int getResevred() {
		return resevred;
	}
	public void setResevred(int resevred) {
		this.resevred = resevred;
	}
	public int getResevred2() {
		return resevred2;
	}
	public void setResevred2(int resevred2) {
		this.resevred2 = resevred2;
	}
	public T getRealData() {
		return realData;
	}
	public void setRealData(T realData) {
		this.realData = realData;
	}
}
