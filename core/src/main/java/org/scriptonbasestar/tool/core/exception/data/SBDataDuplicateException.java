package org.scriptonbasestar.tool.core.exception.data;

/**
 * @Author archmagece
 * @CreatedAt 2016-12-07 18
 */
public class SBDataDuplicateException
	extends SBDataException {
	public SBDataDuplicateException(String code, String message) {
		super(code, message);
	}

	public SBDataDuplicateException(String code, String message, Throwable e) {
		super(code, message, e);
	}
}
