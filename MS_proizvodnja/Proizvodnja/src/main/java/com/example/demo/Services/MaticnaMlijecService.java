package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Maticna_mlijec;
import com.example.demo.Repositories.MaticnaMlijecRepository;

@Service
public class MaticnaMlijecService {
	@Autowired
	private MaticnaMlijecRepository unosRepository;
	
	public String addMlijec(Maticna_mlijec k) {
		
		try {
			unosRepository.save(k);
		}
		catch(Exception e) {
			return e.toString();
		}
		return "Mlijec saved";
	}
}
