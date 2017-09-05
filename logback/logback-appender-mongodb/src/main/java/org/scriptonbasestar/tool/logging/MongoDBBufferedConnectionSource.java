package org.scriptonbasestar.tool.logging;

import ch.qos.logback.classic.spi.ILoggingEvent;
import com.mongodb.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;

public class MongoDBBufferedConnectionSource {

	private volatile DBCollection dbCollection = null;

	@Setter
	private String uri = null;

	@Setter
	private String dbName = null;

	@Setter
	private String collection = null;

	@Getter
	@Setter
	private String hostname = null;

	private String profileName = System.getProperty("spring.profiles.active");

	@Getter
	@Setter
	private static LinkedBlockingDeque<ILoggingEvent> queue = new LinkedBlockingDeque<>();

	protected DBCollection getDBCollection() {
		DBCollection dbCollectionHelper = dbCollection;
		if (dbCollectionHelper == null) {
			synchronized (this) {
				dbCollectionHelper = dbCollection;
				if (dbCollectionHelper == null) {
					try {
						final Mongo mongo = new MongoClient(new MongoClientURI(uri));
						dbCollection = mongo.getDB(dbName).getCollection(collection);
						Runtime.getRuntime().addShutdownHook(
							new Thread(new Runnable() {
								@Override
								public void run() {
									mongo.close();
								}
							}, "mongo shutdown"));
					} catch (MongoException mongoException) {
						mongoException.printStackTrace();
					}
				}
			}
		}
		return dbCollection;
	}

	public void run() {
		while (true) {
			if (!queue.isEmpty()) {
				BasicDBList logList = new BasicDBList();
				ILoggingEvent event = queue.getLast();

				BasicDBObject logEntry = new BasicDBObject();
				logEntry.append("message", event.getFormattedMessage());
				logEntry.append("logger", event.getLoggerName());
				logEntry.append("thread", event.getThreadName());
				logEntry.append("timestamp", new Date(event.getTimeStamp()));
				logEntry.append("level", event.getLevel().toString());
				logEntry.append("hostname", hostname);
				logEntry.append("profileName", profileName);
//				logEntry.append("argument", eventObject.getArgumentArray().toString());
//				logEntry.append("callerData", eventObject.getCallerData().toString());
//				logEntry.append("marker", eventObject.getMarker().toString());
				logList.add(logEntry);

				getDBCollection().insert(logList);
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
//				e.printStackTrace();
			}
		}
	}

}
