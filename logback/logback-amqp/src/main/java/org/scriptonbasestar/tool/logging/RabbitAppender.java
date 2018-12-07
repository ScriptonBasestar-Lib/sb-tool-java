package org.scriptonbasestar.tool.logging;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.UnsynchronizedAppenderBase;
import com.google.gson.Gson;
import com.rabbitmq.client.*;
import lombok.Setter;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeoutException;

/**
 * @author archmagece
 * @with sb-tool-java
 * @since 2015-08-10-13
 */
public class RabbitAppender
	extends UnsynchronizedAppenderBase<ILoggingEvent> {

	@Setter
	private String hostname;

	@Setter
	private String profileName;

	private final String requestQueueName;

	private ConnectionFactory factory;
	private Connection connection;
	private Channel channel;
	private String replyQueueName;
	private Consumer consumer;

	private Gson gson = new Gson();

	public RabbitAppender(String host, String requestQueueName) throws Exception {
		this.requestQueueName = requestQueueName;

		this.factory = new ConnectionFactory();
		this.factory.setHost(host);

		reconnect();
	}

	public void reconnect() throws IOException, TimeoutException {
		this.connection = factory.newConnection();
		this.channel = connection.createChannel();

		this.replyQueueName = channel.queueDeclare().getQueue();
		this.consumer = new DefaultConsumer(channel);
		this.channel.basicConsume(replyQueueName, true, consumer);
	}

	@Override
	protected void append(ILoggingEvent eventObject) {
		LoggingDto requestData = new LoggingDto();
		requestData.setMessage(eventObject.getMessage());
		requestData.setLogger(eventObject.getLoggerName());
		requestData.setThread(eventObject.getThreadName());
		requestData.setTimestamp(new Date(eventObject.getTimeStamp()));
		requestData.setLevel(eventObject.getLevel().toString());
		requestData.setHostname(hostname);
		requestData.setProfileName(profileName);

		String corrId = UUID.randomUUID().toString();

		AMQP.BasicProperties replyProps = new AMQP.BasicProperties.Builder()
			.correlationId(corrId)
			.replyTo(replyQueueName)
			.build();

		String message = gson.toJson(requestData);
		try {
			channel.basicPublish("", requestQueueName, replyProps, message.getBytes("UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
