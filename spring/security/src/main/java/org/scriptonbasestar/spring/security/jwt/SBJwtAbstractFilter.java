package org.scriptonbasestar.spring.security.jwt;

import lombok.Setter;
import org.scriptonbasestar.tool.core.exception.compiletime.SBTextExtractException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.util.Assert;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author chaeeung.e
 * @since 2017-09-27
 */
public abstract class SBJwtAbstractFilter extends OncePerRequestFilter {

	//not null
	//직접넣지말고 ProviderManager.providers에 넣어.
//	private AuthenticationManager authenticationManager;
	@Setter
	private SBJwtAuthenticationManager authenticationManager;

	//not null
	@Setter
	protected String serviceName;
	//not null
	@Setter
	protected String signingKey;

	//not null
	@Setter
	protected SBJwtUserService jwtUserService;

	@Setter
	protected AuthenticationSuccessHandler successHandler;
	@Setter
	protected AuthenticationFailureHandler failureHandler;

	@Override
	protected void initFilterBean() throws ServletException {
		super.initFilterBean();
		try{
			Assert.notNull(authenticationManager, "authenticationManager must not null");
			Assert.notNull(serviceName, "serviceName must not null");
			Assert.notNull(signingKey, "signingKey must not null");
			Assert.notNull(jwtUserService, "jwtUserService must not null");
		}catch (IllegalArgumentException e){
			throw new ServletException(e.getMessage());
		}
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		String token = null;
		try {
			token = extractTokenString(request, response);
		} catch (SBTextExtractException e) {
//			e.printStackTrace();
			filterChain.doFilter(request, response);
			return;
		}

		Authentication authResult;
		try {
			authResult = authenticationManager.authenticate(new SBJwtPreAuthenticateToken(token));
		} catch (InternalAuthenticationServiceException failed) {
			logger.error("An internal error occurred while trying to authenticate the user.", failed);
			unsuccessfulAuthentication(request, response, failed);
			filterChain.doFilter(request, response);
			return;
		} catch (AuthenticationException failed) {
			unsuccessfulAuthentication(request, response, failed);
			filterChain.doFilter(request, response);
			return;
		}

		// Authentication success
//		if (continueChainBeforeSuccessfulAuthentication) {
//			filterChain.doFilter(request, response);
//		}

		successfulAuthentication(request, response, filterChain, authResult);
//		filterChain.doFilter(request, response);
	}

	protected abstract String extractTokenString(HttpServletRequest request, HttpServletResponse response) throws SBTextExtractException;


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
		if (failureHandler != null) {
			failureHandler.onAuthenticationFailure(request, response, failed);
		}
	}

	protected abstract void successfulAuthentication(HttpServletRequest request,
											HttpServletResponse response, FilterChain chain, Authentication authResult)
			throws IOException, ServletException;
}
