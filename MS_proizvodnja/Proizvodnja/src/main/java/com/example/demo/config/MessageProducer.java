package com.example.demo.config;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageProducer {

	 @Autowired
	 private RabbitTemplate rabbitTemplate;
	 
	 public void sendMessage(String message) {


	
	  rabbitTemplate.convertAndSend(RabbitMqConfig.ROUTING_KEY, message);
	 
	 }
}
