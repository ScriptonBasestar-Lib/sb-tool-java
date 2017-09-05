package org.scriptonbasestar.tool.crypto;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;

@Slf4j
public class EncryptUtility {

	public final static byte[] ivBytes = { 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00 };

	public static final String AES_Encode(String source, String AESKEY) {
		String rtnValue = "";
		byte[] textBytes;
		try {
			textBytes = source.getBytes("UTF-8");
			AlgorithmParameterSpec ivSpec = new IvParameterSpec(ivBytes);
			SecretKeySpec newKey = new SecretKeySpec(AESKEY.getBytes("UTF-8"), "AES");
			Cipher cipher = null;
			cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, newKey, ivSpec);

			rtnValue = Base64.encodeBase64String(cipher.doFinal(textBytes));
		} catch (UnsupportedEncodingException e) {
			log.debug(e.getMessage());
		} catch (NoSuchAlgorithmException e) {
			log.debug(e.getMessage());
		} catch (NoSuchPaddingException e) {
			log.debug(e.getMessage());
		} catch (InvalidKeyException e) {
			log.debug(e.getMessage());
		} catch (InvalidAlgorithmParameterException e) {
			log.debug(e.getMessage());
		} catch (IllegalBlockSizeException e) {
			log.debug(e.getMessage());
		} catch (BadPaddingException e) {
			log.debug(e.getMessage());
		}

		return rtnValue ;
	}

	public static final String AES_Decode(String source, String AESKEY) {
		String rtnValue = "";
		byte[] textBytes;
		try {
			textBytes = Base64.decodeBase64(source);
			//byte[] textBytes = str.getBytes("UTF-8");
			AlgorithmParameterSpec ivSpec = new IvParameterSpec(ivBytes);
			SecretKeySpec newKey = new SecretKeySpec(AESKEY.getBytes("UTF-8"), "AES");
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, newKey, ivSpec);
			rtnValue = new String(cipher.doFinal(textBytes), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			log.debug(e.getMessage());
		} catch (NoSuchAlgorithmException e) {
			log.debug(e.getMessage());
		} catch (NoSuchPaddingException e) {
			log.debug(e.getMessage());
		} catch (InvalidKeyException e) {
			log.debug(e.getMessage());
		} catch (InvalidAlgorithmParameterException e) {
			log.debug(e.getMessage());
		} catch (IllegalBlockSizeException e) {
			log.debug(e.getMessage());
		} catch (BadPaddingException e) {
			log.debug(e.getMessage());
		}

		return rtnValue ;
	}
}
