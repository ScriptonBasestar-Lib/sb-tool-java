package org.scriptonbasestar.tool.core.exception;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author archmagece
 * @CreatedAt 2016-12-19 18
 */
@Slf4j
public class SBBadParameterException extends SBRuntimeBaseException {
	public SBBadParameterException(String message) {
		super(message);
	}
}
