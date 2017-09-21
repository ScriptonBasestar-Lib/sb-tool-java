package org.scriptonbasestar.tool.core.exception.runtime.network;

import org.scriptonbasestar.tool.core.exception.runtime.SBRuntimeBaseException;

/**
 * @Author archmagece
 * @CreatedAt 2016-12-07 18
 */
public class SBNetworkException extends SBRuntimeBaseException {
	public SBNetworkException(String message) {
		super(message);
	}
	public SBNetworkException(String message, Throwable e) {
		super(message, e);
	}
}
