package org.scriptonbasestar.tool.core.exception.runtime;

/**
 * @Author archmagece
 * @CreatedAt 2016-12-07 18
 */
public class SBDataAccessException extends SBRuntimeBaseException {
	public SBDataAccessException(String message) {
		super(message);
	}
	public SBDataAccessException(String message, Throwable e) {
		super(message, e);
	}
}
