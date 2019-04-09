package com.example.demo.Controllers;

import java.util.Optional;

import javax.validation.Validator;

import com.example.demo.Entities.Selidba;
import com.example.demo.Services.SelidbaService;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class SelidbaController {

    @Autowired
    SelidbaService selidbaServis;
    
    @Autowired
    private RestTemplate restTemplate;
    
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

    @RequestMapping(value = "/DajSveSelidbe", method = RequestMethod.OPTIONS)
    public String getAllSelidbe(@RequestPart("username") String username, @RequestPart("password") String password) {
    	try {
        	JSONObject o=provjeri(username,password);
        }
        catch(Exception e) {
        	return e.getMessage().toString();
        }
        return selidbaServis.findAll().toString();
    }

    @RequestMapping(value = "/Selidba/{id}", method = RequestMethod.OPTIONS)
    public String getSelidbaById(@PathVariable int id, @RequestPart("username") String username, @RequestPart("password") String password) {
    	try {
        	JSONObject o=provjeri(username,password);
        }
        catch(Exception e) {
        	return e.getMessage().toString();
        }
        return selidbaServis.findById(id).toString();
    }

    @RequestMapping(value = "/Selidba/{idk}", method = RequestMethod.POST)
    public String createSelidba(@RequestPart("Selidba") Selidba s, @PathVariable int idk, @RequestPart("username") String username, @RequestPart("password") String password) {
    	try {
        	JSONObject o=provjeri(username,password);
        }
        catch(Exception e) {
        	return e.getMessage().toString();
        }
        return selidbaServis.addSelidba(s, idk);
    }

    @RequestMapping(value="/Selidba/{id}", method=RequestMethod.PUT)
    public String updateSelidba(@PathVariable int id, @RequestPart("Selidba") Selidba s, @RequestPart("username") String username, @RequestPart("password") String password) {
    	try {
        	JSONObject o=provjeri(username,password);
        }
        catch(Exception e) {
        	return e.getMessage().toString();
        }
        return selidbaServis.updateSelidba(id, s);
    }
    
    @RequestMapping(value="/Selidba/{id}", method=RequestMethod.DELETE)
    public String deleteSelidba(@PathVariable int id, @RequestPart("username") String username, @RequestPart("password") String password) {
    	try {
        	JSONObject o=provjeri(username,password);
        }
        catch(Exception e) {
        	return e.getMessage().toString();
        }
        return selidbaServis.delteSelidba(id);
    }
    



}