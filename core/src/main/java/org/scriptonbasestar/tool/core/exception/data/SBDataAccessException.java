package org.scriptonbasestar.tool.core.exception.data;

/**
 * @Author archmagece
 * @CreatedAt 2016-12-07 18
 */
public class SBDataAccessException extends SBDataException {
	public SBDataAccessException(String message) {
		super(message);
	}
	public SBDataAccessException(String message, Throwable e) {
		super(message, e);
	}
}
