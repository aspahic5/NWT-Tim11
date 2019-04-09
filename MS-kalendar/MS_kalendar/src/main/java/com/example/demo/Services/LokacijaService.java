package com.example.demo.Services;

import java.util.Optional;

import org.json.JSONObject;
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
		JSONObject o = new JSONObject();
		try {
			lokacijaRepository.save(l);
		}
		catch(TransactionSystemException ex) {
			o.put("message",ex.getRootCause().getMessage().toString());
			return o.toString();
			
		}
		
		o.put("message", "Lokacija saved");
		return o.toString();
	}
	
	public String updateLokacija(Lokacija l) {
		JSONObject o = new JSONObject();
		try {
			lokacijaRepository.save(l);
		}
		catch(TransactionSystemException ex) {
			o.put("message",ex.getRootCause().getMessage().toString());
			return o.toString();
			
		}
		
		o.put("message", "Lokacija updated");
		return o.toString();
	}
	
public String deleteLokacija(int id) {
		JSONObject o = new JSONObject();
		try {
			lokacijaRepository.deleteById(id);;
		}
		catch(TransactionSystemException ex) {
			o.put("message",ex.getRootCause().getMessage().toString());
			return o.toString();
			
		}
		
		o.put("message", "Lokacija deleted");
		return o.toString();
	}
}
