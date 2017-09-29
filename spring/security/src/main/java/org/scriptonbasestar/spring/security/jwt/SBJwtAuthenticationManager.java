package org.scriptonbasestar.spring.security.jwt;

import lombok.Setter;
import org.scriptonbasestar.spring.security.auth.SBFindAuthenticationHandler;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.UUID;

/**
 * @author chaeeung.e
 * @since 2017-09-25
 */
public class SBJwtAuthenticationManager implements AuthenticationManager {

	@Setter
	private String signingKey;

	@Setter
	private SBFindAuthenticationHandler authenticationHandler;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		if(authentication instanceof SBJwtAuthenticationToken){
			return authentication;
		}
		SBUserClaims claims = SBJwtUtil.getBody(signingKey, authentication.getCredentials().toString());

		Collection<GrantedAuthority> authorities = authenticationHandler.authority(claims.getUserRoles());
		SBJwtAuthorizedUser user = new SBJwtAuthorizedUser(claims.getUserId(), claims.getUserNickname(), claims.getUserUsername(),
				UUID.randomUUID().toString(), authorities
		);

		return new SBJwtAuthenticationToken(user, claims, authorities);
	}

}
