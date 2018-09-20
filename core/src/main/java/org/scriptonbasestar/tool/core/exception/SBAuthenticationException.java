package org.scriptonbasestar.tool.core.exception;

/**
 * @author archmagece
 * @since 2017-09-05
 */
public class SBAuthenticationException extends RuntimeException {
	public SBAuthenticationException(String message) {
		super(message);
	}
	public SBAuthenticationException(String message, Throwable e) {
		super(message, e);
	}
}
