package org.scriptonbasestar.tool.crypto.symmetry;

import org.jasypt.encryption.pbe.StandardPBEByteEncryptor;

/**
 * @author archmagece
 * @since 2018-12-07
 */
public class SymmetryServiceImpl implements ISBSymmetryService {

	private final StandardPBEByteEncryptor byteEncryptor;

	public SymmetryServiceImpl(SymmetryAlgorithm symmetryAlgorithm, String password){
		byteEncryptor = new StandardPBEByteEncryptor();
		byteEncryptor.setAlgorithm(symmetryAlgorithm.getVal());
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
