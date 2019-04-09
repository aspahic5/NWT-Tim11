package com.example.demo.Controllers;

import java.util.Optional;

import com.example.demo.Entities.Varoa;
import com.example.demo.Services.VaroaService;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;


@RestController
public class VaroaController {

    @Autowired
    VaroaService varoaService;
    
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

    @RequestMapping(value = "/DajSveVaroe", method = RequestMethod.GET)
    public String getAllVaroe(@RequestPart("username") String username, @RequestPart("password") String password) {
    	try {
        	JSONObject o=provjeri(username,password);
        }
        catch(Exception e) {
        	return e.getMessage().toString();
        }
        return varoaService.findAll().toString();
    }

    @RequestMapping(value = "/Varoa/{id}", method = RequestMethod.GET)
    public String getVaroaById(@PathVariable int id, @RequestPart("username") String username, @RequestPart("password") String password) {
    	try {
        	JSONObject o=provjeri(username,password);
        }
        catch(Exception e) {
        	return e.getMessage().toString();
        }
        return varoaService.findById(id).toString();
    }

    @RequestMapping(value="/Varoa/{idk}", method=RequestMethod.POST)
    public String addVaroa(@RequestPart("Varoa") Varoa v, @PathVariable int idk, @RequestPart("username") String username, @RequestPart("password") String password) {
    	try {
        	JSONObject o=provjeri(username,password);
        }
        catch(Exception e) {
        	return e.getMessage().toString();
        }
        return varoaService.addVaroa(v, idk);
    }
    @RequestMapping(value="/Varoa/{id}", method=RequestMethod.PUT)
    public String updateVaroa(@PathVariable int id, @RequestPart("Varoa") Varoa v, @RequestPart("username") String username, @RequestPart("password") String password) {
    	try {
        	JSONObject o=provjeri(username,password);
        }
        catch(Exception e) {
        	return e.getMessage().toString();
        }
        return varoaService.updateVaroa(id, v);
    }
    
    @RequestMapping(value="/Varoa/{id}", method=RequestMethod.DELETE)
    public String deleteVaroa(@PathVariable int id, @RequestPart("username") String username, @RequestPart("password") String password) {
    	try {
        	JSONObject o=provjeri(username,password);
        }
        catch(Exception e) {
        	return e.getMessage().toString();
        }
        return varoaService.deleteVaroa(id);
    }
    

    
}