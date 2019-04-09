package com.example.demo.Controllers;

import java.util.Optional;

import com.example.demo.Entities.Rojenje;
import com.example.demo.Services.RojenjeService;

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
public class RojenjeController {

    @Autowired
    RojenjeService rojenjeService;
    
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

    @RequestMapping(value = "/DajSvaRojenja", method = RequestMethod.OPTIONS)
    public String getAllRojenje(@RequestPart("username") String username, @RequestPart("password") String password) {
    	try {
    		JSONObject o=provjeri(username,password);
    	}
    	catch(Exception e) {
    		return e.getMessage().toString();
    	}
        return rojenjeService.findAll().toString();
    }

    @RequestMapping(value = "/Rojenje/{id}", method = RequestMethod.OPTIONS)
    public String getRojenjeById(@PathVariable int id, @RequestPart("username") String username, @RequestPart("password") String password) {
    	try {
        	JSONObject o=provjeri(username,password);
        }
        catch(Exception e) {
        	return e.getMessage().toString();
        }
        return rojenjeService.findById(id).toString();
    }

    @RequestMapping(value="/Rojenje/{idk}", method=RequestMethod.POST)
    public String createRojenje(@RequestPart("Rojenje") Rojenje r, @PathVariable int idk, @RequestPart("username") String username, @RequestPart("password") String password) {
    	try {
        	JSONObject o=provjeri(username,password);
        }
        catch(Exception e) {
        	return e.getMessage().toString();
        }
        return rojenjeService.addRojenje(r, idk);
    }

    @RequestMapping(value = "/Rojenje/{id}", method=RequestMethod.PUT)
    public String updateRojenje(@PathVariable int id, @RequestPart Rojenje r, @RequestPart("username") String username, @RequestPart("password") String password) {
    	try {
    		JSONObject o=provjeri(username,password);
        }
        catch(Exception e) {
        	return e.getMessage().toString();
        }
        return rojenjeService.updateRojenje(id, r);
    }
    
    @RequestMapping(value = "/Rojenje/{id}", method=RequestMethod.DELETE)
    public String updateRojenje(@PathVariable int id, @RequestPart("username") String username, @RequestPart("password") String password) {
    	try {
    		JSONObject o=provjeri(username,password);
        }
        catch(Exception e) {
        	return e.getMessage().toString();
        }
        return rojenjeService.deleteRojenje(id);
    }

}