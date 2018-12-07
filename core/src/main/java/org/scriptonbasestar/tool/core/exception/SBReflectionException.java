package org.scriptonbasestar.tool.core.exception;

/**
 * @Author archmagece
 * @CreatedAt 2016-12-07 18
 * <p>
 * Reflection 사용시.
 */
public class SBReflectionException
	extends SBRuntimeBaseException {
	public SBReflectionException(String code, String message) {
		super(code, message);
	}

	public SBReflectionException(String message) {
		super(message);
	}

	public SBReflectionException(String code, String message, Throwable e) {
		super(code, message, e);
	}

	public SBReflectionException(String message, Throwable e) {
		super(message, e);
	}
}
