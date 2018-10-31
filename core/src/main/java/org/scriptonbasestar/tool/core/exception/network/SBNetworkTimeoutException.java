package org.scriptonbasestar.tool.core.exception.network;

/**
 * @Author archmagece
 * @CreatedAt 2016-12-07 18
 * <p>
 * 네트워크에서 타임아웃 발생시
 */
public class SBNetworkTimeoutException extends SBNetworkException {
	public SBNetworkTimeoutException(String code, String message) {
		super(code, message);
	}

	public SBNetworkTimeoutException(String code, String message, Throwable e) {
		super(code, message, e);
	}
}
