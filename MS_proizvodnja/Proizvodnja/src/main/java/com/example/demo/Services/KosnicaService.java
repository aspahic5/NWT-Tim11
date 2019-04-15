package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Kosnica;
import com.example.demo.Repositories.KosnicaRepository;

import java.util.Optional;

import org.json.JSONObject;

@Service
public class KosnicaService {
	
	@Autowired
	private KosnicaRepository kosnicaRepository;
	
	public Optional<Kosnica> findById(int id) {
        return kosnicaRepository.findById(id);
    }
	
	public String addKosnica(int[] ids) {
		JSONObject o = new JSONObject();
		Integer j = 0;
		try {
			for(int i = 0; i<ids.length; i++) {
				if(kosnicaRepository.findById(ids[i]).isPresent())
					continue;
				else {
					kosnicaRepository.save(new Kosnica(ids[i]));
					j++;
				}
			}
		}
		catch(Exception e) {
			o.put("poruka", e.getMessage());
			return o.toString();
		}
		o.put("poruka","Spremljeno je " + j.toString() + " košnica");
		return o.toString();
	}

}
