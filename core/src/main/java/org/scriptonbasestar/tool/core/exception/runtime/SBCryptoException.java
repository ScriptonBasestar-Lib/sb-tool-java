package org.scriptonbasestar.tool.core.exception.runtime;

/**
 * @author archmagece
 * @since 2017-09-07
 */
public class SBCryptoException extends SBRuntimeBaseException {
	public SBCryptoException(String message) {
		super(message);
	}
	public SBCryptoException(String message, Throwable e) {
		super(message, e);
	}
}
