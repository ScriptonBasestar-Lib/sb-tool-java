package org.scriptonbasestar.tool.core.exception;

/**
 * @author archmagece
 * @since 2017-09-07
 *
 * 사용하면 안되는것들..
 */
public class SBDisabledException extends SBRuntimeBaseException {
	public SBDisabledException(String message) {
		super(message);
	}
	public SBDisabledException(String message, Throwable e) {
		super(message, e);
	}
}
