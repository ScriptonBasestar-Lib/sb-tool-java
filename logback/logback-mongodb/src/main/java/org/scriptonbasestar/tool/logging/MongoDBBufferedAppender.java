package org.scriptonbasestar.tool.logging;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.UnsynchronizedAppenderBase;

import java.util.concurrent.LinkedBlockingDeque;

public class MongoDBBufferedAppender extends UnsynchronizedAppenderBase<ILoggingEvent> {

	private MongoDBConnectionSource connectionSource = null;
	private LinkedBlockingDeque<ILoggingEvent> queue;

	public void setConnectionSource(MongoDBConnectionSource connectionSource) {
		this.connectionSource = connectionSource;
//		this.queue = connectionSource.getDBCollection();
	}

	@Override
	protected void append(ILoggingEvent eventObject) {
		queue.add(eventObject);
	}

}
