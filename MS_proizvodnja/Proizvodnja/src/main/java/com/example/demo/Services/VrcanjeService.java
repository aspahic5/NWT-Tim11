package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Vrcanje;
import com.example.demo.Repositories.VrcanjeRepository;

@Service
public class VrcanjeService {
	@Autowired
	private VrcanjeRepository unosRepository;
	
	public String addVrcanje(Vrcanje k) {
		
		try {
			unosRepository.save(k);
		}
		catch(Exception e) {
			return e.toString();
		}
		return "Vrcanje saved";
	}
}
