package com.depromeet.tmp.util;

import java.security.MessageDigest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EncryptionUtils {

	public static String encryptSHA256(String s) {
		return encrypt(s, "SHA-256");
	}

	private static String encrypt(String s, String messageDigest) {
		try {
			MessageDigest md = MessageDigest.getInstance(messageDigest);
			byte[] passBytes = s.getBytes();
			md.reset();
			byte[] digested = md.digest(passBytes);
			StringBuffer sb = new StringBuffer();
			for(int i = 0; i < digested.length; ++i)
				sb.append(Integer.toHexString(0xff & digested[i]));
			return sb.toString();
		}
		catch (Exception e) {
			log.error("EncryptionUtils Error Message : {}", e.toString());
			return s;
		}
	}

}
