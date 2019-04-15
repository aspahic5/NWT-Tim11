package com.example.demo.config;

import org.springframework.stereotype.Component;

@Component
public class MessageListenerImpl implements MessageListener{

	  @Override
	  public void onMessage(String message) {
	   
	   try {
	    Thread.sleep(5000);
	   } catch (InterruptedException e) {
	    e.printStackTrace();
	   }
	   System.out.println("Message Received:"+message);
	  }
	
}
