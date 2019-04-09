package com.example.demo.Controllers;

import java.util.Optional;

import com.example.demo.Entities.Kosnica;
import com.example.demo.Services.KosnicaService;

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
public class KosnicaController {

    @Autowired
    KosnicaService kosnicaService;
    
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
    
    @RequestMapping(value = "/DajSveKosnice", method = RequestMethod.OPTIONS)
    public String GetAllKosnice(@RequestPart("username") String username, @RequestPart("password") String password) {
    	try {
    		JSONObject o=provjeri(username,password);
    	}
    	catch(Exception e) {
    		return e.getMessage().toString();
    	}
        return kosnicaService.findAll().toString();
    }

    @RequestMapping(value = "/Kosnica/{id}", method = RequestMethod.OPTIONS)
    public String getKosnicaById(@PathVariable int id, @RequestPart("username") String username, @RequestPart("password") String password) {
    	try {
        	JSONObject o=provjeri(username,password);
        }
        catch(Exception e) {
        	return e.getMessage().toString();
        }
    	JSONObject o1 = new JSONObject(kosnicaService.findById(id).get());
        return o1.toString();
    }

    @RequestMapping(value="/Kosnica", method=RequestMethod.POST)
    public String createKosnica(@RequestPart("Kosnica") Kosnica k, @RequestPart("username") String username, @RequestPart("password") String password) {
    	try {
        	JSONObject o=provjeri(username,password);
        }
        catch(Exception e) {
        	return e.getMessage().toString();
        }
        return kosnicaService.addKosnica(k);
    }

    @RequestMapping(value="/SelidbaNaKosnicu/{id}/{ids}", method=RequestMethod.PUT)
    public String addSelidbaToKosnica(@PathVariable int ids, @PathVariable int id, @RequestPart("username") String username, @RequestPart("password") String password) {
    	try {
        	JSONObject o=provjeri(username,password);
        }
        catch(Exception e) {
        	return e.getMessage().toString();
        }
        return kosnicaService.addSelidbaToKosnica(ids, id);
        
    }

    @RequestMapping(value="/AktivnostNaKosnicu/{id}/{ida}", method=RequestMethod.PUT)
    public String addAktivnostToKosnica(@PathVariable int ida, @PathVariable int id, @RequestPart("username") String username, @RequestPart("password") String password) {
    	try {
        	JSONObject o=provjeri(username,password);
        }
        catch(Exception e) {
        	return e.getMessage().toString();
        }
        return kosnicaService.addAktivnostToKosnica(ida, id);
    }

    @RequestMapping(value="/KosnicaNaKosnicu/{id}/{idk}", method=RequestMethod.PUT)
    public String addKosnicaToKosnica(@PathVariable int idk, @PathVariable int id, @RequestPart("username") String username, @RequestPart("password") String password) {
    	try {
        	JSONObject o=provjeri(username,password);
        }
        catch(Exception e) {
        	return e.getMessage().toString();
        }
        return kosnicaService.addKosnicaToKosnica(idk, id);
    }
    
    @RequestMapping(value="/Kosnica/{id}", method = RequestMethod.PUT)
    public String updateKosnica(@RequestPart("Kosnica") Kosnica k, @PathVariable int id, @RequestPart("username") String username, @RequestPart("password") String password) {
    	try {
        	JSONObject o=provjeri(username,password);
        }
        catch(Exception e) {
        	return e.getMessage().toString();
        }
        return kosnicaService.updateKosnica(id, k);
    }

    @RequestMapping(value="/Kosnica/{id}", method=RequestMethod.DELETE)
    public String deleteKosnica(@PathVariable int id, @RequestPart("username") String username, @RequestPart("password") String password) {
    	try {
        	JSONObject o=provjeri(username,password);
        }
        catch(Exception e) {
        	return e.getMessage().toString();
        }
        return kosnicaService.deleteKosnica(id);
    }
    
}