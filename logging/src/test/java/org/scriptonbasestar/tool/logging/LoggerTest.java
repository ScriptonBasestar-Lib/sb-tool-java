package org.scriptonbasestar.tool.logging;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @athor archmagece
 * @since 2017-01-24 21
 */
@Slf4j
public class LoggerTest {

	@Test
	public void warn_test(){
		Logger.setLogLevel(LogLevelType.WARN);
		loggerPrint();
	}

	@Test
	public void info_test(){
		Logger.setLogLevel(LogLevelType.INFO);
		loggerPrint();
	}

	@Test
	public void debug_test(){
		Logger.setLogLevel(LogLevelType.DEBUG);
		loggerPrint();
	}

	private void loggerPrint(){
		Logger.fatal("fatal");
		Logger.error("error");
		Logger.warn("warn");
		Logger.info("info");
		Logger.debug("debug");
		Logger.trace("trace");
	}

}
