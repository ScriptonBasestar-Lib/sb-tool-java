package org.scriptonbasestar.spring.security.auth;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @author chaeeung.e
 * @since 2017-09-26
 */
public interface SBFindAuthenticationHandler {
	Collection<GrantedAuthority> authority(Collection<String> roles);
}
