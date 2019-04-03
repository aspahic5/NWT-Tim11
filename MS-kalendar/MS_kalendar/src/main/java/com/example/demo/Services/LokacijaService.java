package com.example.demo.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

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
		catch(TransactionSystemException ex) {
			return ex.getRootCause().getMessage().toString();
			
		}
		
		return "Lokacija saved";
	}
	
	public String updateLokacija(Lokacija l) {
		try {
			lokacijaRepository.save(l);
		}
		catch(TransactionSystemException ex) {
			return ex.getRootCause().getMessage().toString();
			
		}
		
		return" Lokacija updated";
	}
	
public String deleteLokacija(int id) {
		
		try {
			lokacijaRepository.deleteById(id);;
		}
		catch(TransactionSystemException ex) {
			return ex.getRootCause().getMessage().toString();
			
		}
		
		return "Lokacija deleted";
	}
}
