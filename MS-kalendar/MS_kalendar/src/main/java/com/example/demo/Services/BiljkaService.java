package com.example.demo.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		catch(Exception e) {
			return e.toString();
		}
		
		return "Biljka saved";
	}
}
