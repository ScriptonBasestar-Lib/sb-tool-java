package org.scriptonbasestar.tool.http.server.filter;

import org.apache.http.HttpHeaders;
import org.scriptonbasestar.tool.core.exception.runtime.SBAuthenticationException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author archmagece
 * @since 2017-08-30
 */
public class SimpleApiAuthCodeFilter implements Filter {

	private String serverAuthKey;
	private int serverAuthKeyLength = 0;
	private String serverAuthCode;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		serverAuthKey = filterConfig.getInitParameter("auth-key").trim()+" ";
		serverAuthKeyLength = serverAuthKey.length();
		serverAuthCode = filterConfig.getInitParameter("auth-code").trim();
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		String header = request.getHeader(HttpHeaders.AUTHORIZATION);
		if(header != null && header.startsWith(serverAuthKey)){
			String serverAuthCodeParam = header.substring(serverAuthKeyLength);
			if(serverAuthCodeParam.trim().contentEquals(serverAuthCodeParam)){
				filterChain.doFilter(request, response);
				return;
			}
		}
		//헤더가 없거나 코드값이 틀리면 접근금지
		throw new SBAuthenticationException("API auth failed. code is wrong or empty");
	}

	@Override
	public void destroy() {

	}
}
