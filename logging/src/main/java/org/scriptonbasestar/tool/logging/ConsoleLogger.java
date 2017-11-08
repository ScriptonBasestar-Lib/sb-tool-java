package org.scriptonbasestar.tool.logging;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * @author archmagece
 * @since 2017-01-22 10
 */
public class ConsoleLogger {

	private static LogLevelType logLevel;
	private static String LOG_FORMAT = "%s ";

	public static void setLogLevel(LogLevelType logLevel) {
		ConsoleLogger.logLevel = logLevel;
	}

	private static PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out));


	public static void fatal(String message) {
		write(LogLevelType.FATAL, message);
	}

	public static void fatal(String message, Object... args) {
		format(LogLevelType.FATAL, message, args);
	}


	public static void error(String message) {
		write(LogLevelType.ERROR, message);
	}

	public static void error(String message, Object... args) {
		format(LogLevelType.ERROR, message, args);
	}


	public static void warn(String message) {
		write(LogLevelType.WARN, message);
	}

	public static void warn(String message, Object... args) {
		format(LogLevelType.WARN, message, args);
	}


	public static void info(String message) {
		write(LogLevelType.INFO, message);
	}

	public static void info(String message, Object... args) {
		format(LogLevelType.INFO, message, args);
	}


	public static void debug(String message) {
		write(LogLevelType.DEBUG, message);
	}

	public static void debug(String message, Object... args) {
		format(LogLevelType.DEBUG, message, args);
	}


	public static void trace(String message) {
		write(LogLevelType.TRACE, message);
	}

	public static void trace(String message, Object... args) {
		format(LogLevelType.TRACE, message, args);
	}


	private static void write(LogLevelType logLevel, String message) {
		if (ConsoleLogger.logLevel.ordinal() >= logLevel.ordinal()) {
			synchronized (printWriter) {
				printWriter.format(LOG_FORMAT, logLevel);
				printWriter.write(message);
				printWriter.println();
				printWriter.flush();
			}
		}
	}

	private static void format(LogLevelType logLevel, String message, Object... args) {
		if (ConsoleLogger.logLevel.ordinal() >= logLevel.ordinal()) {

		}
		synchronized (printWriter) {
			printWriter.format(LOG_FORMAT, logLevel);
			printWriter.format(message, args);
			printWriter.println();
			printWriter.flush();
		}
	}


	public static void destructor() {
		printWriter.close();
	}
}
