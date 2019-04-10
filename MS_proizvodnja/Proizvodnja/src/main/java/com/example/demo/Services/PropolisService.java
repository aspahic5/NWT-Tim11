package com.example.demo.Services;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

import java.util.Optional;

import com.example.demo.Entities.Propolis;
import com.example.demo.Repositories.KosnicaRepository;
import com.example.demo.Repositories.PropolisRepository;

@Service
public class PropolisService {

	@Autowired
	private PropolisRepository pR;

	@Autowired
	private KosnicaRepository kR;


	public Iterable<Propolis> findAll(){
		return pR.findAll();
	}


	public Optional<Propolis> findById(int id){
		return pR.findById(id);
	}
	

	public String addPropolis(Propolis k, int idk) {
		JSONObject o = new JSONObject();
		if(!kR.findById(idk).isPresent()){
			 o.put("poruka", "Košnica ne postoji");
			 return o.toString();
		}
		try {
			kR.findById(idk).map(kosnica -> {
                kosnica.setPropolis(k);
                pR.save(k);
                return kR.save(kosnica);
            });
		}
		catch (TransactionSystemException  ex) {
			o.put("poruka",ex.getRootCause().getMessage().toString());
			return o.toString();
        } 
        catch (Exception e) {
            o.put("poruka", e.getMessage());
			return o.toString();
        }
		o.put("poruka", "Propolis spremljen");
		return o.toString();
	}

	public String updatePropolis(Propolis k, int id){
		JSONObject o = new JSONObject();
		if(!pR.findById(id).isPresent()){
			o.put("poruka", "Nemoguće je unijeti podatke za propolis");
			 return o.toString();
		};
		try{
			pR.findById(id).map(propolis -> {
				propolis.setKolicina(k.getKolicina());
				propolis.setKmkg(k.getKmkg());
				return pR.save(propolis);
			});
		}
		catch (TransactionSystemException  ex) {
			Throwable e = ex.getRootCause();
			o.put("Update Propolis error", e.getMessage());
            return o.toString();
        }  
        catch(Exception e) {
            o.put("Update Propolis error", e.getMessage());
            return o.toString();
		}
		o.put("poruka", "Propolis promijenjen");
		return o.toString();
	}

	public String deletePropolis(int id){
		JSONObject o = new JSONObject();
		if(!pR.findById(id).isPresent()){
			o.put("poruka", "Nemoguće je obrisati podatke za propolis");
			return o.toString();
		} 
		try{
			pR.deleteById(id);
		}
		catch(Exception e){
			o.put("delete Propolis error", e.getMessage());
            return o.toString();
		}
		o.put("poruka", "Propolis obrisan");
		return o.toString();
	}
	
}
