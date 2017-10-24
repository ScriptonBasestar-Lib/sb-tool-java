package org.scriptonbasestar.spring.security.direct.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * @author chaeeung.e
 * @since 2017-10-24
 */
public class SBForcedUser extends User {
	public SBForcedUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}
}
