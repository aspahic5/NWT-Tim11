package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Kosnica;
import com.example.demo.Repositories.KosnicaRepository;

@Service
public class KosnicaService {
	
	@Autowired
	private KosnicaRepository kosnicaRepository;
	
	public String addKosnica(Kosnica k) {
		
		try {
			kosnicaRepository.save(k);
		}
		catch(Exception e) {
			return e.toString();
		}
		return "Kosnica saved";
	}

}
