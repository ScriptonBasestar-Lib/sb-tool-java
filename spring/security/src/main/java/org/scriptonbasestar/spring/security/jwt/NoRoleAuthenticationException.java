package org.scriptonbasestar.spring.security.jwt;

import org.springframework.security.core.AuthenticationException;

/**
 * @author archmagece
 * @since 2017-10-13
 */
public class NoRoleAuthenticationException extends AuthenticationException{
	public NoRoleAuthenticationException(String msg, Throwable t) {
		super(msg, t);
	}

	public NoRoleAuthenticationException(String msg) {
		super(msg);
	}
}
