package org.scriptonbasestar.tool.core.exception;

/**
 * @author archmagece
 * @since 2017-09-07
 * <p>
 * 서비스의 금지항목 접근시
 */
public class SBDisabledException
	extends SBRuntimeBaseException {
	public SBDisabledException(String code, String message) {
		super(code, message);
	}

	public SBDisabledException(String message) {
		super(message);
	}

	public SBDisabledException(String code, String message, Throwable e) {
		super(code, message, e);
	}

	public SBDisabledException(String message, Throwable e) {
		super(message, e);
	}
}
