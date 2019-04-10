package com.example.demo.Services;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

import java.util.Optional;

import com.example.demo.Entities.Rashodi;
import com.example.demo.Repositories.KosnicaRepository;
import com.example.demo.Repositories.RashodiRepository;

@Service
public class RashodiService {
	
	@Autowired
	private RashodiRepository pR;

	@Autowired
	private KosnicaRepository kR;

	public Iterable<Rashodi> findAll(){
		return pR.findAll();
	}

	public Optional<Rashodi> findById(int id){
		return pR.findById(id);
	}
	

	public String addRashod(Rashodi k, int idk) {
		JSONObject o = new JSONObject();
		if(!kR.findById(idk).isPresent()){
			 o.put("poruka", "Košnica ne postoji");
			 return o.toString();
		}
		try {
			kR.findById(idk).map(kosnica -> {
                kosnica.setRashod(k);
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
		o.put("poruka", "Rashod spremljen");
		return o.toString();
	}

	public String updateRashod(Rashodi k, int id){
		JSONObject o = new JSONObject();
		if(!pR.findById(id).isPresent()){
			o.put("poruka", "Nemoguće je unijeti podatke za rashod");
			 return o.toString();
		};
		try{
			pR.findById(id).map(rashod -> {
				rashod.setCijena(k.getCijena());
				return pR.save(rashod);
			});
		}
		catch (TransactionSystemException  ex) {
			Throwable e = ex.getRootCause();
			o.put("Update Rashod error", e.getMessage());
            return o.toString();
        }  
        catch(Exception e) {
            o.put("Update Rashod error", e.getMessage());
            return o.toString();
		}
		o.put("poruka", "Rashod promijenjen");
		return o.toString();
	}

	public String deleteRashod(int id){
		JSONObject o = new JSONObject();
		if(!pR.findById(id).isPresent()){
			o.put("poruka", "Nemoguće je obrisati podatke za rashod");
			return o.toString();
		} 
		try{
			pR.deleteById(id);
		}
		catch(Exception e){
			o.put("delete Rashod error", e.getMessage());
            return o.toString();
		}
		o.put("poruka", "Rashod obrisan");
		return o.toString();
	}

}
