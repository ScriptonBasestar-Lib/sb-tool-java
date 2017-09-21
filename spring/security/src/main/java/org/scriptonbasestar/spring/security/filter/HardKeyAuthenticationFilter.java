package org.scriptonbasestar.spring.security.filter;

import lombok.Getter;
import lombok.Setter;
import org.scriptonbasestar.tool.collection.builder.ListBuilder;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;


public class HardKeyAuthenticationFilter
		extends GenericFilterBean {

	public HardKeyAuthenticationFilter(String secretKey, String ... ignorePatterns) {
		this.secretKey = secretKey;

		this.ignorePatterns = new Pattern[ignorePatterns.length];
		for(int i=0;i<ignorePatterns.length;i++){
			this.ignorePatterns[i] = Pattern.compile(ignorePatterns[i]);
		}
	}
	private final String secretKey;
	private final Pattern[] ignorePatterns;

	@Getter
	@Setter
	private String secretHeader = "hardKeySecret";

	private final List<GrantedAuthority> authorities = ListBuilder.create(GrantedAuthority.class).add().build();

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String secret = ((HttpServletRequest) request).getHeader(secretHeader);

		if (secret == null || secret.isEmpty()) {
			throw new BadCredentialsException("인증실패 : 키가 없음");
		}
		if(!secret.equals(secretKey)){
			throw new BadCredentialsException("인증실패 : 키가 틀림");
		}

		UserDetails userDetails = new User("apiuser", "", true, true, true, true, authorities);
		UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authRequest);

		chain.doFilter(request, response);
	}
}
