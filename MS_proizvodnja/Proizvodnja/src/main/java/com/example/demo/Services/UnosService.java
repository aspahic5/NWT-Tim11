package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Unos;
import com.example.demo.Repositories.UnosRepository;

@Service
public class UnosService {

	@Autowired
	private UnosRepository unosRepository;
	
	public String addUnos(Unos k) {
		
		try {
			unosRepository.save(k);
		}
		catch(Exception e) {
			return e.toString();
		}
		return "Unos saved";
	}
	
}
