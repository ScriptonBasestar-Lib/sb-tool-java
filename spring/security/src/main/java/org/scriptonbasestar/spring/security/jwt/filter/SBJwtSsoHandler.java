package org.scriptonbasestar.spring.security.jwt.filter;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author chaeeung.e
 * @since 2017-10-11
 */
public interface SBJwtSsoHandler {

	void postProcessing(HttpServletRequest request, HttpServletResponse response, Authentication authentication);

}
