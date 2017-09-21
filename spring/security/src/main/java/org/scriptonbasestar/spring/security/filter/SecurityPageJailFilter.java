package org.scriptonbasestar.spring.security.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * @athor archmagece
 * @since 2017-01-30 18
 *
 * 권한없는 사용자 특정 페이지에 가둬놓기..
 *
 */
@Slf4j
public class SecurityPageJailFilter extends OncePerRequestFilter {

	private final Set<GrantedAuthority> grantedAuthoritySet;
	private final String redirectToUri;
	private final String[] uriPatterns;
//	private RequestMatcher requiresAuthenticationRequestMatcher;
	private final AntPathMatcher antPathMatcher = new AntPathMatcher();

	public SecurityPageJailFilter(Set<String> userRoles, String redirectToUri, String ... uriPatterns){
		grantedAuthoritySet = new HashSet<>();
		for(String userRole : userRoles){
			grantedAuthoritySet.add(new SimpleGrantedAuthority(userRole));
		}
		this.redirectToUri  = redirectToUri;
		this.uriPatterns = uriPatterns;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
		//패턴잡아서 맞을 때 redirect\
		for(String uriPattern : uriPatterns){
			if(antPathMatcher.match(uriPattern, httpServletRequest.getRequestURI())){
				httpServletResponse.sendRedirect(redirectToUri);
			}
		}
		filterChain.doFilter(httpServletRequest, httpServletResponse);
	}
}
