package org.scriptonbasestar.tool.crypto.symmetry;

import org.jasypt.encryption.pbe.StandardPBEByteEncryptor;

/**
 * @author archmagece
 * @since 2017-09-07
 * <p>
 * https://en.wikipedia.org/wiki/RC2
 * PBEwithSHA1andRC2_40
 */
public class RC2 implements SBSymmetryService {

	private final StandardPBEByteEncryptor byteEncryptor;

	public RC2(String password){
		byteEncryptor = new StandardPBEByteEncryptor();
		byteEncryptor.setAlgorithm("PBEwithSHA1andRC2_40");
		byteEncryptor.setPassword(password);
		byteEncryptor.initialize();
	}

	@Override
	public byte[] encrypt(byte[] plainTextBytes) {
		if (plainTextBytes == null || plainTextBytes.length == 0)
			return new byte[0];
		return byteEncryptor.encrypt(plainTextBytes);
	}

	@Override
	public byte[] decrypt(byte[] encryptedStringBytes) {
		if (encryptedStringBytes == null || encryptedStringBytes.length == 0)
			return new byte[0];
		return byteEncryptor.decrypt(encryptedStringBytes);
	}
}
