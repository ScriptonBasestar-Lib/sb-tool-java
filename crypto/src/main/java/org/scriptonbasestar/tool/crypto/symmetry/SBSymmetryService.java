package org.scriptonbasestar.tool.crypto.symmetry;

/**
 * @author chaeeung.e
 * @since 2017-09-07
 */
public interface SBSymmetryService {
	String encrypt(String plainText);
	String decrypt(String encryptedString);
}
