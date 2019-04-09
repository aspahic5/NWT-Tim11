package com.example.demo.Controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.example.demo.Entities.Aktivnost;
import com.example.demo.Entities.Korisnik;
import com.example.demo.Services.AktivnostService;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
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
public class AktivnostController {

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
    AktivnostService aktivnostService;
    
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/DajSveAktivnosti", method = RequestMethod.OPTIONS)
    public String getAllAktivnosti(@RequestPart("username") String username, @RequestPart("password") String password) {
    	try {
    	JSONObject o=provjeri(username,password);
    	}
    	catch(Exception e) {
    		return e.getMessage().toString();
    	}
    	return aktivnostService.findAll().toString();
    	
    }

    @RequestMapping(value = "/Aktivnost/{id}", method = RequestMethod.GET)
    public Optional<Aktivnost> getAktivnostById(@PathVariable int id) {
    	
        return aktivnostService.findById(id);
    }

    @RequestMapping(value="/Aktivnost/{idk}", method=RequestMethod.POST)
    public String createAktivnost(@RequestBody Aktivnost a, @PathVariable int idk) {
    	
        return aktivnostService.addAktivnost(a, idk);
    }

    @RequestMapping(value="/Aktivnost/{id}", method=RequestMethod.PUT)
    public String updateAktivnost(@PathVariable int id, @RequestBody Aktivnost a) {
        return aktivnostService.updateAktivnost(id, a);
    }

    @RequestMapping(value="/Aktivnost/{id}", method=RequestMethod.DELETE)
    public String deleteAktivnost(@PathVariable int id) {
        return aktivnostService.deleteAktivnost(id);
    }
    

}