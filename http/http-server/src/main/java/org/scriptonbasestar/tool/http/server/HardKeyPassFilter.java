package org.scriptonbasestar.tool.http.server;

import lombok.Getter;
import lombok.Setter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;


public class HardKeyPassFilter
	implements Filter {

	public HardKeyPassFilter(String secretKey, String... ignorePatterns) {
		this.secretKey = secretKey;

		this.ignorePatterns = new Pattern[ignorePatterns.length];
		for (int i = 0; i < ignorePatterns.length; i++) {
			this.ignorePatterns[i] = Pattern.compile(ignorePatterns[i]);
		}
	}

	private final String secretKey;
	private final Pattern[] ignorePatterns;

	@Getter
	@Setter
	private String secretHeader = "hardKeySecret";

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		for (Pattern pattern : this.ignorePatterns) {
			if (pattern.matcher(request.getRequestURI()).matches()) {
				filterChain.doFilter(servletRequest, servletResponse);
				return;
			}
		}

		String secret = ((HttpServletRequest) servletRequest).getHeader(secretHeader);

		HttpServletResponse response = ((HttpServletResponse) servletResponse);

		if (secret == null || secret.isEmpty()) {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			return;
		} else if (!secret.equals(secretKey)) {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			return;
		}
		filterChain.doFilter(servletRequest, servletResponse);
	}

	@Override
	public void destroy() {
	}
}
