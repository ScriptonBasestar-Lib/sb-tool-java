package org.scriptonbasestar.tool.crypto;

import org.apache.commons.codec.binary.Base64;
import org.scriptonbasestar.tool.core.exception.runtime.SBCryptoException;

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
			throw new SBCryptoException("지원하지 않는 인코딩", e);
		} catch (NoSuchAlgorithmException e) {
			throw new SBCryptoException("알 수 없는 알고리즘", e);
		} catch (NoSuchPaddingException e) {
			throw new SBCryptoException("패딩이 없음", e);
		} catch (InvalidKeyException e) {
			throw new SBCryptoException("키가 잘못됨", e);
		} catch (InvalidAlgorithmParameterException e) {
			throw new SBCryptoException("잘못된 알고리즘 파라미터", e);
		} catch (IllegalBlockSizeException e) {
			throw new SBCryptoException("블록 사이즈가 잘못됨", e);
		} catch (BadPaddingException e) {
			throw new SBCryptoException("K2노스페이스 오류", e);
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
			throw new SBCryptoException("지원하지 않는 인코딩", e);
		} catch (NoSuchAlgorithmException e) {
			throw new SBCryptoException("알 수 없는 알고리즘", e);
		} catch (NoSuchPaddingException e) {
			throw new SBCryptoException("패딩이 없음", e);
		} catch (InvalidKeyException e) {
			throw new SBCryptoException("키가 잘못됨", e);
		} catch (InvalidAlgorithmParameterException e) {
			throw new SBCryptoException("잘못된 알고리즘 파라미터", e);
		} catch (IllegalBlockSizeException e) {
			throw new SBCryptoException("블록 사이즈가 잘못됨", e);
		} catch (BadPaddingException e) {
			throw new SBCryptoException("K2노스페이스 오류", e);
		}

		return rtnValue ;
	}
}
