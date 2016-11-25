package org.hotnosh.nut.common.utils;

import java.security.MessageDigest;

/**
 * md5算法的util
 * 
 * @author lilin
 *
 */
public class EncodeUtil {

	private static final String DefaultCharset = "utf-8";

	public static String getMd5Code(String content, String key) throws Exception {
		if (null == content) {
			return null;
		}
		if (null == key) {
			key = "";
		}
		String toMd5str = content + key;
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(toMd5str.getBytes(DefaultCharset));
		StringBuilder buf = new StringBuilder();
		for (byte b : md.digest()) {
			buf.append(String.format("%02x", b & 0xff));
		}
		return buf.toString();
	}

	public static String getSha1Code(String content) throws Exception { 
		MessageDigest digest = MessageDigest.getInstance("SHA-1");
		digest.update(content.getBytes(DefaultCharset));
		StringBuilder builder = new StringBuilder();

		for (byte b : digest.digest()) {
			String shaHex = Integer.toHexString(b & 0xFF);
			if (shaHex.length() < 2) {
				builder.append(0);
			}
			builder.append(shaHex);
		}
		return builder.toString();
	}

	public static void main(String[] args) throws Exception {
		String PasswordMd5Key = "<~E3},!V:j?fupB{-.J|n_>[y1%\"WSt+75lRvDIZ";
		String str1 = EncodeUtil.getMd5Code("admin1234", PasswordMd5Key);
		String str2 = EncodeUtil.getMd5Code("adsadsadsaad", "123");
		System.out.println(str1);
		System.out.println(str2);
		
		String str3 = EncodeUtil.getSha1Code("admin");
		String str4 = EncodeUtil.getSha1Code("123456");
		System.out.println("str3="+str3);
		System.out.println("str4="+str4);
		
		System.out.println("--------------------------");
		String str5 = EncodeUtil.getMd5Code(EncodeUtil.getSha1Code("admin"), PasswordMd5Key);
		System.out.println(str5);
	}

}
