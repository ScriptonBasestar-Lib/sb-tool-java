package org.scriptonbasestar.tool.core.exception;

/**
 * @author archmagece
 * @since 2017-09-07
 * <p>
 * 암호화 과정에서 발생하는 예외
 */
public class SBCryptoException
	extends SBRuntimeBaseException {
	public SBCryptoException(String code, String message) {
		super(code, message);
	}

	public SBCryptoException(String message) {
		super(message);
	}

	public SBCryptoException(String code, String message, Throwable e) {
		super(code, message, e);
	}

	public SBCryptoException(String message, Throwable e) {
		super(message, e);
	}
}
