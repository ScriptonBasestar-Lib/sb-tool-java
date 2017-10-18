package org.scriptonbasestar.tool.core.exception.compiletime;

/**
 * @Author archmagece
 * @CreatedAt 2016-10-21 17
 */
public abstract class SBBaseException extends Exception {
	public SBBaseException(String message) {
		super(message);
	}
	public SBBaseException(String message, Throwable e) {
		super(message, e);
	}
}
