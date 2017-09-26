package org.scriptonbasestar.spring.security.jwt;

import org.scriptonbasestar.tool.collection.builder.ListBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author chaeeung.e
 * @since 2017-09-19
 */
public class JwtLoginSuccessHandler implements AuthenticationSuccessHandler {

	private final String serviceName;
	private final String signingKey;

	public JwtLoginSuccessHandler(String serviceName, String signingKey){
		this.serviceName = serviceName;
		this.signingKey = signingKey;
	}

	private RequestCache requestCache = new HttpSessionRequestCache();

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

		if(!(authentication.getPrincipal() instanceof SBJwtAuthorizedUser)){
			throw new RuntimeException("알 수 없는 오류 - 로그인 관련 확인");
		}
		SBJwtAuthorizedUser user = (SBJwtAuthorizedUser) authentication.getPrincipal();
		SBClaimsDto claims = new SBClaimsDto();
		claims.setUserId(user.getUserId());
		claims.setUserNickname(user.getNickname());
		claims.setUserUsername(user.getUsername());
		//TODO 하드코딩 빼야함
		claims.setUserRoles(ListBuilder.<String>create().add("ROLE_MEMBER_USER","ROLE_MEMBER_USER", "ROLE_BRIDGE_USER").build());

		//TODO 하드코딩 빼야함
		SBJwtCookieUtil.tokenToCookie(response, "test4.polypia.net", serviceName, signingKey, claims);
		SBJwtCookieUtil.tokenToCookie(response, "localhost", serviceName, signingKey, claims);

		SavedRequest savedRequest = requestCache.getRequest(request, response);
		if(savedRequest!=null){
			response.sendRedirect(savedRequest.getRedirectUrl());
		}else{
			response.sendRedirect("/");
		}
	}
}
