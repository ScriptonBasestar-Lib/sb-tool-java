package org.scriptonbasestar.tool.core.exception.runtime;

/**
 * @Author archmagece
 * @CreatedAt 2016-12-19 18
 */
public class SBBadParameterException extends SBRuntimeBaseException {
	public SBBadParameterException(String message) {
		super(message);
	}
	public SBBadParameterException(String message, Throwable e) {
		super(message, e);
	}
}
