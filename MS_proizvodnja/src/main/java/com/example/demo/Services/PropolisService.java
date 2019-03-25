package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Propolis;
import com.example.demo.Repositories.PropolisRepository;

@Service
public class PropolisService {

	@Autowired
	private PropolisRepository unosRepository;
	
	public String addPropolis(Propolis k) {
		
		try {
			unosRepository.save(k);
		}
		catch(Exception e) {
			return e.toString();
		}
		return "Propolis saved";
	}
	
}
