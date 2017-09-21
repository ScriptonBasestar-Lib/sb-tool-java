package org.scriptonbasestar.tool.crypto.password;

/**
 * @author chaeeung.e
 * @since 2017-09-07
 */
public interface SBPasswordEncoder {
	String encrypt(String plainString);
	boolean equalThat(String encryptedString, String plainString);
}
