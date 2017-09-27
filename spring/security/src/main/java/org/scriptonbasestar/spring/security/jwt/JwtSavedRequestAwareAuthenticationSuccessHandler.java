package org.scriptonbasestar.spring.security.jwt;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author chaeeung.e
 * @since 2017-09-27
 */
public class JwtSavedRequestAwareAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	private final String serviceName;
	private final String signingKey;
	private final SBJwtUserService jwtUserService;

	public JwtSavedRequestAwareAuthenticationSuccessHandler(String serviceName, String signingKey, SBJwtUserService jwtUserService) {
		this.serviceName = serviceName;
		this.signingKey = signingKey;
		this.jwtUserService = jwtUserService;
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
		super.onAuthenticationSuccess(request, response, authentication);

		SBJwtAuthorizedUser user = (SBJwtAuthorizedUser) authentication.getPrincipal();
		SBClaimsDto claims = new SBClaimsDto();
		claims.setUserId(user.getUserId());
		claims.setUserNickname(user.getNickname());
		claims.setUserUsername(user.getUsername());

		claims.setUserRoles(user.getRoles());

		for (String domain : jwtUserService.findService(user.getUserId())) {
			SBJwtCookieUtil.tokenToCookie(response, domain, serviceName, signingKey, claims);
		}
	}
}
