package com.example.demo.Controllers;

import java.util.Optional;

import com.example.demo.Entities.Vrcanje;
import com.example.demo.Repositories.VrcanjeRepository;
import com.example.demo.Services.VrcanjeService;

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
public class VrcanjeController {
	
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
    VrcanjeService pS;

    @RequestMapping(value = "/DajSvaVrcanja", method = RequestMethod.OPTIONS)
    public String GetAllVrcanja(@RequestPart("username") String username, @RequestPart("password") String password) {
    	try {
        	JSONObject o=provjeri(username,password);
        	}
        	catch(Exception e) {
        		return e.getMessage().toString();
        	}
        return pS.findAll().toString();
    }

    @RequestMapping(value = "/DajVrcanje/{id}", method = RequestMethod.OPTIONS)
    public String getVrcanjeById(@PathVariable int id,@RequestPart("username") String username, @RequestPart("password") String password) {
    	try {
        	JSONObject o=provjeri(username,password);
        }
        catch(Exception e) {
        	return e.getMessage().toString();
        }
        return pS.findById(id).toString();
    }

    @RequestMapping(value="/DodajVrcanje/{id}", method=RequestMethod.POST)
    public String createVrcanje(@RequestPart("json") Vrcanje p, @PathVariable int id,@RequestPart("username") String username, @RequestPart("password") String password) {
    	try {
        	JSONObject o=provjeri(username,password);
        }
        catch(Exception e) {
        	return e.getMessage().toString();
        }
        return pS.addVrcanje(p, id);
    }

    @RequestMapping(value="/AzurirajVrcanje/{id}", method = RequestMethod.PUT)
    public String updateVrcanje(@RequestPart("json") Vrcanje p, @PathVariable int id,@RequestPart("username") String username, @RequestPart("password") String password) {
    	try {
        	JSONObject o=provjeri(username,password);
        }
        catch(Exception e) {
        	return e.getMessage().toString();
        }
        return pS.updateVrcanje(p, id);
    }

    @RequestMapping(value="/ObrisiVrcanje/{id}", method=RequestMethod.DELETE)
    public String deleteVrcanje(@PathVariable int id,@RequestPart("username") String username, @RequestPart("password") String password) {
    	try {
        	JSONObject o=provjeri(username,password);
        }
        catch(Exception e) {
        	return e.getMessage().toString();
        }
        return pS.deleteVrcanje(id);
    }
    
}