package com.qa.Util;

import java.util.Base64;

public class ElementUtil {

	public String decryptBase64Password(String encryptBase64Password) {
		String decryptedPassword, encryptedPassword;
		encryptedPassword=encryptBase64Password;
		byte[] decryptedPasswordBytes = Base64.getDecoder().decode(encryptedPassword);
		decryptedPassword = new String(decryptedPasswordBytes);
		return decryptedPassword;
		}
}
