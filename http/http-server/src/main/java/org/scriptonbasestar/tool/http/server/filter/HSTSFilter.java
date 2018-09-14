package org.scriptonbasestar.tool.http.server.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 내가만든거 아니고 퍼온거
 * https://gs.saro.me/#!m=elec&jn=712
 */
public class HSTSFilter implements Filter
{
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException
	{
		// 필터적용
		((HttpServletResponse)res)
			.setHeader("Strict-Transport-Security", "max-age=31536000; includeSubDomains; preload");
		
		chain.doFilter(req, res);
	}
	
	@Override public void destroy() {}
	@Override public void init(FilterConfig arg0) throws ServletException {}
}