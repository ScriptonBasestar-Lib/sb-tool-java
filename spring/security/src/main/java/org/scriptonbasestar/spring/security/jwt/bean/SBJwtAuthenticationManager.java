package org.scriptonbasestar.spring.security.jwt.bean;

import org.scriptonbasestar.spring.security.auth.SBFindUserAuthorityService;
import org.scriptonbasestar.spring.security.jwt.NoRoleAuthenticationException;
import org.scriptonbasestar.spring.security.jwt.dto.SBUserClaims;
import org.scriptonbasestar.spring.security.jwt.SBJwtUtil;
import org.scriptonbasestar.spring.security.jwt.dto.SBJwtAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @author chaeeung.e
 * @since 2017-09-25
 */
public class SBJwtAuthenticationManager implements AuthenticationManager {

	private final String signingKey;
	private final SBFindUserAuthorityService findUserAuthorityService;

	public SBJwtAuthenticationManager (String signingKey, SBFindUserAuthorityService findUserAuthorityService){
		this.signingKey = signingKey;
		this.findUserAuthorityService = findUserAuthorityService;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		if(authentication instanceof SBJwtAuthenticationToken){
			return authentication;
		}
		SBUserClaims claims = SBJwtUtil.getBody(signingKey, authentication.getCredentials().toString());
		if(claims.getUserRoles()==null){
			throw new NoRoleAuthenticationException("No roles for service..");
		}
		Collection<GrantedAuthority> authorities = findUserAuthorityService.findGrantedAuthority(claims.getUserRoles().toArray(new String[]{}));
		return new SBJwtAuthenticationToken(claims, authorities);
	}

}
