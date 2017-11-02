package org.scriptonbasestar.spring.security.jwt.dto;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @author archmagece
 * @since 2017-09-21
 */
public class SBJwtAuthenticationToken extends AbstractAuthenticationToken {

	public SBJwtAuthenticationToken(SBAuthorizedUserClaims principal, Collection<? extends GrantedAuthority> authorities) {
		super(authorities);
		this.principal = principal;
	}

	private final SBAuthorizedUserClaims principal;

	@Override
	public Object getCredentials() {
		return null;
	}

	@Override
	public Object getPrincipal() {
		return this.principal;
	}
}
