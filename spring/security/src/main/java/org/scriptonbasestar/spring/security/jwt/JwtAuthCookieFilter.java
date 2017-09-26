package org.scriptonbasestar.spring.security.jwt;

import lombok.Setter;
import org.scriptonbasestar.spring.security.auth.SBFindAuthenticationHandler;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author chaeeung.e
 * @since 2017-09-19
 */
public class JwtAuthCookieFilter extends OncePerRequestFilter {

	@Setter
	private String serviceName;

	@Setter
	private String signingKey;

	@Setter
	private SBFindAuthenticationHandler authenticationHandler;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		SBClaimsDto claims = SBJwtCookieUtil.tokenFromCookie(request, serviceName, signingKey);

		if(claims==null){
			//로그인 실패
			return;
		}

		Authentication authResult;
		try {
			authResult = new SBJwtAuthenticationToken(claims, authenticationHandler.authority(claims.getUserRoles()));
		} catch (InternalAuthenticationServiceException failed) {
			logger.error("An internal error occurred while trying to authenticate the user.", failed);
			unsuccessfulAuthentication(request, response, failed);
			return;
		} catch (AuthenticationException failed) {
			unsuccessfulAuthentication(request, response, failed);
			return;
		}

		// Authentication success
//		if (continueChainBeforeSuccessfulAuthentication) {
//			filterChain.doFilter(request, response);
//		}

		successfulAuthentication(request, response, filterChain, authResult);
	}


	protected void unsuccessfulAuthentication(HttpServletRequest request,
											  HttpServletResponse response, AuthenticationException failed)
			throws IOException, ServletException {
		SecurityContextHolder.clearContext();

		if (logger.isDebugEnabled()) {
			logger.debug("Authentication request failed: " + failed.toString(), failed);
			logger.debug("Updated SecurityContextHolder to contain null Authentication");
//			logger.debug("Delegating to authentication failure handler " + failureHandler);
		}
		//failed handler
	}

	protected void successfulAuthentication(HttpServletRequest request,
											HttpServletResponse response, FilterChain chain, Authentication authResult)
			throws IOException, ServletException {

		if (logger.isDebugEnabled()) {
			logger.debug("Authentication success. Updating SecurityContextHolder to contain: " + authResult);
		}
		SBClaimsDto claims = (SBClaimsDto) authResult.getPrincipal();
		request.setAttribute(SBClaimsDto.USER_ID, claims.getUserId());
		request.setAttribute(SBClaimsDto.USER_USERNAME, claims.getUserUsername());
		request.setAttribute(SBClaimsDto.USER_NICKNAME, claims.getUserNickname());
		request.setAttribute(SBClaimsDto.USER_ROLES, claims.getUserRoles());
		SecurityContextHolder.getContext().setAuthentication(authResult);
		//success handler
	}

}
