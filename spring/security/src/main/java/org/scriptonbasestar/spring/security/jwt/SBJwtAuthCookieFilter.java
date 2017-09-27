package org.scriptonbasestar.spring.security.jwt;

import org.scriptonbasestar.tool.core.exception.compiletime.SBTextExtractException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

/**
 * @author chaeeung.e
 * @since 2017-09-19
 */
public class SBJwtAuthCookieFilter extends SBJwtAbstractFilter {

	@Override
	protected String extractTokenString(HttpServletRequest request, HttpServletResponse response) throws SBTextExtractException {
		String token = SBJwtCookieUtil.tokenFromCookie(request, serviceName, signingKey);
		if (token == null) {
			throw new SBTextExtractException("쿠키가 존재하지 않습니다.");
		}
		return token;
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request,
											HttpServletResponse response, FilterChain chain, Authentication authResult)
			throws IOException, ServletException {

		if (logger.isDebugEnabled()) {
			logger.debug("Authentication success. Updating SecurityContextHolder to contain: " + authResult);
		}
		SBUserClaims claims = (SBUserClaims) authResult.getPrincipal();
		request.setAttribute(SBUserClaims.USER_ID, claims.getUserId());
		request.setAttribute(SBUserClaims.USER_USERNAME, claims.getUserUsername());
		request.setAttribute(SBUserClaims.USER_NICKNAME, claims.getUserNickname());
		request.setAttribute(SBUserClaims.USER_ROLES, claims.getUserRoles());

//		Collection<GrantedAuthority> authorities = new HashSet<>();
//		for(String auth : jwtUserService.findService(claims.getUserId())){
//			authorities.add(new SimpleGrantedAuthority(auth));
//		}
//		request.setAttribute(SBUserClaims.USER_AUTHORITIES, authorities);
		request.setAttribute(SBUserClaims.USER_AUTHORITIES, jwtUserService.findService(claims.getUserId()).stream().map(s -> new SimpleGrantedAuthority(s)).collect(Collectors.toSet()));

		SecurityContextHolder.getContext().setAuthentication(authResult);
		//success handler
		if (successHandler != null) {
			successHandler.onAuthenticationSuccess(request, response, authResult);
		}
	}
}
