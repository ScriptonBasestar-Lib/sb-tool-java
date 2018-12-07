package org.scriptonbasestar.tool.core.exception.data;

import org.scriptonbasestar.tool.core.exception.SBRuntimeBaseException;

/**
 * @Author archmagece
 * @CreatedAt 2016-12-07 18
 * <p>
 * 데이터 관련 예외처리
 */
public class SBDataException
	extends SBRuntimeBaseException {
	public SBDataException(String code, String message) {
		super(code, message);
	}

	public SBDataException(String code, String message, Throwable e) {
		super(code, message, e);
	}
}
