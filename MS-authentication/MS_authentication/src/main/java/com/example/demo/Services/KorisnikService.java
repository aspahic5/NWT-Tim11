package com.example.demo.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

import com.example.demo.Entities.Korisnik;
import com.example.demo.Repositories.KorisnikRepository;

import org.json.JSONObject;


@Service
public class KorisnikService {

	@Autowired
	private KorisnikRepository korisnikRepository;
	
	
	
	public Optional<Korisnik> getKorisnikById(int id) {
		
		return korisnikRepository.findById(id);
		
	}
	
	public JSONObject addKorisnik(Korisnik k) {
		JSONObject o = new JSONObject();
		try {
			korisnikRepository.save(k);
		}
		catch(TransactionSystemException ex) {
			
			o.put("message",ex.getRootCause().getMessage().toString());
			return o;
			
		}
		o.put("message", "Korisnik saved");
		
		return o;
		
	}
	
	public JSONObject deleteKorisnik(int id) {
		JSONObject o = new JSONObject();
		try {
			korisnikRepository.deleteById(id);
		}
		catch(TransactionSystemException ex) {
			o.put("message",ex.getRootCause().getMessage().toString());
			return o;
			
		}
		
		o.put("message", "Korisnik deleted");
		
		return o;
	}
	
public JSONObject updateKorisnik(Korisnik k) {
		JSONObject o = new JSONObject();
		try {
			korisnikRepository.save(k);
		}
		catch(TransactionSystemException ex) {
			o.put("message",ex.getRootCause().getMessage().toString());
			return o;
			
		}
		
		o.put("message", "Korisnik updated");
		
		return o;
		
	}


	
}
