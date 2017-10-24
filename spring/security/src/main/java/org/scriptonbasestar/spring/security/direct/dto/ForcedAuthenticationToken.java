package org.scriptonbasestar.spring.security.direct.dto;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;

import java.util.Collection;

/**
 * 다양한 용도가 될 수 있겠지만.. 인증과정을 일부 생략하고 권한 부여할 때 사용
 * @author chaeeung.e
 * @since 2017-10-24
 */
public class ForcedAuthenticationToken extends AbstractAuthenticationToken {

	private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

	private final Object principal;


	public ForcedAuthenticationToken(Object principal) {
		super(null);
		this.principal = principal;
		super.setAuthenticated(true);
	}
	public ForcedAuthenticationToken(Object principal, Collection<? extends GrantedAuthority> authorities) {
		super(authorities);
		this.principal = principal;
		super.setAuthenticated(true);
	}

	@Override
	public Object getCredentials() {
		return null;
	}

	@Override
	public Object getPrincipal() {
		return principal;
	}
}
