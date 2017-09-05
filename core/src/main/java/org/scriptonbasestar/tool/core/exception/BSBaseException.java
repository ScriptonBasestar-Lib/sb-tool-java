package org.scriptonbasestar.tool.core.exception;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author archmagece
 * @CreatedAt 2016-10-21 17
 */
@Slf4j
public abstract class BSBaseException extends Exception {
	public BSBaseException(String message) {
		super(message);
	}
}
