package org.scriptonbasestar.spring.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.impl.DefaultClaims;

import java.util.List;

/**
 * @author chaeeung.e
 * @since 2017-09-19
 */
public class SBClaimsDto extends DefaultClaims {

	public static final String USER_ID = "uid";
	public static final String USER_NICKNAME = "nname";
	public static final String USER_USERNAME = "uname";
	public static final String USER_ROLES = "roles";

	public SBClaimsDto(){
		super();
	}
	public SBClaimsDto(Claims claims){
		super(claims);
	}

	//user id
	public Long getUserId(){
		return get(USER_ID, Long.class);
	}

	public void setUserId(long uid){
		setValue(USER_ID, uid);
	}

	//user nickname
	public String getUserNickname(){
		return getString(USER_NICKNAME);
	}

	public void setUserNickname(String nname){
		setValue(USER_NICKNAME, nname);
	}

	//user username
	public String getUserUsername(){
		return getString(USER_USERNAME);
	}

	public void setUserUsername(String uname){
		setValue(USER_USERNAME, uname);
	}

	//user roles
	public List<String> getUserRoles(){
		return get(USER_ROLES, List.class);
	}

	public void setUserRoles(List<String> userRoles){
		setValue(USER_ROLES, userRoles);
	}

}
