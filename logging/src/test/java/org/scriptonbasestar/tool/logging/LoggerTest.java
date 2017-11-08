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
		ConsoleLogger.setLogLevel(LogLevelType.WARN);
		loggerPrint();
	}

	@Test
	public void info_test(){
		ConsoleLogger.setLogLevel(LogLevelType.INFO);
		loggerPrint();
	}

	@Test
	public void debug_test(){
		ConsoleLogger.setLogLevel(LogLevelType.DEBUG);
		loggerPrint();
	}

	private void loggerPrint(){
		ConsoleLogger.fatal("fatal");
		ConsoleLogger.error("error");
		ConsoleLogger.warn("warn");
		ConsoleLogger.info("info");
		ConsoleLogger.debug("debug");
		ConsoleLogger.trace("trace");
	}

}
