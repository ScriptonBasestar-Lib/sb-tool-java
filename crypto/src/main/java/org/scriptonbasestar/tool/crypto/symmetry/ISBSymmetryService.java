package org.scriptonbasestar.tool.crypto.symmetry;

/**
 * @author archmagece
 * @since 2017-09-07
 */
public interface ISBSymmetryService {
	byte[] encrypt(byte[] plainTextBytes);

	byte[] decrypt(byte[] encryptedStringBytes);
}
