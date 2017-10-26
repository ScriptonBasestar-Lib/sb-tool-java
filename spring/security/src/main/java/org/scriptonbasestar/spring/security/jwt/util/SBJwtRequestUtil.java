package org.scriptonbasestar.spring.security.jwt.util;

import lombok.experimental.UtilityClass;
import org.scriptonbasestar.spring.security.jwt.dto.SBAuthorizedUserClaims;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

/**
 * @author archmagece
 * @since 2017-10-12
 */
@UtilityClass
public class SBJwtRequestUtil {

	public static Long getUserId(HttpServletRequest request){
		return (Long) request.getAttribute(SBAuthorizedUserClaims.USER_ID);
//		return Long.parseLong(request.getAttribute(SBAuthorizedUserClaims.USER_ID).toString());
	}
	public static String getUserUsername(HttpServletRequest request){
		return (String) request.getAttribute(SBAuthorizedUserClaims.USER_USERNAME);
	}
	public static String getUserNickname(HttpServletRequest request){
		return (String) request.getAttribute(SBAuthorizedUserClaims.USER_NICKNAME);
	}
	public static Collection<String> getUserRole(HttpServletRequest request){
		return (Collection<String>) request.getAttribute(SBAuthorizedUserClaims.USER_ROLE);
	}
}
