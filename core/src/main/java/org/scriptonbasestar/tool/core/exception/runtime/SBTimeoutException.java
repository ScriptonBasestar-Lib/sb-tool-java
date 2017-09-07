package org.scriptonbasestar.tool.core.exception.runtime;

/**
 * @Author archmagece
 * @CreatedAt 2016-12-07 18
 */
public class SBTimeoutException extends SBRuntimeBaseException {
	public SBTimeoutException(String message) {
		super(message);
	}
	public SBTimeoutException(String message, Throwable e) {
		super(message, e);
	}
}
