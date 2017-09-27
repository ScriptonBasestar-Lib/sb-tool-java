package org.scriptonbasestar.spring.security.jwt;

import org.scriptonbasestar.tool.core.exception.compiletime.SBTextExtractException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author chaeeung.e
 * @since 2017-09-19
 */
public class SBJwtAuthHeaderFilter extends SBJwtAbstractFilter {

	@Override
	protected String extractTokenString(HttpServletRequest request, HttpServletResponse response) throws SBTextExtractException {
		String authHeader = request.getHeader("Authorization");
		if (authHeader == null) {
			throw new SBTextExtractException("인증 헤더가 없습니다.");
		}
		if (!authHeader.startsWith("Bearer ")) {
			throw new SBTextExtractException("JWT 인증 헤더가 아닙니다.");
		}
		return authHeader.split("Bearer ")[1];
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request,
											HttpServletResponse response, FilterChain chain, Authentication authResult)
			throws IOException, ServletException {

		if (logger.isDebugEnabled()) {
			logger.debug("Authentication success. Updating SecurityContextHolder to contain: " + authResult);
		}
		SBJwtAuthorizedUser user = (SBJwtAuthorizedUser) authResult.getPrincipal();

		request.setAttribute(SBUserClaims.USER_ID, user.getUserId());
		request.setAttribute(SBUserClaims.USER_USERNAME, user.getUsername());
		request.setAttribute(SBUserClaims.USER_NICKNAME, user.getNickname());
		request.setAttribute(SBUserClaims.USER_ROLES, user.getRoles());
		request.setAttribute(SBUserClaims.USER_AUTHORITIES, user.getAuthorities());

		SecurityContextHolder.getContext().setAuthentication(authResult);
		//success handler
		if (successHandler != null) {
			successHandler.onAuthenticationSuccess(request, response, authResult);
		}
	}

}
