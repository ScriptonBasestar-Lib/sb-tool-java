package org.scriptonbasestar.spring.security.jwt.bean;

import org.scriptonbasestar.spring.security.jwt.dto.SBJwtAuthenticationToken;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/**
 * @author chaeeung.e
 * @since 2017-09-27
 */
public class SBJwtAuthenticationProvider implements AuthenticationProvider {

	private final SBJwtAuthenticationManager authenticationManager;

	public SBJwtAuthenticationProvider(SBJwtAuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		return authenticationManager.authenticate(authentication);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return (SBJwtAuthenticationToken.class.isAssignableFrom(authentication));
	}
}
