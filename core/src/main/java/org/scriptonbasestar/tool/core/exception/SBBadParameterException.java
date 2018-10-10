package org.scriptonbasestar.tool.core.exception;

/**
 * @Author archmagece
 * @CreatedAt 2016-12-19 18
 * <p>
 * 의도하지 않은 파라미터 입력시
 */
public class SBBadParameterException extends SBRuntimeBaseException {
	public SBBadParameterException(String code, String message) {
		super(code, message);
	}

	public SBBadParameterException(String message) {
		super(message);
	}

	public SBBadParameterException(String code, String message, Throwable e) {
		super(code, message, e);
	}

	public SBBadParameterException(String message, Throwable e) {
		super(message, e);
	}
}
