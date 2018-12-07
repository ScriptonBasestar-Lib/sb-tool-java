package org.scriptonbasestar.tool.http.server.filter;

import org.scriptonbasestar.tool.core.check.Check;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @athor archmagece
 * @since 2017-01-17 11
 * redirect filter.. http 접속을 https로 튕겨낼 때 사용
 * 보통은 http서버에서 처리하겠지만 그게 곤란할 경우
 */
public class HttpsRedirectFilter
	implements Filter {
	private FilterConfig filterConfig;

	private String toProtocol;
	private int toPort;

//	public HttpsRedirectFilter(){
//		this.toProtocol = "https";
//		this.toPort = 443;
//	}

	public HttpsRedirectFilter(String toProtocol, int toPort) {
		this.toProtocol = toProtocol;
		this.toPort = toPort;
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		Check.notEmptyString(filterConfig.getInitParameter("toProtocol"), "protocol must not null or empty");
		Check.notEmptyString(filterConfig.getInitParameter("toPort"), "port must not null or empty");
		this.toProtocol = filterConfig.getInitParameter("toProtocol");
		this.toPort = Integer.parseInt(filterConfig.getInitParameter("toProtocol"));
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//		System.out.println("===============================");
//		System.out.println(request.getProtocol().toString());
//		System.out.println(request.getLocalAddr().toString());
//		System.out.println(request.getLocalName().toString());
//		System.out.println(request.getLocalPort());
//		System.out.println(request.getRemoteAddr().toString());
//		System.out.println(request.getRemoteHost().toString());
//		System.out.println(request.getRemotePort());
//		System.out.println(request.getServerPort());
//		System.out.println("===============================");

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		String uri = req.getRequestURI();
		String getProtocol = req.getScheme();
		String getDomain = req.getServerName();

		if (getProtocol.toLowerCase().equals("http")) {
			// Set response content type
			response.setContentType("text/html");
			// New location to be redirected
			String redirectTo = toProtocol + "://" + getDomain + ":" + toPort + uri;
//			res.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
			res.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
			res.setHeader("Location", redirectTo);
		}

		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		if (this.filterConfig != null) this.filterConfig = null;
	}
}
