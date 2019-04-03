package com.example.demo.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

import com.example.demo.Entities.Korisnik;
import com.example.demo.Repositories.KorisnikRepository;


@Service
public class KorisnikService {

	@Autowired
	private KorisnikRepository korisnikRepository;
	
	
	
	public Optional<Korisnik> getKorisnikById(int id) {
		
		return korisnikRepository.findById(id);
		
	}
	
	public String addKorisnik(Korisnik k) {
		
		try {
			korisnikRepository.save(k);
		}
		catch(TransactionSystemException ex) {
			return ex.getRootCause().getMessage().toString();
			
		}
		
		return "Korisnik saved";
		
	}
	
	public String deleteKorisnik(int id) {
		try {
			korisnikRepository.deleteById(id);
		}
		catch(TransactionSystemException ex) {
			return ex.getRootCause().getMessage().toString();
			
		}
		
		return "Korisnik deleted";
	}
	
public String updateKorisnik(Korisnik k) {
		
		try {
			korisnikRepository.save(k);
		}
		catch(TransactionSystemException ex) {
			return ex.getRootCause().getMessage().toString();
			
		}
		
		return "Korisnik updated";
		
	}


	
}
