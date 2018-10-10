package org.scriptonbasestar.tool.core.exception.auth;

import org.scriptonbasestar.tool.core.exception.SBRuntimeBaseException;

/**
 * @author archmagece
 * @since 2017-09-05
 */
public class SBAuthenticationException extends SBRuntimeBaseException {
	public SBAuthenticationException(String code, String message) {
		super(code, message);
	}

	public SBAuthenticationException(String code, String message, Throwable e) {
		super(code, message, e);
	}
}
