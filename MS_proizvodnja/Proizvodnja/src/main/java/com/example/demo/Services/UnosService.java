package com.example.demo.Services;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

import java.util.Optional;

import com.example.demo.Entities.Unos;
import com.example.demo.Repositories.KosnicaRepository;
import com.example.demo.Repositories.UnosRepository;

@Service
public class UnosService {

	@Autowired
	private UnosRepository pR;
	
	@Autowired
	private KosnicaRepository kR;


	public Iterable<Unos> findAll(){
		return pR.findAll();
	}


	public Optional<Unos> findById(int id){
		return pR.findById(id);
	}

	public Iterable<Unos> findAllK(int id){
		return pR.getIdsK(id);
	}
	
	public String addUnos(Unos k, int idk) {
		JSONObject o = new JSONObject();
		if(!kR.findById(idk).isPresent()){
			 o.put("poruka", "Košnica ne postoji");
			 return o.toString();
		}
		try {
			kR.findById(idk).map(kosnica -> {
                k.setKosnica(kosnica);
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
		o.put("poruka", "Unos spremljen");
		return o.toString();
	}

	public String updateUnos(Unos k, int id){
		JSONObject o = new JSONObject();
		if(!pR.findById(id).isPresent()){
			o.put("poruka", "Nemoguće je unijeti podatke za unos");
			 return o.toString();
		};
		try{
			pR.findById(id).map(unos -> {
				unos.setKolicina(k.getKolicina());
				//unos.setDatum(k.getDatum());
				return pR.save(unos);
			});
		}
		catch (TransactionSystemException  ex) {
			Throwable e = ex.getRootCause();
			o.put("Update Unos error", e.getMessage());
            return o.toString();
        }  
        catch(Exception e) {
            o.put("Update Unos error", e.getMessage());
            return o.toString();
		}
		o.put("poruka", "Unos promijenjen");
		return o.toString();
	}

	public String deleteUnos(int id){
		JSONObject o = new JSONObject();
		if(!pR.findById(id).isPresent()){
			o.put("poruka", "Nemoguće je obrisati podatke za unos");
			return o.toString();
		} 
		try{
			pR.deleteById(id);
		}
		catch(Exception e){
			o.put("delete Unos error", e.getMessage());
            return o.toString();
		}
		o.put("poruka", "Unos obrisan");
		return o.toString();
	}
	
}
