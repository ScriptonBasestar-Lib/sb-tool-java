package org.beansugar.tool.test.exception;

import lombok.extern.slf4j.Slf4j;
import org.scriptonbasestar.tool.core.exception.runtime.SBRuntimeBaseException;

/**
 * @Author archmagece
 * @CreatedAt 2016-10-11 20
 */
@Slf4j
public class BsToolsTestException extends SBRuntimeBaseException {

	public BsToolsTestException(String message) {
		super(message);
	}
}
