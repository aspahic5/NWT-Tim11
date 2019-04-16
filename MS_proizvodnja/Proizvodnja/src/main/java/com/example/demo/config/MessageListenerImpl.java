package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.json.JSONArray;
import org.json.JSONObject;
import com.example.demo.Services.KosnicaService;

@Component
public class MessageListenerImpl implements MessageListener{

	
	@Autowired
    KosnicaService kS;
	
	
	  @Override
	  public void onMessage(String message) {
	   try {
	    Thread.sleep(5000);
	   } catch (InterruptedException e) {
	    e.printStackTrace();
	   }
	   try {
		   JSONArray a = new JSONArray(message);
		   int[] ids = new int[a.length()];
		   for(int i=0; i<a.length(); i++) {
			   JSONObject o = a.getJSONObject(i);
			   ids[i] = o.getInt("id");
		   }
		   kS.addKosnica(ids);
	   }
	   catch(Exception e) {
		   System.out.println(e.getMessage().toString());
		   
	   }
	   System.out.println("Message Received:"+message);
	  }
	
}
