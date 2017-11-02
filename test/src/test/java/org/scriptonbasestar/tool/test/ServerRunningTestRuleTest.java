package org.scriptonbasestar.tool.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.security.crypto.codec.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author archmagece
 * @CreatedAt 2016-10-11 20
 */
@Slf4j
public class ServerRunningTestRuleTest {
	@Test
	public void test() throws NoSuchPaddingException, NoSuchAlgorithmException, UnsupportedEncodingException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
		System.out.println(new String(Base64.decode("3q4tgq34tg==".getBytes())));
		System.out.println(new String(Base64.encode("tq3q34y34y==".getBytes())));

		String value;

		String keyString = "34y34ygh3q";
		String initialVectorString= "3yh3qyh3";
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		SecretKeySpec key = new SecretKeySpec(md5.digest(keyString.getBytes("UTF8")), "AES");
		IvParameterSpec initalVector = new IvParameterSpec(md5.digest(initialVectorString.getBytes("UTF8")));
		Cipher rijndael = Cipher.getInstance("AES/CBC/PKCS5Padding");

		//encrypt
		value = "1111111";
		rijndael.init(Cipher.ENCRYPT_MODE, key, initalVector);
		// Get a UTF-8 byte array from a unicode string.
		byte[] utf8Value = value.getBytes("UTF8");
		// Encrypt the UTF-8 byte array.
		byte[] encryptedValue1 = rijndael.doFinal(utf8Value);
		// Return a base64 encoded string of the encrypted byte array.
		System.out.println(new String(Base64.encode(encryptedValue1)));

		//decrypt
		value = "3y4yghq3y==";
		rijndael.init(Cipher.DECRYPT_MODE, key, initalVector);
		// Get an encrypted byte array from a base64 encoded string.
		byte[] encryptedValue2 = Base64.decode(value.getBytes());
		// Decrypt the byte array.
		byte[] decryptedValue2 = rijndael.doFinal(encryptedValue2);
		// Return a string converted from the UTF-8 byte array.
		System.out.println(new String(decryptedValue2, "UTF8"));
	}
}
