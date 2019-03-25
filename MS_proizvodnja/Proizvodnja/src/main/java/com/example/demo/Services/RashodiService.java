package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Rashodi;
import com.example.demo.Repositories.RashodiRepository;

@Service
public class RashodiService {
	
	@Autowired
	private RashodiRepository rashodiRepository;
	
	public String addRashod(Rashodi r) {
		try {
			rashodiRepository.save(r);
		}
		catch(Exception e) {
			return e.toString();
		}
		return "Rashod add";
	}

}
