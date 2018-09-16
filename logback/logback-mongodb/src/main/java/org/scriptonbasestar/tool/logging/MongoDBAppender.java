package org.scriptonbasestar.tool.logging;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.UnsynchronizedAppenderBase;
import com.mongodb.BasicDBObject;

import java.util.Date;

public class MongoDBAppender extends UnsynchronizedAppenderBase<ILoggingEvent> {

	private MongoDBConnectionSource connectionSource = null;
	private String hostname;
	private String profileName;

	public void setConnectionSource(MongoDBConnectionSource connectionSource) {
		this.connectionSource = connectionSource;
		this.hostname = connectionSource.getHostname();
		this.profileName = System.getProperty("spring.profiles.active");
	}

	@Override
	protected void append(ILoggingEvent eventObject) {
		BasicDBObject logEntry = new BasicDBObject();
		logEntry.append("message", eventObject.getFormattedMessage());
		logEntry.append("logger", eventObject.getLoggerName());
		logEntry.append("thread", eventObject.getThreadName());
		logEntry.append("timestamp", new Date(eventObject.getTimeStamp()));
		logEntry.append("level", eventObject.getLevel().toString());
		logEntry.append("hostname", hostname);
		logEntry.append("profileName", profileName);
//		logEntry.append("argument", eventObject.getArgumentArray().toString());
//		logEntry.append("callerData", eventObject.getCallerData().toString());
//		logEntry.append("marker", eventObject.getMarker().toString());
		connectionSource.getDBCollection().insert(logEntry);
	}

}
