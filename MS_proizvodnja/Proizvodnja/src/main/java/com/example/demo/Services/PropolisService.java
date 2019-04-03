package com.example.demo.Services;

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
		if(!kR.findById(idk).isPresent()) return "Kosnica ne postoji";
		try {
			kR.findById(idk).map(kosnica -> {
                kosnica.setPropolis(k);
                pR.save(k);
                return kR.save(kosnica);
            });
		}
		catch (TransactionSystemException  ex) {
            Throwable e = ex.getRootCause();
            return e.getMessage();
        } 
        catch (Exception e) {
            return e.getMessage();
        }
		return "Propolis spremljen";
	}

	public String updatePropolis(Propolis k, int id){
		if(!pR.findById(id).isPresent()) return "Nemoguće je unijeti podatke za propolis";
		try{
			pR.findById(id).map(propolis -> {
				propolis.setKolicina(k.getKolicina());
				propolis.setKmkg(k.getKmkg());
				return pR.save(propolis);
			});
		}
		catch (TransactionSystemException  ex) {
            Throwable e = ex.getRootCause();
            return "Update Propolis error: " + e.getMessage();
        }  
        catch(Exception e) {
            return "Update Propolis error: " + e.toString();
        }
		return "Propolis promijenjen";
	}

	public String deletePropolis(int id){
		if(!pR.findById(id).isPresent()) return "Nemoguće je obrisati podatke za propolis";
		try{
			pR.deleteById(id);
		}
		catch(Exception e){
			return "delete Propolis error: " + e.toString();
		}
		return "Propolis obrisan";
	}
	
}
