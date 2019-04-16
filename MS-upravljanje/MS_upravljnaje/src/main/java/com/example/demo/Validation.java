package com.example.demo;

import com.example.demo.Repositories.AktivnostRepositroy;
import com.example.demo.Repositories.KosnicaRepository;
import com.example.demo.Repositories.RojenjeRepository;
import com.example.demo.Repositories.SelidbaRepository;
import com.example.demo.Repositories.VaroaRepository;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class Validation {

    @Autowired
    SelidbaRepository selidbaRepository;

    @Autowired
    KosnicaRepository kosnicaRepository;

    @Autowired
    RojenjeRepository rojenjeRepository;

    @Autowired
    VaroaRepository varoaRepository;

    @Autowired
    AktivnostRepositroy aktivnostRepository;

    @Autowired
    RestTemplate restTemplate;

    public void PostojiSelidba(int id) throws Exception {
        if(!selidbaRepository.findById(id).isPresent()) {
            throw new Exception("Selidba ne postoji");
        }
    } 

    public void PostojiKosnica(int id) throws Exception {
        if(!kosnicaRepository.findById(id).isPresent()) {   
            throw new Exception("Košnica ne postoji");
        }
    }

    public void PostojiRojenje(int id) throws Exception {
        if(!rojenjeRepository.findById(id).isPresent()) {
            throw new Exception("Rojenje ne postoji");
        }
    }

    public void PostojiVaroa(int id) throws Exception {
        if(!varoaRepository.findById(id).isPresent()) {
            throw new Exception("Varoa ne postoji");
        }
    }

    public void PostojiAktivnost(int id) throws Exception {
        if(!aktivnostRepository.findById(id).isPresent()) {
            throw new Exception("Aktivnost ne postoji");
        }
    }

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
}