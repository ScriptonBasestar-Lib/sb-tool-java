package com.scriptonbasestar.spring.security.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * @author : archmagece@scriptonbasestar.com
 * @since: 2013-12-25 23:48
 */
public class SaltedUser extends User {

	private static final long serialVersionUID = -7915137127272359618L;

	@Getter
	@Setter
	private Long accountId;

	@Getter
	@Setter
	private String code;

	@Getter
	@Setter
	private String salt;

	@Getter
	@Setter
	private String locale;

//	public SaltedUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
//		super(username, password, authorities);
//	}

//	public SaltedUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
//		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
//	}

	public SaltedUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities, Long accountId, String code, String salt, String locale) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		this.accountId = accountId;
		this.code = code;
		this.salt = salt;
		this.locale = locale;
	}

}
