package org.scriptonbasestar.spring.security.jwt;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @author chaeeung.e
 * @since 2017-09-21
 */
public class SBJwtAuthenticationToken extends AbstractAuthenticationToken {

	private static final String EMPTY_CREDENTIALS = "no-credentials";

	public SBJwtAuthenticationToken(String credentials) {
		super(null);
		this.principal = null;
		this.credentials = credentials;
	}

	public SBJwtAuthenticationToken(SBClaimsDto principal, Collection<? extends GrantedAuthority> authorities) {
		super(authorities);
		this.principal = principal;
		this.credentials = EMPTY_CREDENTIALS;
	}

	private final SBClaimsDto principal;
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
