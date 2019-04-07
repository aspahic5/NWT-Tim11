package com.example.demo.Services;

import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

import com.example.demo.Entities.Biljka;
import com.example.demo.Repositories.BiljkaRepository;


@Service
public class BiljkaService {

	@Autowired
	BiljkaRepository biljkaRepository;
	
	public Iterable<Biljka> findAll() {
		return biljkaRepository.findAll();
	}

	public Optional<Biljka> findById(int id) {
		return biljkaRepository.findById(id);
	}
	
	public JSONObject addBiljka(Biljka l) {
		JSONObject o = new JSONObject();
		try {
			biljkaRepository.save(l);
		}
		catch(TransactionSystemException ex) {
			o.put("message",ex.getRootCause().getMessage().toString());
			return o;
			
		}
		
		o.put("message", "Biljka saved");
		
		return o;
	}
	
	public JSONObject updateBiljka(Biljka b) {
		JSONObject o = new JSONObject();
		try {
			biljkaRepository.save(b);
		}
		catch(TransactionSystemException ex) {
			o.put("message",ex.getRootCause().getMessage().toString());
			return o;
			
		}
		
		o.put("message", "Biljka updated");
		
		return o;
	}
	
	public JSONObject deleteBiljka(int id) {
		JSONObject o = new JSONObject();
		try {
			biljkaRepository.deleteById(id);
		}
		catch(TransactionSystemException ex) {
			o.put("message",ex.getRootCause().getMessage().toString());
			return o;
			
		}
		
		o.put("message", "Biljka deleted");
		
		return o;
	}
}
