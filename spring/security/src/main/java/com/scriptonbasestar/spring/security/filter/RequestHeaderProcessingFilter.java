package com.scriptonbasestar.spring.security.filter;

import com.scriptonbasestar.spring.security.SignedUsernamePasswordAuthenticationToken;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * A filter which pulls from the HTTP request several fields, including
 * username, password, and a signature incorporating the combination of the two.
 *
 * @author Mularien
 */
public class RequestHeaderProcessingFilter
		extends AbstractAuthenticationProcessingFilter {

	@Getter
	@Setter
	private String usernameHeader = "j_username";
	@Getter
	@Setter
	private String passwordHeader = "j_password";
	@Getter
	@Setter
	private String signatureHeader = "j_signature";

	/**
	 * {@inheritDoc}
	 */
	protected RequestHeaderProcessingFilter() {
		super("/j_spring_security_filter");
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException,
			IOException,
			ServletException {

		String username = request.getHeader(usernameHeader);
		String password = request.getHeader(passwordHeader);
		String signature = request.getHeader(signatureHeader);

		SignedUsernamePasswordAuthenticationToken authRequest = new SignedUsernamePasswordAuthenticationToken(username,
				password, signature);

		return this.getAuthenticationManager().authenticate(
				authRequest);
	}
}
