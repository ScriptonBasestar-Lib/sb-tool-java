package org.scriptonbasestar.tool.core.exception;

import lombok.extern.slf4j.Slf4j;

/**
 * @author chaeeung.e
 * @since 2017-09-05
 */
@Slf4j
public class SBAuthenticationException extends RuntimeException {
	public SBAuthenticationException(String message) {
		super(message);
	}
}
