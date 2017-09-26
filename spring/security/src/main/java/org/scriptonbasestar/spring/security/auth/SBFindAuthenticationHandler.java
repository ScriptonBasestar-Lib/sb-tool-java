package org.scriptonbasestar.spring.security.auth;

import org.springframework.security.core.GrantedAuthority;

import java.util.List;

/**
 * @author chaeeung.e
 * @since 2017-09-26
 */
public interface SBFindAuthenticationHandler {
	List<GrantedAuthority> authority(List<String> roles);
}
