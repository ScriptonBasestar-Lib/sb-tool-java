package com.scriptonbasestar.spring.security.filter;

import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class RequestRedirectFilter
		extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		if((request instanceof HttpServletRequest) && (response instanceof HttpServletResponse)){
			String redirectTarget =  ((HttpServletRequest)request).getRequestURL().toString().replaceFirst("https", "http");
			redirectTarget =  redirectTarget.replaceFirst(":8443", ":8080");
			if(!request.isSecure()){
				((HttpServletResponse)response).sendRedirect(redirectTarget);
				return;
			}
		}

		chain.doFilter(request, response);
	}
}
