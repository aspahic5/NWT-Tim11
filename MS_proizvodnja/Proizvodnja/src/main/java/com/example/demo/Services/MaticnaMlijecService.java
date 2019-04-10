package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

import java.util.Optional;

import com.example.demo.Entities.Maticna_mlijec;
import com.example.demo.Repositories.KosnicaRepository;
import com.example.demo.Repositories.MaticnaMlijecRepository;

import org.json.JSONObject;

@Service
public class MaticnaMlijecService {
	
	@Autowired
	private MaticnaMlijecRepository mR;

	@Autowired
	private KosnicaRepository kR;

	public Iterable<Maticna_mlijec> findAll(){
		return mR.findAll();
	}


	public Optional<Maticna_mlijec> findById(int id){
		return mR.findById(id);
	}
	
	public String addMaticna(Maticna_mlijec m, int idk) {
		JSONObject o = new JSONObject();
		if(!kR.findById(idk).isPresent()){
			 o.put("poruka", "Košnica ne postoji");
			 return o.toString();
		}
		try {
			kR.findById(idk).map(kosnica -> {
                kosnica.setMaticna(m);
                mR.save(m);
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
		o.put("poruka", "Matična mliječ spremljena");
		return o.toString();
	}

	public String updateMaticna(Maticna_mlijec m, int id){
		JSONObject o = new JSONObject();
		if(!mR.findById(id).isPresent()){
			o.put("poruka", "Nemoguće je unijeti podatke za matičnu mliječ");
			 return o.toString();
		};
		try{
			mR.findById(id).map(maticna -> {
				maticna.setKolicina(m.getKolicina());
				maticna.setKmkg(m.getKmkg());
				return mR.save(maticna);
			});
		}
		catch (TransactionSystemException  ex) {
			Throwable e = ex.getRootCause();
			o.put("Update Matična mliječ error", e.getMessage());
            return o.toString();
        }  
        catch(Exception e) {
            o.put("Update Matična mliječ error", e.getMessage());
            return o.toString();
		}
		o.put("poruka", "Matična mliječ promijenjena");
		return o.toString();
	}

	public String deleteMaticna(int id){
		JSONObject o = new JSONObject();
		if(!mR.findById(id).isPresent()){
			o.put("poruka", "Nemoguće je obrisati podatke za matičnu mliječ");
			return o.toString();
		} 
		try{
			mR.deleteById(id);
		}
		catch(Exception e){
			o.put("delete Matična mliječ error", e.getMessage());
            return o.toString();
		}
		o.put("poruka", "Matična mliječ obrisana");
		return o.toString();
	}

}
