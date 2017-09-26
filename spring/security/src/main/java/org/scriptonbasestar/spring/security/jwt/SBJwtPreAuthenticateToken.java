package org.scriptonbasestar.spring.security.jwt;

import org.springframework.security.authentication.AbstractAuthenticationToken;

/**
 * @author chaeeung.e
 * @since 2017-09-26
 */
public class SBJwtPreAuthenticateToken extends AbstractAuthenticationToken {

//	private static final String EMPTY_CREDENTIALS = "no-credentials";

	/**
	 * token
	 * @param credentials
	 */
	public SBJwtPreAuthenticateToken(String credentials) {
		super(null);
		this.principal = null;
		this.credentials = credentials;
	}

	private final Object principal;
	private final String credentials;

	@Override
	public Object getCredentials() {
		return credentials;
	}

	@Override
	public Object getPrincipal() {
		return this.principal;
	}
}
