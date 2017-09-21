package org.scriptonbasestar.tool.core.exception.runtime.data;

/**
 * @Author archmagece
 * @CreatedAt 2016-12-07 18
 */
public class SBDataNotFoundException extends SBDataException {
	public SBDataNotFoundException(String message) {
		super(message);
	}
	public SBDataNotFoundException(String message, Throwable e) {
		super(message, e);
	}
}
