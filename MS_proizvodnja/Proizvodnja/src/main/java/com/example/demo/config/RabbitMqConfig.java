package com.example.demo.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableRabbit
@Configuration
public class RabbitMqConfig {

	  public static final String ROUTING_KEY = "proizvodnja";
	  
	  @Bean
	  Queue queue() {
	   return new Queue(ROUTING_KEY, true);
	  }


	  @Bean
	  TopicExchange exchange() {
	   return new TopicExchange("proizvodnja_exchange");
	  }


	  @Bean
	  Binding binding(Queue queue, TopicExchange exchange) {
	   return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
	  }
	  
	  @Bean
	  SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
	  MessageListenerAdapter listenerAdapter) {
	   SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
	   container.setConnectionFactory(connectionFactory);
	   container.setQueueNames("upravljanje");
	   container.setMessageListener(listenerAdapter);
	   return container;
	  }


	  @Bean
	  MessageListenerAdapter myQueueListener(MessageListener listener) {
	   return new MessageListenerAdapter(listener, "onMessage");
	  }
	  


	
}
