package org.scriptonbasestar.spring.security.auth;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author archmagece
 * @since 2015-04-28-18
 */
public interface SBAuthenticationSuccessHandlerInjection {
	void onSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException;
}
