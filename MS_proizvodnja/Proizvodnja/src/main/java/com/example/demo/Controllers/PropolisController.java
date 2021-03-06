package com.example.demo.Controllers;

import java.sql.Date;
import java.util.Optional;

import com.example.demo.Entities.Maticna_mlijec;
import com.example.demo.Entities.Propolis;
import com.example.demo.Services.PropolisService;
import com.google.gson.Gson;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class PropolisController {

	public JSONObject provjeri(String username,String password) throws Exception {
		HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.MULTIPART_FORM_DATA);
    	MultiValueMap<String, Object> body= new LinkedMultiValueMap<>();
    	body.add("username",username);
    	body.add("password", password);
    	
    	HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);
    	 
    	ResponseEntity<String> response = restTemplate.postForEntity("http://autentifikacija/provjeri", requestEntity, String.class);
    	JSONObject o=new JSONObject(response.getBody().toString());
    	if(!o.getBoolean("prijavljen")) {
    		throw new Exception("{\"message\":\"Pogresan username ili password \"}");
    	}
    	
    	return o;
	}
	
	 @Autowired
	 private RestTemplate restTemplate;
	
    @Autowired
    PropolisService pS;

    @RequestMapping(value = "/Propolis", method = RequestMethod.OPTIONS)
    public String GetAllPropolises(@RequestPart("username") String username, @RequestPart("password") String password) {
    	try {
        	JSONObject o=provjeri(username,password);
        	}
        	catch(Exception e) {
        		return e.getMessage().toString();
        	}
    	return new Gson().toJson(pS.findAll());
    }

    @RequestMapping(value = "/Propolis/{id}", method = RequestMethod.OPTIONS)
    public String GetAllPropolisesK(@PathVariable int id,@RequestPart("username") String username, @RequestPart("password") String password) {
    	try {
        	JSONObject o=provjeri(username,password);
        	}
        	catch(Exception e) {
        		return e.getMessage().toString();
        	}
    	return new Gson().toJson(pS.findAllK(id));
	}
	
	

    @RequestMapping(value="/Propolis/{id}", method=RequestMethod.POST)
    public String createPropolis(@RequestPart("json") String p, @PathVariable int id,@RequestPart("username") String username, @RequestPart("password") String password) {
    	try {
        	JSONObject o=provjeri(username,password);
        	}
        	catch(Exception e) {
        		return e.getMessage().toString();
        	}
    	JSONObject o1 = new JSONObject(p);
    	Propolis m = new Propolis(o1.getDouble("kolicina"), o1.getDouble("km_kg"));
        return pS.addPropolis(m, id);
    }

    @RequestMapping(value="/Propolis/{id}", method = RequestMethod.PUT)
    public String updatePropolis(@RequestPart("json") String p, @PathVariable int id, @RequestPart("username") String username, @RequestPart("password") String password) {
    	try {
        	JSONObject o=provjeri(username,password);
        	}
        	catch(Exception e) {
        		return e.getMessage().toString();
        	}
    	JSONObject o1 = new JSONObject(p);
    	Propolis m = new Propolis(o1.getDouble("kolicina"), o1.getDouble("km_kg"));
        return pS.updatePropolis(m, id);
    }

    @RequestMapping(value="/Propolis/{id}", method=RequestMethod.DELETE)
    public String deletePropolis(@PathVariable int id, @RequestPart("username") String username, @RequestPart("password") String password) {
    	try {
        	JSONObject o=provjeri(username,password);
        	}
        	catch(Exception e) {
        		return e.getMessage().toString();
        	}
        return pS.deletePropolis(id);
    }
    
}