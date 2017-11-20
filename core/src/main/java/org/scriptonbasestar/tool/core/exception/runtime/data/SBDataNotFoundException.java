package org.scriptonbasestar.tool.core.exception.runtime.data;

import org.scriptonbasestar.tool.core.type.ErrorType;

/**
 * @Author archmagece
 * @CreatedAt 2016-12-07 18
 */
public class SBDataNotFoundException extends SBDataException {

//	public static final String ERROR_CODE = "D-0004";
//	public static final ErrorType ERROR_TYPE = ErrorType.DATA;
//	private static final String DEFAULT_MESSAGE = "sb data not found exception";

	public SBDataNotFoundException(String message) {
		super(message);
	}
	public SBDataNotFoundException(String message, Throwable e) {
		super(message, e);
	}
}
