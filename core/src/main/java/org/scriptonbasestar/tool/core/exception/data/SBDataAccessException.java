package org.scriptonbasestar.tool.core.exception.data;

/**
 * @Author archmagece
 * @CreatedAt 2016-12-07 18
 */
public class SBDataAccessException extends SBDataException {
	public SBDataAccessException(String code, String message) {
		super(code, message);
	}

	public SBDataAccessException(String code, String message, Throwable e) {
		super(code, message, e);
	}
}
