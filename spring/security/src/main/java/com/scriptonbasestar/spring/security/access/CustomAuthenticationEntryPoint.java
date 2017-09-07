package com.scriptonbasestar.spring.security.access;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.WebAttributes;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author archmagece
 * @date 2015-12-31
 */
@NoArgsConstructor
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

	public CustomAuthenticationEntryPoint(String errorPage) {
		this.errorPage = errorPage;
	}

	@Getter
	private String errorPage = null;

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {

		if (!response.isCommitted()) {
			if (errorPage != null) {
				// Put exception into request scope (perhaps of use to a view)
				request.setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION, authException);

				// Set the 403 status code.
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//				response.sendError(HttpServletResponse.SC_UNAUTHORIZED);

				// forward to error page.
				RequestDispatcher dispatcher = request.getRequestDispatcher(errorPage);
				dispatcher.forward(request, response);
			} else {
				response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
						authException.getMessage());
			}
		}
	}
}