package com.baidu.statistics.login.om;

public class AuthCode {
	/**
	 * 图片的格式, 如JPG
	 */
	private String imgtype;
	/**
	 * 图片的二进制内容,base64编码
	 */
	private String imgdata;
	/**
	 * 图片会话id
	 */
	private String imgssid;
	
	public String getImgtype() {
		return imgtype;
	}
	public void setImgtype(String imgtype) {
		this.imgtype = imgtype;
	}
	public String getImgdata() {
		return imgdata;
	}
	public void setImgdata(String imgdata) {
		this.imgdata = imgdata;
	}
	public String getImgssid() {
		return imgssid;
	}
	public void setImgssid(String imgssid) {
		this.imgssid = imgssid;
	}
}
