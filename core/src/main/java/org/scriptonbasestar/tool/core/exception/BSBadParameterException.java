package org.scriptonbasestar.tool.core.exception;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author archmagece
 * @CreatedAt 2016-12-19 18
 */
@Slf4j
public class BSBadParameterException extends BSRuntimeBaseException {
	public BSBadParameterException(String message) {
		super(message);
	}
}
