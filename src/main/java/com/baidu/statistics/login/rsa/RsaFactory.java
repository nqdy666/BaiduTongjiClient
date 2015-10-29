package com.baidu.statistics.login.rsa;

public class RsaFactory {
	private static Rsa rsa;
	
	public Rsa getRsa() {
		if (rsa == null) {
			rsa = new RsaImpl();
		}
		return rsa;
	}
}
