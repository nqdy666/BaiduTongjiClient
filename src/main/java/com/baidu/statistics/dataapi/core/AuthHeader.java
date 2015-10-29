package com.baidu.statistics.dataapi.core;

import com.baidu.statistics.config.Config;
import com.baidu.statistics.config.ConfigFactory;

/**
 * 注意：此时AuthHeader中的password是成功登陆之后获得的会话id(st)，而不是账号密码。
 * @author nianqin
 */
public class AuthHeader {
	/**
	 * 用户名（必填）
	 */
	private String username;
	/**
	 * 成功登录后获取的会话 id(st)（必填）
	 */
	private String password;
	/**
	 * api 权限码（必填）
	 */
	private String token;
	/**
	 * 被操作用户名（选填，一期无效）
	 */
	private String target;
	/**
	 * oauth access token（选填，一期无效）
	 */
	private String accessToken;
	/**
	 * 账户类型（必填）
	 * 1：站长账号
	 * 2：凤巢账号 
	 * 3：联盟账号
	 * 4：哥伦布账号
	 */
	private Integer account_type;
	
	public AuthHeader() {
		super();
	}

	public AuthHeader(String password) {
		super();
		this.password = password;
		initPartDataUseConfig();
	}

	public void initPartDataUseConfig() {
		Config config = new ConfigFactory().getConfig();
		this.username = config.getString(Config.K_USERNAME);
		this.token = config.getString(Config.K_TOKEN);
		this.account_type = config.getInteger(Config.K_ACCOUNT_TYPE);
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public Integer getAccount_type() {
		return account_type;
	}
	public void setAccount_type(Integer account_type) {
		this.account_type = account_type;
	}
}
