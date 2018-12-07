package org.scriptonbasestar.tool.core.exception.network;

import org.scriptonbasestar.tool.core.exception.SBRuntimeBaseException;

/**
 * @Author archmagece
 * @CreatedAt 2016-12-07 18
 * <p>
 * 네트워크 관련 예외처리.
 */
public class SBNetworkException
	extends SBRuntimeBaseException {
	public SBNetworkException(String code, String message) {
		super(code, message);
	}

	public SBNetworkException(String code, String message, Throwable e) {
		super(code, message, e);
	}
}
