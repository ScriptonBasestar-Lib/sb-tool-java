package org.scriptonbasestar.tool.core.exception.data;

import org.scriptonbasestar.tool.core.exception.SBRuntimeBaseException;

/**
 * @Author archmagece
 * @CreatedAt 2016-12-07 18
 */
public class SBDataException extends SBRuntimeBaseException {
	public SBDataException(String message) {
		super(message);
	}
	public SBDataException(String message, Throwable e) {
		super(message, e);
	}
}
