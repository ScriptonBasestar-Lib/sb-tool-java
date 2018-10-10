package org.scriptonbasestar.tool.core.exception;


/**
 * @author archmagece
 * @since 2015-02-08
 * <p>
 * validation 오류
 */
public class SBValidationException extends SBRuntimeBaseException {
	public SBValidationException(String code, String message) {
		super(code, message);
	}

	public SBValidationException(String code, String message, Throwable e) {
		super(code, message, e);
	}
}
