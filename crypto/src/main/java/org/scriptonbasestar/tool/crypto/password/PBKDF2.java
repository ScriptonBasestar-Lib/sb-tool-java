package org.scriptonbasestar.tool.crypto.password;

/**
 * @author archmagece
 * @since 2017-09-07
 */
public class PBKDF2 implements SBPasswordEncoder{
	@Override
	public String encrypt(String plainString) {
		return null;
	}

	@Override
	public boolean equalThat(String encryptedString, String plainString) {
		return false;
	}
}
