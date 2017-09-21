package org.scriptonbasestar.spring.security.auth;

import io.jsonwebtoken.impl.DefaultClaims;

/**
 * @author chaeeung.e
 * @since 2017-09-19
 */
public class JwtTokenPayloadUserDto extends DefaultClaims {

	public static final String USER_ID = "uid";
	public static final String USER_NICKNAME = "name";
	public static final String USER_ROLES = "roles";

	//user id
	public long getUserId(){
		return get(USER_ID, Long.class);
	}

	public void setUserId(long uid){
		setValue(USER_ID, uid);
	}

	//user nickname
	public String getUserNickname(){
		return getString(USER_NICKNAME);
	}

	public void setName(String name){
		setValue(USER_NICKNAME, name);
	}

	//user roles
	public String[] getUserRoles(){
		return get(USER_ROLES, String[].class);
	}

	public void setUserRoles(String[] userRoles){
		setValue(USER_ROLES, userRoles);
	}

}
