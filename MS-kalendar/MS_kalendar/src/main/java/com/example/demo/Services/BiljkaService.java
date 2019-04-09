package com.example.demo.Services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

import com.example.demo.Entities.Biljka;
import com.example.demo.Repositories.BiljkaRepository;
import com.example.demo.Repositories.LokacijaRepository;


@Service
public class BiljkaService {

	@Autowired
	BiljkaRepository biljkaRepository;
	
	@Autowired
	LokacijaRepository lokacijaRepository;
	
	
	public ArrayList<Biljka> biljkaLokacija(String lokacija){
		ArrayList<Biljka> biljke = new ArrayList<Biljka>();
		try {
			int id=lokacijaRepository.getIdlokacije(lokacija);
			Iterable<Integer> ids=biljkaRepository.getIds(id);
	    	for(int i :ids) {
	    		Biljka b= biljkaRepository.getBiljka(i);
	    		biljke.add(b);
	    	}
		}
    	catch(Exception e) {
    		
		}
    	return biljke;
	}
	
	public Iterable<Biljka> findAll() {
		return biljkaRepository.findAll();
	}

	public Optional<Biljka> findById(int id) {
		return biljkaRepository.findById(id);
	}
	
	public String addBiljka(Biljka l) {
		JSONObject o = new JSONObject();
		try {
			biljkaRepository.save(l);
		}
		catch(TransactionSystemException ex) {
			o.put("message",ex.getRootCause().getMessage().toString());
			return o.toString();
			
		}
		
		o.put("message", "Biljka saved");
		
		return o.toString();
	}
	
	public String updateBiljka(Biljka b) {
		JSONObject o = new JSONObject();
		try {
			biljkaRepository.save(b);
		}
		catch(TransactionSystemException ex) {
			o.put("message",ex.getRootCause().getMessage().toString());
			return o.toString();
			
		}
		
		o.put("message", "Biljka updated");
		
		return o.toString();
	}
	
	public String deleteBiljka(int id) {
		JSONObject o = new JSONObject();
		try {
			biljkaRepository.deleteById(id);
		}
		catch(TransactionSystemException ex) {
			o.put("message",ex.getRootCause().getMessage().toString());
			return o.toString();
			
		}
		
		o.put("message", "Biljka deleted");
		
		return o.toString();
	}
}
