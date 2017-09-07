package com.scriptonbasestar.spring.security.auth;

import org.springframework.security.core.AuthenticationException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author archmagece
 * @since 2015-04-28-18
 */
public interface BSAuthenticationFailureHandlerInjection {
	void onFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException;
}
