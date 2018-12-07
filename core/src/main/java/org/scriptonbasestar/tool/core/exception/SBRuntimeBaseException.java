package org.scriptonbasestar.tool.core.exception;

import lombok.Getter;

/**
 * @author archmagece
 * @date 2016-03-04
 * <p>
 * 모든 SB Exception은 Runtime.
 * SBException의 BaseException
 */
public abstract class SBRuntimeBaseException
	extends RuntimeException {

	@Getter
	protected final String code;

	protected SBRuntimeBaseException(String code, String message) {
		super(message);
		this.code = code;
	}

	protected SBRuntimeBaseException(String message) {
		super(message);
		this.code = "";
	}

	protected SBRuntimeBaseException(String code, String message, Throwable e) {
		super(message, e);
		this.code = code;
	}

	protected SBRuntimeBaseException(String message, Throwable e) {
		super(message, e);
		this.code = "";
	}
}
