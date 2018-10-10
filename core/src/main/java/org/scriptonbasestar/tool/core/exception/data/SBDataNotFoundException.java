package org.scriptonbasestar.tool.core.exception.data;

/**
 * @Author archmagece
 * @CreatedAt 2016-12-07 18
 * <p>
 * 데이터 없을 때
 */
public class SBDataNotFoundException extends SBDataException {
	public SBDataNotFoundException(String code, String message) {
		super(code, message);
	}

	public SBDataNotFoundException(String code, String message, Throwable e) {
		super(code, message, e);
	}
}
