package org.scriptonbasestar.spring.security.jwt;

import lombok.Setter;
import org.scriptonbasestar.spring.security.util.SecurityMethodUtil;
import org.scriptonbasestar.tool.core.exception.runtime.SBAuthenticationException;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author chaeeung.e
 * @since 2017-09-19
 */
public class JwtAuthCookieFilter extends OncePerRequestFilter {

	@Setter
	private String serviceName;

	@Setter
	private String signingKey;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		String authHeader = request.getHeader("Authorization");
		if(authHeader==null){
			filterChain.doFilter(request,response);
			return;
		}
		String token = authHeader.split("Bearer ")[1];
		SBClaimsDto claims = SBJwtUtil.getBody(signingKey, token);
		request.setAttribute(SBClaimsDto.USER_ID, claims.getUserId());
		request.setAttribute(SBClaimsDto.USER_USERNAME, claims.getUserUsername());
		request.setAttribute(SBClaimsDto.USER_NICKNAME, claims.getUserNickname());
		request.setAttribute(SBClaimsDto.USER_ROLES, claims.getUserRoles());

		ServletContext context = request.getServletContext();
		context.setAttribute("claims", claims);

//		UserEntity userEntity = userRepository.findOne(claims.getUserId());
//		if(userEntity==null){
//			throw new SBAuthenticationException("존재하지 않는 계정입니다");
//		}
//		SecurityMethodUtil.loginProcess(AuthorizedUser.create(userEntity));
//		sessionRegistry.registerNewSession(request.getSession().getId(),);

		filterChain.doFilter(request, response);
	}
}
