package com.baidu.httpclient;

import java.io.IOException;

/**
 * 服务器错误异常
 * @author qjzd
 */
public class ServerErrorException extends IOException {

	private static final long serialVersionUID = -2816273060824588205L;

	public ServerErrorException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ServerErrorException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ServerErrorException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ServerErrorException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
