package com.example.demo.Services;

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
	
	public String addUnos(Unos k, int idk) {
		
		if(!kR.findById(idk).isPresent()) return "Kosnica ne postoji";
		try {
			kR.findById(idk).map(kosnica -> {
                k.setKosnica(kosnica);
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
		return "Unos spremljen";
	}

	public String updateUnos(Unos k, int id){
		if(!pR.findById(id).isPresent()) return "Nemoguće je unijeti podatke za unos";
		try{
			pR.findById(id).map(unos -> {
				unos.setKolicina(k.getKolicina());
				//unos.setDatum(k.getDatum());
				return pR.save(unos);
			});
		}
		catch (TransactionSystemException  ex) {
            Throwable e = ex.getRootCause();
            return "Update Unos error: " + e.getMessage();
        }  
        catch(Exception e) {
            return "Update Unos error: " + e.toString();
        }
		return "Unos promijenjen";
	}

	public String deleteUnos(int id){
		if(!pR.findById(id).isPresent()) return "Nemoguće je obrisati podatke za unos";
		try{
			pR.deleteById(id);
		}
		catch(Exception e){
			return "delete Unos error: " + e.toString();
		}
		return "Unos obrisan";
	}
	
}
