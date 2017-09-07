package com.scriptonbasestar.spring.security.access;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author archmagece
 * @date 2016-01-10
 */
@Slf4j
public class SsoAccessDeniedHandler implements AccessDeniedHandler {

	private String redirect = "http://localhost:8081/auth/login";

	public  SsoAccessDeniedHandler(String redirect){
		this.redirect = redirect;
	}

	@Override
	public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
		Object authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication==null){
			httpServletResponse.sendRedirect(this.redirect);
		}
	}

}
