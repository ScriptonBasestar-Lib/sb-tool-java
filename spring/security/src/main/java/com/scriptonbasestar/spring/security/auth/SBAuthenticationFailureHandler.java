package com.scriptonbasestar.spring.security.auth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class SBAuthenticationFailureHandler
		implements AuthenticationFailureHandler {

	private final SBAuthenticationFailureHandlerInjection injection;
	public SBAuthenticationFailureHandler(SBAuthenticationFailureHandlerInjection injection){
		this.injection = injection;
	}

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
										AuthenticationException exception)
			throws IOException,
			ServletException {
		injection.onFailure(request, response, exception);
	}
}
