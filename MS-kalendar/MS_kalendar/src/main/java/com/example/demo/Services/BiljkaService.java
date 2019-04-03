package com.example.demo.Services;

import java.util.Optional;

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
	
	public String addBiljka(Biljka l) {
		
		try {
			biljkaRepository.save(l);
		}
		catch(TransactionSystemException ex) {
			return ex.getRootCause().getMessage().toString();
			
		}
		
		return "Biljka saved";
	}
	
	public String updateBiljka(Biljka b) {
		try {
			biljkaRepository.save(b);
		}
		catch(TransactionSystemException ex) {
			return ex.getRootCause().getMessage().toString();
			
		}
		
		return "Biljka updated";
	}
	
	public String deleteBiljka(int id) {
		try {
			biljkaRepository.deleteById(id);
		}
		catch(TransactionSystemException ex) {
			return ex.getRootCause().getMessage().toString();
			
		}
		
		return "Biljka deleted";
	}
}
