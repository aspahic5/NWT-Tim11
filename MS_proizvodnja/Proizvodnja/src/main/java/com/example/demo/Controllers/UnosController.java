package com.example.demo.Controllers;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

import com.example.demo.Entities.Rashodi;
import com.example.demo.Entities.Unos;
import com.example.demo.Services.UnosService;
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
public class UnosController {
    
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
    UnosService pS;

    @RequestMapping(value = "/DajSveUnose", method = RequestMethod.OPTIONS)
    public String GetAllUnose(@RequestPart("username") String username, @RequestPart("password") String password) {
    	try {
        	JSONObject o=provjeri(username,password);
        	}
        	catch(Exception e) {
        		return e.getMessage().toString();
        	}
    	return new Gson().toJson(pS.findAll());
    }

    @RequestMapping(value = "/Unos/{id}", method = RequestMethod.OPTIONS)
    public String getUnosById(@PathVariable int id,@RequestPart("username") String username, @RequestPart("password") String password) {
    	try {
        	JSONObject o=provjeri(username,password);
        	}
        	catch(Exception e) {
        		return e.getMessage().toString();
        	}
			return new Gson().toJson(pS.findAllK(id));
    }

    @RequestMapping(value="/Unos/{id}", method=RequestMethod.POST)
    public String createUnos(@RequestPart("json") String p, @PathVariable int id,@RequestPart("username") String username, @RequestPart("password") String password) {
    	try {
        	JSONObject o=provjeri(username,password);
        	}
        	catch(Exception e) {
        		return e.getMessage().toString();
        	}
    	JSONObject o1 = new JSONObject(p);
    	Unos m = new Unos(o1.getDouble("kolicina"), Date.valueOf(LocalDate.now().toString()));
        return pS.addUnos(m, id);
    }

    @RequestMapping(value="/Unos/{id}", method = RequestMethod.PUT)
    public String updateUnos(@RequestPart("json") Unos p, @PathVariable int id,@RequestPart("username") String username, @RequestPart("password") String password) {
    	try {
        	JSONObject o=provjeri(username,password);
        	}
        	catch(Exception e) {
        		return e.getMessage().toString();
        	}
        return pS.updateUnos(p, id);
    }

    @RequestMapping(value="/Unos/{id}", method=RequestMethod.DELETE)
    public String deleteUnos(@PathVariable int id, @RequestPart("username") String username, @RequestPart("password") String password) {
    	try {
        	JSONObject o=provjeri(username,password);
        }
        catch(Exception e) {
        	return e.getMessage().toString();
        }
        return pS.deleteUnos(id);
    }

}