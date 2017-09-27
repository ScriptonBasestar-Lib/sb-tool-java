package org.scriptonbasestar.spring.security.jwt;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @author chaeeung.e
 * @since 2017-09-21
 */
public class SBJwtAuthenticationToken extends AbstractAuthenticationToken {

	public SBJwtAuthenticationToken(SBJwtAuthorizedUser principal, SBUserClaims credentials, Collection<? extends GrantedAuthority> authorities) {
		super(authorities);
		this.principal = principal;
		this.credentials = credentials;
	}

	private final SBJwtAuthorizedUser principal;
	private final SBUserClaims credentials;

	@Override
	public Object getCredentials() {
		return credentials;
	}

	@Override
	public Object getPrincipal() {
		return this.principal;
	}
}
