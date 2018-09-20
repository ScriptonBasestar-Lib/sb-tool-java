package org.scriptonbasestar.tool.core.exception;

/**
 * @author archmagece
 * @date 2016-03-04
 */
public abstract class SBRuntimeBaseException extends RuntimeException {
	protected SBRuntimeBaseException(String message) {
		super(message);
	}
	protected SBRuntimeBaseException(String message, Throwable e) {
		super(message, e);
	}
}
