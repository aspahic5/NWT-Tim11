package com.example.demo.Controllers;

import java.sql.Date;
import java.util.Optional;

import com.example.demo.Entities.Varoa;
import com.example.demo.Services.VaroaService;
import com.google.gson.Gson;

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
import org.springframework.web.bind.annotation.RequestParam;



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
    	return new Gson().toJson(varoaService.findAll());
    }

    @RequestMapping(value = "/Varoa/{id}", method = RequestMethod.GET)
    public String getVaroaById(@PathVariable int id, @RequestPart("username") String username, @RequestPart("password") String password) {
    	try {
        	JSONObject o=provjeri(username,password);
        }
        catch(Exception e) {
        	return e.getMessage().toString();
        }
    	JSONObject o1 = new JSONObject(varoaService.findById(id).get());
        return o1.toString();
    }

    @RequestMapping(value="/Varoa/{idk}", method=RequestMethod.POST)
    public String addVaroa( @PathVariable int idk, @RequestPart("Varoa") String v, @RequestPart("username") String username, @RequestPart("password") String password) {
    	try {
        	JSONObject o=provjeri(username,password);
        }
        catch(Exception e) {
        	return e.getMessage().toString();
        }
    	JSONObject o1 = new JSONObject(v);
    	Varoa v1 = new Varoa(null, o1.getInt("broj"), Date.valueOf(o1.getString("primjecena")), o1.getString("komentar"));
        return varoaService.addVaroa(v1, idk);
    }
    @RequestMapping(value="/Varoa/{id}", method=RequestMethod.PUT)
    public String updateVaroa(@PathVariable int id, @RequestPart("Varoa") String v, @RequestPart("username") String username, @RequestPart("password") String password) {
    	try {
        	JSONObject o=provjeri(username,password);
        }
        catch(Exception e) {
        	return e.getMessage().toString();
        }
    	JSONObject o1 = new JSONObject(v);
    	Varoa v1 = new Varoa(null, o1.getInt("broj"), Date.valueOf(o1.getString("primjecena")), o1.getString("komentar"));
        return varoaService.updateVaroa(id, v1);
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
     @RequestMapping(value="/Varoa/{idk}", method=RequestMethod.PATCH)
     public String getVaroeOdKosnica(@PathVariable int idk, @RequestPart("username") String username, @RequestPart("password") String password) {
    	try {
            JSONObject o=provjeri(username,password);
            return new Gson().toJson(varoaService.getVaroeOdKosnica(idk));
        }
        catch(Exception e) {
        	return e.getMessage().toString();
        }
     }
     

    
}