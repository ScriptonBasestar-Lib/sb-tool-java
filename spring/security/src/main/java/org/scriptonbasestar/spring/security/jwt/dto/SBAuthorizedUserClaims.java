package org.scriptonbasestar.spring.security.jwt.dto;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.RequiredTypeException;
import io.jsonwebtoken.impl.DefaultClaims;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.*;

/**
 * @author chaeeung.e
 * @since 2017-09-19
 */
public class SBAuthorizedUserClaims extends DefaultClaims implements UserDetails {

	public static final String USER_ID = "uid";
	public static final String USER_NICKNAME = "nnm";
	public static final String USER_USERNAME = "unm";
//	public static final String USER_COMPONENT = "usc";
	public static final String USER_ROLE = "ucr";
//	public static final String USER_AUTHORITY = "uca";
	//claims에는 포함하지 않고 사이트 파라미터용으로
	@Getter//override
	protected final Set<GrantedAuthority> authorities;
	@Getter//override
	protected final boolean enabled;
	@Getter//override
	protected final boolean accountNonExpired;
	@Getter//override
	protected final boolean credentialsNonExpired;
	@Getter//override
	protected final boolean accountNonLocked;
	@Getter//override
	private final String password = null;


	public SBAuthorizedUserClaims(
			Long userId,
			String nickname,
			String username,
			Set<String> userRoles,
			boolean enabled,
			boolean accountNonExpired,
			boolean credentialsNonExpired,
			boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		if (((username == null) || "".equals(username))) {
			throw new IllegalArgumentException(
					"Cannot pass null or empty values to constructor");
		}
		setUserId(userId);
		setNickname(nickname);
		setUsername(username);
		setUserRoles(userRoles);
		this.enabled = enabled;
		this.accountNonExpired = accountNonExpired;
		this.credentialsNonExpired = credentialsNonExpired;
		this.accountNonLocked = accountNonLocked;
		this.authorities = Collections.unmodifiableSet(sortAuthorities(authorities));
	}

	public SBAuthorizedUserClaims(
			Long userId,
			String nickname,
			String username,
			Set<String> userRoles,
			boolean enabled,
			boolean accountNonExpired,
			boolean credentialsNonExpired,
			boolean accountNonLocked) {
		if (((username == null) || "".equals(username))) {
			throw new IllegalArgumentException(
					"Cannot pass null or empty values to constructor");
		}
		setUserId(userId);
		setNickname(nickname);
		setUsername(username);
		setUserRoles(userRoles);
		this.enabled = enabled;
		this.accountNonExpired = accountNonExpired;
		this.credentialsNonExpired = credentialsNonExpired;
		this.accountNonLocked = accountNonLocked;
		this.authorities = Collections.EMPTY_SET;
	}

	public SBAuthorizedUserClaims(
			Claims claims,
			boolean enabled,
			boolean accountNonExpired,
			boolean credentialsNonExpired,
			boolean accountNonLocked) {
		super(claims);
		if(claims.get(USER_USERNAME)==null || "".equals(claims.get(USER_USERNAME))){
			throw new IllegalArgumentException(
					"Cannot pass null or empty values to constructor");
		}
		this.enabled = enabled;
		this.accountNonExpired = accountNonExpired;
		this.credentialsNonExpired = credentialsNonExpired;
		this.accountNonLocked = accountNonLocked;
		this.authorities = Collections.EMPTY_SET;
	}

	//user id
	public Long getUserId() {
		return get(USER_ID, Long.class);
	}

	protected void setUserId(long userId) {
		setValue(USER_ID, userId);
	}

	//user nickname
	public String getNickname() {
		return getString(USER_NICKNAME);
	}

	protected void setNickname(String nickname) {
		setValue(USER_NICKNAME, nickname);
	}

	//user username
	@Override
	public String getUsername() {
		return getString(USER_USERNAME);
	}

	protected void setUsername(String username){
		setValue(USER_USERNAME, username);
	}

	//user role
	public String getUserRole() {
		return get(USER_ROLE, String.class);
	}

	protected void setUserRole(String userRole) {
		setValue(USER_ROLE, userRole);
	}

	//user roles
	public Collection<String> getUserRoles() {
		return get(USER_ROLE, Collection.class);
	}

	protected void setUserRoles(Collection<String> userRoles) {
		setValue(USER_ROLE, userRoles);
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

	private static SortedSet<GrantedAuthority> sortAuthorities(
			Collection<? extends GrantedAuthority> authorities) {
		Assert.notNull(authorities, "Cannot pass a null GrantedAuthority collection");
		// Ensure array iteration order is predictable (as per
		// UserDetails.getAuthorities() contract and SEC-717)
		SortedSet<GrantedAuthority> sortedAuthorities = new TreeSet<>(new AuthorityComparator());

		for (GrantedAuthority grantedAuthority : authorities) {
			Assert.notNull(grantedAuthority, "GrantedAuthority list cannot contain any null elements");
			sortedAuthorities.add(grantedAuthority);
		}

		return sortedAuthorities;
	}

	private static class AuthorityComparator implements Comparator<GrantedAuthority>,
			Serializable {
		private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

		public int compare(GrantedAuthority g1, GrantedAuthority g2) {
			// Neither should ever be null as each entry is checked before adding it to the set.
			// If the findUserAuthority is null, it is a custom findUserAuthority and should precede others.
			if (g2.getAuthority() == null) {
				return -1;
			}

			if (g1.getAuthority() == null) {
				return 1;
			}

			return g1.getAuthority().compareTo(g2.getAuthority());
		}
	}

}
