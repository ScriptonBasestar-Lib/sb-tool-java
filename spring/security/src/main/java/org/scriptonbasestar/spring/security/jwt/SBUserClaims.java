package org.scriptonbasestar.spring.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.RequiredTypeException;
import io.jsonwebtoken.impl.DefaultClaims;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

/**
 * @author chaeeung.e
 * @since 2017-09-19
 */
public class SBUserClaims extends DefaultClaims {

	public static final String USER_ID = "uid";
	public static final String USER_NICKNAME = "nnm";
	public static final String USER_USERNAME = "unm";
	public static final String USER_ROLES = "uro";
	//claims에는 포함하지 않고 사이트 파라미터용으로
	public static final String USER_AUTHORITIES = "uau";

	public SBUserClaims() {
		super();
	}

	public SBUserClaims(Claims claims) {
		super(claims);
	}

	//user id
	public Long getUserId() {
//		return Long.parseLong(get(USER_ID).toString());
		return get(USER_ID, Long.class);
	}

	public void setUserId(long userid) {
		setValue(USER_ID, userid);
	}

	//user nickname
	public String getUserNickname() {
		return getString(USER_NICKNAME);
	}

	public void setUserNickname(String nickname) {
		setValue(USER_NICKNAME, nickname);
	}

	//user username
	public String getUserUsername() {
		return getString(USER_USERNAME);
	}

	public void setUserUsername(String username) {
		setValue(USER_USERNAME, username);
	}

	//user roles
	public Collection<String> getUserRoles() {
		return get(USER_ROLES, Collection.class);
	}

	public void setUserRoles(Collection<String> userRoles) {
		setValue(USER_ROLES, userRoles);
	}

	@Override
	public <T> T get(String claimName, Class<T> requiredType) {
		Object value = get(claimName);
		if (value == null) {
			return null;
		}

		if (Claims.EXPIRATION.equals(claimName) ||
				Claims.ISSUED_AT.equals(claimName) ||
				Claims.NOT_BEFORE.equals(claimName)
				) {
			value = getDate(claimName);
		}
//		else if(USER_ROLES.equals(claimName)){
//			value =
//		}

		if (requiredType == Date.class && value instanceof Long) {
			value = new Date((Long) value);
		} else if (requiredType == Long.class) {
			value = Long.parseLong(value.toString());
		}

		if (!requiredType.isInstance(value)) {
			throw new RequiredTypeException("Expected value to be of type: " + requiredType + ", but was " + value.getClass());
		}

		return requiredType.cast(value);
	}

}
