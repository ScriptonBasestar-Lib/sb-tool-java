package org.scriptonbasestar.spring.security.jwt.filter;

import org.scriptonbasestar.spring.security.auth.SBFindUserAuthorityService;
import org.scriptonbasestar.spring.security.jwt.SBJwtCookieUtil;
import org.scriptonbasestar.spring.security.jwt.dto.SBUserClaims;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author chaeeung.e
 * @since 2017-10-11
 *
 * default handler는 cookie 이용
 */
public class SBJwtSsoDefaultHandler implements SBJwtSsoHandler {

	private final String serviceName;
	private final String signingKey;
	private final SBFindUserAuthorityService findUserAuthorityService;

	public SBJwtSsoDefaultHandler(String serviceName, String signingKey, SBFindUserAuthorityService jwtUserService) {
		this.serviceName = serviceName;
		this.signingKey = signingKey;
		this.findUserAuthorityService = jwtUserService;
	}

	@Override
	public void postProcessing(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
		SBUserClaims claims = (SBUserClaims) authentication.getPrincipal();

		for (String domain : findUserAuthorityService.findUserComponent(claims.getUserId())) {
			SBJwtCookieUtil.tokenToCookie(response, domain, serviceName, signingKey, claims);
		}
	}
}
