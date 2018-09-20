package org.scriptonbasestar.tool.core.exception.data;

/**
 * @Author archmagece
 * @CreatedAt 2016-12-07 18
 */
public class SBDataDuplicateException extends SBDataException {
	public SBDataDuplicateException(String message) {
		super(message);
	}
	public SBDataDuplicateException(String message, Throwable e) {
		super(message, e);
	}
}
