package org.scriptonbasestar.spring.security.filter;

import lombok.Getter;
import lombok.Setter;
import org.beansugar.base.spring.security.auth.app.AppAuthKeyManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


public class AppAuthKeyAuthenticationFilter
		extends GenericFilterBean {

	public AppAuthKeyAuthenticationFilter(UserDetailsService userDetailsService, AppAuthKeyManager appKeyManager) {
		this.userDetailsService = userDetailsService;
		this.appKeyManager = appKeyManager;
	}

	@Getter
	@Setter
	private String usernameHeader = "username";
	@Getter
	@Setter
	private String secretHeader = "secret";

	//	@Resource(name = "userServiceCustom")
	private UserDetailsService userDetailsService;

	//	@Autowired
	private AppAuthKeyManager appKeyManager;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String username = ((HttpServletRequest) request).getHeader(usernameHeader);
		String secret = ((HttpServletRequest) request).getHeader(secretHeader);

		if (!(username == null || username.isEmpty() || secret == null || secret.isEmpty())) {
			if (!appKeyManager.check(username, secret)) {
				//TODO exception 변경.- 오류나면서 response 발생.
				throw new BadCredentialsException("인증실패");
			}

			UserDetails userDetails = userDetailsService.loadUserByUsername(username);
//			SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities()));

//			UsernameOnlyAuthenticationToken authRequest = new UsernameOnlyAuthenticationToken(email,secret);
			UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(authRequest);
//			return this.getAuthenticationManager().authenticate(authRequest);
		}

		chain.doFilter(request, response);
	}
}
