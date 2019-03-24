package com.example.demo.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Lokacija;
import com.example.demo.Repositories.LokacijaRepository;

@Service
public class LokacijaService {
	
	@Autowired
	LokacijaRepository lokacijaRepository;
	
	public Iterable<Lokacija> findAll() {
		return lokacijaRepository.findAll();
	}

	public Optional<Lokacija> findById(int id) {
		return lokacijaRepository.findById(id);
	}
	
	public String addLokacija(Lokacija l) {
		
		try {
			lokacijaRepository.save(l);
		}
		catch(Exception e) {
			return e.toString();
		}
		
		return "Lokacija saved";
	}
}
