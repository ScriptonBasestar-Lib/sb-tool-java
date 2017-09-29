package org.scriptonbasestar.spring.security.auth;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.Map;

/**
 * @author chaeeung.e
 * @since 2017-09-25
 */
@Data
public abstract class SBAuthorizedUser extends User{
	private final Long userId;
	private final String nickname;

	protected SBAuthorizedUser(Long userId, String nickname, String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		this.userId = userId;
		this.nickname = nickname;
	}

}
