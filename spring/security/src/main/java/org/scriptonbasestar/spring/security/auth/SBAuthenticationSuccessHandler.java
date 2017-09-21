package org.scriptonbasestar.spring.security.auth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class SBAuthenticationSuccessHandler
		implements AuthenticationSuccessHandler {

	private final SBAuthenticationSuccessHandlerInjection injection;
	public SBAuthenticationSuccessHandler(SBAuthenticationSuccessHandlerInjection injection){
		this.injection = injection;
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
										Authentication authentication)
			throws IOException,
			ServletException {
		injection.onSuccess(request, response, authentication);
	}

}
