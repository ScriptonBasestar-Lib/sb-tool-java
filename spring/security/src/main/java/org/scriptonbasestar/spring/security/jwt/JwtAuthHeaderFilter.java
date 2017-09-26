package org.scriptonbasestar.spring.security.jwt;

import lombok.Setter;
import org.scriptonbasestar.tool.collection.builder.ListBuilder;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @author chaeeung.e
 * @since 2017-09-19
 */
public class JwtAuthHeaderFilter extends OncePerRequestFilter {

	@Setter
	private JwtAuthenticationManager authenticationManager;

	@Setter
	private String serviceName;
	@Setter
	private String signingKey;

	@Setter
	private AuthenticationSuccessHandler successHandler;
	@Setter
	private AuthenticationFailureHandler failureHandler;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		String authHeader = request.getHeader("Authorization");
		if (authHeader == null) {
			filterChain.doFilter(request, response);
			return;
		}
		if(!authHeader.startsWith("Bearer ")){
			filterChain.doFilter(request, response);
			return;
		}
		String token = authHeader.split("Bearer ")[1];

		Authentication authResult;
		try {
			authResult = authenticationManager.authenticate(new SBJwtPreAuthenticateToken(token));
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
		if(failureHandler!=null){
			failureHandler.onAuthenticationFailure(request, response, failed);
		}
	}

	protected void successfulAuthentication(HttpServletRequest request,
											HttpServletResponse response, FilterChain chain, Authentication authResult)
			throws IOException, ServletException {

		if (logger.isDebugEnabled()) {
			logger.debug("Authentication success. Updating SecurityContextHolder to contain: " + authResult);
		}
		SBJwtAuthorizedUser user = (SBJwtAuthorizedUser) authResult.getPrincipal();
		SBClaimsDto claims = (SBClaimsDto) authResult.getCredentials();

		request.setAttribute(SBClaimsDto.USER_ID, user.getUserId());
		request.setAttribute(SBClaimsDto.USER_USERNAME, user.getUsername());
		request.setAttribute(SBClaimsDto.USER_NICKNAME, user.getNickname());
		request.setAttribute(SBClaimsDto.USER_ROLES, user.getAuthorities());
		request.setAttribute(SBClaimsDto.USER_AUTHORITIES, user.getAuthorities());

		//TODO 사용자별로 연결된 사이트를 동적으로 확인 .. 추가
//		for문
		SBJwtCookieUtil.tokenToCookie(response, "test4.polypia.net", serviceName, signingKey, claims);
		SBJwtCookieUtil.tokenToCookie(response, "localhost", serviceName, signingKey, claims);

		SecurityContextHolder.getContext().setAuthentication(authResult);
		//success handler
		if(successHandler!=null){
			successHandler.onAuthenticationSuccess(request, response, authResult);
		}

		chain.doFilter(request, response);
	}

}
