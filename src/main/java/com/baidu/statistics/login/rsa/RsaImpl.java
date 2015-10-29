package com.baidu.statistics.login.rsa;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.pkcs.RSAPrivateKeyStructure;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/**
 * 证书文件解析参考
 * http://blog.csdn.net/chaijunkun/article/details/7275632/
 * @author nianqin
 */
public class RsaImpl implements Rsa {
	
	private PublicKey publicKey;
	private PrivateKey privateKey;
	
	private final String DEFAULT_ENC = "UTF-8";
	
	/**
	 * 从文件中加载公钥
	 * @param publicKeyPemFile
	 * @throws Exception
	 */
    public void loadPublicKeyFromFile(File publicKeyPemFile) throws Exception{
    	if (publicKeyPemFile == null || !publicKeyPemFile.exists()) {
    		throw new IllegalArgumentException("公钥证书文件不存在");
    	}
    	loadPublicKey(new FileInputStream(publicKeyPemFile));
    }
    
    /**
     * 从文件中加载私钥
     * @param privateKeyPemFile
	 * @throws Exception
     */
    public void loadPrivateKeyFromFile(File privateKeyPemFile) throws Exception{
    	if (privateKeyPemFile == null || !privateKeyPemFile.exists()) {
    		throw new IllegalArgumentException("私钥证书文件不存在");
    	}
    	loadPrivateKey(new FileInputStream(privateKeyPemFile));
    }
    
	/**
	 * 从文件中输入流中加载公钥
	 * @param in 公钥输入流
	 * @throws Exception 加载公钥时产生的异常
	 */
    private void loadPublicKey(InputStream in) throws Exception {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String readLine = null;
			StringBuilder sb = new StringBuilder();
			while ((readLine = br.readLine()) != null) {
				if (readLine.charAt(0) == '-') {
					continue;
				} else {
					sb.append(readLine);
					sb.append('\r');
				}
			}
			loadPublicKey(sb.toString());
		} catch (IOException e) {
			throw new Exception("公钥数据流读取错误");
		} catch (NullPointerException e) {
			throw new Exception("公钥输入流为空");
		} finally {
			if (in != null) {
				in.close();
			}
		}
	}

	/**
	 * 从字符串中加载公钥
	 * @param publicKeyStr 公钥数据字符串
	 * @throws Exception 加载公钥时产生的异常
	 */
	private void loadPublicKey(String publicKeyStr) throws Exception {
		try {
			byte[] buffer = Base64.decodeBase64(publicKeyStr);
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			X509EncodedKeySpec keySpec = new X509EncodedKeySpec(buffer);
			publicKey = (RSAPublicKey) keyFactory.generatePublic(keySpec);
		} catch (NoSuchAlgorithmException e) {
			throw new Exception("无此算法");
		} catch (InvalidKeySpecException e) {
			throw new Exception("公钥非法");
		} catch (NullPointerException e) {
			throw new Exception("公钥数据为空");
		}
	}

	/**
	 * 从文件中加载私钥
	 * @param keyFileName 私钥文件名
	 * @return 是否成功
	 * @throws Exception
	 */
	private void loadPrivateKey(InputStream in) throws Exception {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String readLine = null;
			StringBuilder sb = new StringBuilder();
			while ((readLine = br.readLine()) != null) {
				if (readLine.charAt(0) == '-') {
					continue;
				} else {
					sb.append(readLine);
					sb.append('\r');
				}
			}
			loadPrivateKey(sb.toString());
		} catch (IOException e) {
			throw new Exception("私钥数据读取错误");
		} catch (NullPointerException e) {
			throw new Exception("私钥输入流为空");
		} finally {
			if (in != null) {
				in.close();
			}
		}
	}

	private void loadPrivateKey(String privateKeyStr) throws Exception {
		try {
			byte[] buffer = Base64.decodeBase64(privateKeyStr);
			//不经过pkcs8加密的私钥
		    RSAPrivateKeyStructure asn1PrivKey = new RSAPrivateKeyStructure((ASN1Sequence) ASN1Sequence.fromByteArray(buffer));  
		    RSAPrivateKeySpec rsaPrivKeySpec = new RSAPrivateKeySpec(asn1PrivKey.getModulus(), asn1PrivKey.getPrivateExponent());  
		    KeyFactory keyFactory= KeyFactory.getInstance("RSA");  
		    privateKey = (RSAPrivateKey) keyFactory.generatePrivate(rsaPrivKeySpec);  
			
//		    PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(buffer);
//			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
//			privateKey = (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
		} catch (NoSuchAlgorithmException e) {
			throw new Exception("无此算法");
		} catch (InvalidKeySpecException e) {
			throw new Exception("私钥非法");
		} catch (IOException e) {
			throw new Exception("私钥数据内容读取错误");
		} catch (NullPointerException e) {
			throw new Exception("私钥数据为空");
		}
	}
	/**
	 * @Title: getPublicKey
	 * @Description: 获取公钥信息
	 * @return PublicKey
	 */
	public PublicKey getPublicKey() {
		return publicKey;
	}

	/**
	 * @Title: getPrivateKey
	 * @Description: 获取私钥信息
	 * @return PrivateKey
	 */
	public PrivateKey getPrivateKey() {
		return privateKey;
	}

	public String encrypt(String data) throws Exception {
		return encrypt(data, DEFAULT_ENC);
	}
	
	public String encrypt(String data, String enc) throws Exception {
		byte[] enData = encrypt(data.getBytes(enc));
		return Bytes2HexStringV2(enData);
	}
	public String decrypt(String data) throws Exception {
		return decrypt(data, DEFAULT_ENC);
	}
	public String decrypt(String data, String enc) throws Exception {
		byte[] deData = decrypt(HexString2Bytes(data));
		return new StringBuilder(new String(deData, enc)).toString();
	}
	/**
	 * @Title: encrypt
	 * @Description: 加密
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public byte[] encrypt(byte[] data) throws Exception {
		try {
			Cipher cipher = Cipher.getInstance("RSA/None/PKCS1Padding", new BouncyCastleProvider());
//			Cipher cipher = Cipher.getInstance("RSA/None/PKCS1Padding", new BouncyCastleProvider());
//			Cipher cipher = Cipher.getInstance("RSA", new BouncyCastleProvider());
			cipher.init(Cipher.ENCRYPT_MODE, publicKey);
			int blockSize = cipher.getBlockSize();
			// 获得加密块大小，如：加密前数据为128个byte，而key_size=1024
			// 加密块大小为127
			// byte,加密后为128个byte;因此共有2个加密块，第一个127
			// byte第二个为1个byte
			int outputSize = cipher.getOutputSize(data.length);// 获得加密块加密后块大小
			int leavedSize = data.length % blockSize;
			int blocksSize = leavedSize != 0 ? data.length / blockSize + 1 : data.length / blockSize;
			byte[] raw = new byte[outputSize * blocksSize];
			int i = 0;
			while (data.length - i * blockSize > 0) {
				if (data.length - i * blockSize > blockSize)
					cipher.doFinal(data, i * blockSize, blockSize, raw, i * outputSize);
				else
					cipher.doFinal(data, i * blockSize, data.length - i * blockSize, raw, i * outputSize);
				// 这里面doUpdate方法不可用，查看源代码后发现每次doUpdate后并没有什么实际动作除了把byte[]放到
				// ByteArrayOutputStream中，而最后doFinal的时候才将所有的byte[]进行加密，可是到了此时加密块大小很可能已经超出了
				// OutputSize所以只好用dofinal方法。

				i++;
			}
			return raw;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * @Title: decrypt
	 * @Description: 解密
	 * @param raw
	 * @return
	 * @throws Exception
	 */
	public byte[] decrypt(byte[] raw) throws Exception {
		try {
			Cipher cipher = Cipher.getInstance("RSA/None/PKCS1Padding", new BouncyCastleProvider());
//			Cipher cipher = Cipher.getInstance("RSA/None/PKCS1Padding", new BouncyCastleProvider());
//			Cipher cipher = Cipher.getInstance("RSA", new BouncyCastleProvider());
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
			int blockSize = cipher.getBlockSize();
			ByteArrayOutputStream bout = new ByteArrayOutputStream(64);
			int j = 0;

			while (raw.length - j * blockSize > 0) {
				bout.write(cipher.doFinal(raw, j * blockSize, blockSize));
				j++;
			}
			return bout.toByteArray();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	// 从字节数组到十六进制字符串转换
	private String Bytes2HexStringV2(byte[] b) {
		StringBuilder sb=new StringBuilder();
		for (int i = 0; i < b.length; i++) {
			sb.append(Integer.toHexString((b[i] >> 4) & 0x0f));
			sb.append(Integer.toHexString((b[i] & 0x0f)));
		}
		return sb.toString();
	}
	// 从十六进制字符串到字节数组转换
	private byte[] HexString2Bytes(String hexstr) {
		byte[] b = new byte[hexstr.length() / 2];
		int j = 0;
		for (int i = 0; i < b.length; i++) {
			byte c0 =(byte) Character.digit(hexstr.charAt(j++), 16) ;
			byte c1 =(byte) Character.digit(hexstr.charAt(j++), 16) ;
			b[i] = (byte) ((c0 << 4) | c1);
		}
		return b;
	}
}
