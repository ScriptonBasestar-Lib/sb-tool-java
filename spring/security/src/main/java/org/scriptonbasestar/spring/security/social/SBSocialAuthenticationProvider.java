package org.scriptonbasestar.spring.security.social;

import org.scriptonbasestar.spring.security.social.dto.SBSocialAuthenticationToken;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/**
 * @author chaeeung.e
 * @since 2017-10-24
 */
public class SBSocialAuthenticationProvider implements AuthenticationProvider {

	private final SBSocialAuthenticationManager authenticationManager;

	public SBSocialAuthenticationProvider(SBSocialAuthenticationManager sbSocialAuthenticationManager){
		this.authenticationManager = sbSocialAuthenticationManager;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		return authenticationManager.authenticate(authentication);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return (SBSocialAuthenticationToken.class.isAssignableFrom(authentication));
	}

}
