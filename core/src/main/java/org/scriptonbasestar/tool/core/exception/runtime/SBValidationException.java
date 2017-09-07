package org.scriptonbasestar.tool.core.exception.runtime;


/**
 * @author archmagece
 * @since 2015-02-08
 * 검색했는데 데이터 결과값이 없을 때
 */
public class SBValidationException extends SBRuntimeBaseException {
	public SBValidationException(String message) {
		super(message);
	}
	public SBValidationException(String message, Throwable e) {
		super(message, e);
	}
}
