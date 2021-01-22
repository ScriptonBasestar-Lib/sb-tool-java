package org.scriptonbasestar.tool.logging;

import lombok.Getter;
import lombok.Setter;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;

import java.nio.charset.Charset;

/**
 * @author archmagece
 * @with sb-tool-java
 * @since 2015-08-10-13
 */
public class AmqpJsonConnectionSource {

	//	@Getter
	@Setter
	private String host = null;

	@Setter
	private int port = 5672;

	@Getter
	@Setter
	private String exchangeName = null;

	@Setter
	private String exchangeType = null;

	@Setter
	private String applicationId = null;

	@Getter
	@Setter
	private String routingKeyPattern = null;

	@Setter
	private boolean generateId = true;

	@Setter
	private Charset charset = null;

	@Setter
	private boolean durable = false;

	@Setter
	private String deliveryMode = "NON_PERSISTENT";

	private CachingConnectionFactory connectionFactory = null;

	private ConnectionFactory connectionFactory() {
		if (connectionFactory == null) {
			connectionFactory = new CachingConnectionFactory();
			connectionFactory.setHost(this.host);
			connectionFactory.setUsername("guest");
			connectionFactory.setPassword("guest");
			connectionFactory.setPort(port);
		}
		return connectionFactory;
	}

	private RabbitAdmin rabbitAdmin() {
		// set up the queue, exchange, binding on the broker
		RabbitAdmin admin = new RabbitAdmin(connectionFactory);
		Queue queue = new Queue(exchangeName);
		admin.declareQueue(queue);
		TopicExchange exchange = new TopicExchange(exchangeType, durable, true);
		admin.declareExchange(exchange);
		admin.declareBinding(BindingBuilder.bind(queue).to(exchange).with(routingKeyPattern));
		return admin;
	}

	private MessageConverter jsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}

	private RabbitTemplate template = null;

	public synchronized RabbitTemplate rabbitTemplate() {
		if (template == null) {
//			rabbitAdmin();
			template = new RabbitTemplate(connectionFactory());
			template.setExchange(exchangeName);
			template.setRoutingKey(routingKeyPattern);
			template.setDefaultReceiveQueue(exchangeType);
			template.setMessageConverter(jsonMessageConverter());
		}
		return template;
	}
}
