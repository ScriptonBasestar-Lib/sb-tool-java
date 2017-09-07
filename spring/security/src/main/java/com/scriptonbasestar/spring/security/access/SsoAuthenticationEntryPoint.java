package com.scriptonbasestar.spring.security.access;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author archmagece
 * @date 2016-01-10
 */
@Slf4j
public class SsoAuthenticationEntryPoint implements AuthenticationEntryPoint {
	//http://localhost:8081/auth/login
	private final String redirect;

	public SsoAuthenticationEntryPoint(String redirect){
		this.redirect = redirect;
	}

	@Override
	public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
		Object authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication==null){
			httpServletResponse.sendRedirect(this.redirect);
		}
	}

}
