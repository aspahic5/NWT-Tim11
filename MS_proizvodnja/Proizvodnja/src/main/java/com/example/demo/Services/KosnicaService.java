package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Kosnica;
import com.example.demo.Repositories.KosnicaRepository;

import org.json.JSONObject;;

@Service
public class KosnicaService {
	
	@Autowired
	private KosnicaRepository kosnicaRepository;
	
	public String addKosnica(Kosnica k) {
		JSONObject o = new JSONObject();
		try {
			kosnicaRepository.save(k);
		}
		catch(Exception e) {
			o.put("poruka", e.getMessage());
			return o.toString();
		}
		o.put("poruka", "Košnica spremljena");
		return o.toString();
	}

}
