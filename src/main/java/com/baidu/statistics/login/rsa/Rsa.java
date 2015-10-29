package com.baidu.statistics.login.rsa;

import java.io.File;

/**
 * rsa相关操作
 * @author nianqin
 */
public interface Rsa {
	
	public void loadPublicKeyFromFile(File publicKeyPemFile) throws Exception;
	public void loadPrivateKeyFromFile(File privateKeyPemFile) throws Exception;
	public String encrypt(String data) throws Exception;
	public String encrypt(String data, String enc) throws Exception;
	public byte[] encrypt(byte[] data) throws Exception;
	public String decrypt(String data) throws Exception;
	public String decrypt(String data, String enc) throws Exception;
	public byte[] decrypt(byte[] raw) throws Exception;
}
