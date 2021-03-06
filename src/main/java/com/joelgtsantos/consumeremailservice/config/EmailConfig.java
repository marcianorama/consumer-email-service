/**
 * 
 */
package com.joelgtsantos.consumeremailservice.config;



import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;



/**
 * @author Joel Santos
 *
 *         consumer-email-service 2018
 */
@Configuration
@EnableRabbit
public class EmailConfig implements RabbitListenerConfigurer {
	
	static final String queueName = "cmsServiceQueue";
	
	@Autowired
	public ConnectionFactory connectionFactory;
	
	
	@Bean
	public Exchange eventExchange() {
		return new TopicExchange("cmsExchange");
	}

	@Bean
	public Queue queue() {
		return new Queue("cmsServiceQueue");
	}

	@Bean
	public Binding binding(Queue queue, TopicExchange eventExchange) {
		return BindingBuilder.bind(queue).to(eventExchange).with("user.*");
	}
	
	@Bean
	public DefaultMessageHandlerMethodFactory myHandlerMethodFactory() {
	    DefaultMessageHandlerMethodFactory factory = new DefaultMessageHandlerMethodFactory();
	    factory.setMessageConverter(new MappingJackson2MessageConverter());
	    return factory;
	}

	@Override
	public void configureRabbitListeners(RabbitListenerEndpointRegistrar registrar) {
		registrar.setMessageHandlerMethodFactory(myHandlerMethodFactory());
	}
}
