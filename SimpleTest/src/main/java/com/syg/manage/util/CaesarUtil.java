package com.syg.manage.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * Caesar加解密算法实现
 * {@docRoot 加密算法：对明文的每个字符加上密钥，然后对256取模}
 * {@docRoot 解密算法：对密文的每个字符减掉密钥}
 * {@docRoot 密钥：1-255的数字}
 * @author Samuel Gavin
 *
 */
public class CaesarUtil {
	private final int SECRET_KEY;
	public CaesarUtil(int secretKey) {
		SECRET_KEY = secretKey;
	}
	
	/**
	 * 加密 对明文的每个字符加上密钥，然后对256取模
	 * @param beforeEncrypt 明文
	 * @return
	 */
	public String encrypt(String beforeEncrypt) {
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < beforeEncrypt.length(); i++) {
			result.append((char) ((beforeEncrypt.charAt(i) + SECRET_KEY) % 256));
		}
		return result.toString();
	}
	
	/**
	 * 解密 对密文的每个字符减掉密钥
	 * @param afterEncrypt 密文
	 * @return
	 */
	public String decrypt(String afterEncrypt) {
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < afterEncrypt.length(); i++) {
			result.append((char) (afterEncrypt.charAt(i) - SECRET_KEY));
		}
		return result.toString();
	}
	
	public static void main(String...args) {
		CaesarUtil util = new CaesarUtil(4);
		Resource res = new ClassPathResource("init.cla");
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(res.getInputStream()));
			String content;
			while ((content = reader.readLine()) != null) {
				System.out.println(util.decrypt(content));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(util.decrypt("qereki2hvmzivGpewwReqiAgsq2q}wup2nhfg2Hvmziv"));
		System.out.println(util.decrypt("qereki2yvpAnhfg>q}wup>335=625:<262::>774:3jmwlcqerekicxiwxCywiYrmgshiAxvyi*glevegxivIrgshmrkAyxj1<"));
		System.out.println(util.decrypt("qereki2ywivreqiAvssx"));
		System.out.println(util.decrypt("qereki2teww{svhAtowk6455"));
	}
	
}
