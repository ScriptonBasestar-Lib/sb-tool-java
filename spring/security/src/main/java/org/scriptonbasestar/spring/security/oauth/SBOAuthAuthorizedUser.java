package org.scriptonbasestar.spring.security.oauth;

import lombok.Data;
import org.scriptonbasestar.spring.security.auth.SBAuthorizedUser;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @author chaeeung.e
 * @since 2017-09-25
 */
@Data
public class SBOAuthAuthorizedUser extends SBAuthorizedUser {
	//token info
	private String accessToken;
	public SBOAuthAuthorizedUser(Long userId, String nickname, String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(userId, nickname, username, password, authorities);
	}
}
