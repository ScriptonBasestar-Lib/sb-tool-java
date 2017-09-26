package org.scriptonbasestar.spring.security.jwt;

import lombok.Setter;
import org.scriptonbasestar.spring.security.auth.SBFindAuthenticationHandler;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/**
 * @author chaeeung.e
 * @since 2017-09-25
 */
public class JwtAuthenticationManager implements AuthenticationManager{

	@Setter
	private String signingKey;

	@Setter
	private SBFindAuthenticationHandler authenticationHandler;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		SBClaimsDto claims = SBJwtUtil.getBody(signingKey, authentication.getCredentials().toString());

		return new SBJwtAuthenticationToken(claims, authenticationHandler.authority(claims.getUserRoles()));
	}

}
