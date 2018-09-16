package org.scriptonbasestar.tool.logging;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.UnsynchronizedAppenderBase;
import com.google.gson.Gson;
import lombok.Setter;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.util.Date;

/**
 * @author archmagece
 * @with sb-tool-java
 * @since 2015-08-10-13
 */
public class AmqpJsonAppender extends UnsynchronizedAppenderBase<ILoggingEvent> {

	@Setter
	private String hostname;

	@Setter
	private String profileName;

	private RabbitTemplate template = null;

	private Gson gson = new Gson();

//	public AmqpJsonAppender(AmqpJsonConnectionSource amqpConnectionSource) throws Exception {
//		template = amqpConnectionSource.rabbitTemplate();
//	}

	AmqpJsonConnectionSource amqpConnectionSource = null;
	public void setAmqpJsonConnectionSource(AmqpJsonConnectionSource amqpConnectionSource){
		this.template = amqpConnectionSource.rabbitTemplate();
		this.amqpConnectionSource = amqpConnectionSource;
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

		String message = gson.toJson(requestData);
		Message message1 = new Message(message.getBytes(), new MessageProperties());
//		template.send(amqpConnectionSource.getExchangeName(), amqpConnectionSource.getRoutingKeyPattern(), message1);
		template.send(message1);
	}
}
