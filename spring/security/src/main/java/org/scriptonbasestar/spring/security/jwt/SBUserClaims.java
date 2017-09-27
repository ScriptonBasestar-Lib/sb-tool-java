package org.scriptonbasestar.spring.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.impl.DefaultClaims;

import java.util.Collection;

/**
 * @author chaeeung.e
 * @since 2017-09-19
 */
public class SBUserClaims extends DefaultClaims {

	public static final String USER_ID = "uid";
	public static final String USER_NICKNAME = "nname";
	public static final String USER_USERNAME = "uname";
	public static final String USER_ROLES = "roles";
	/**
	 * json 에서 전송은 하지않음 사이트에서 확인.
	 */
	public static final String USER_AUTHORITIES = "auths";

	public SBUserClaims() {
		super();
	}

	public SBUserClaims(Claims claims) {
		super(claims);
	}

	//user id
	public Long getUserId() {
		return Long.parseLong(get(USER_ID).toString());
//		return get(USER_ID, Long.class);
	}

	public void setUserId(long uid) {
		setValue(USER_ID, uid);
	}

	//user nickname
	public String getUserNickname() {
		return getString(USER_NICKNAME);
	}

	public void setUserNickname(String nname) {
		setValue(USER_NICKNAME, nname);
	}

	//user username
	public String getUserUsername() {
		return getString(USER_USERNAME);
	}

	public void setUserUsername(String uname) {
		setValue(USER_USERNAME, uname);
	}

	//user roles
	public Collection<String> getUserRoles() {
		return get(USER_ROLES, Collection.class);
	}

	public void setUserRoles(Collection<String> userRoles) {
		setValue(USER_ROLES, userRoles);
	}

}
