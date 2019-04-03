package com.example.demo.Services;

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
		if(!kR.findById(idk).isPresent()) return "Kosnica ne postoji";
		try {
			kR.findById(idk).map(kosnica -> {
                kosnica.setRashod(k);
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
		return "Rashod spremljen";
	}

	public String updateRashod(Rashodi k, int id){
		if(!pR.findById(id).isPresent()) return "Nemoguće je unijeti podatke za rashod";
		try{
			pR.findById(id).map(rashod -> {
				rashod.setCijena(k.getCijena());
				return pR.save(rashod);
			});
		}
		catch (TransactionSystemException  ex) {
            Throwable e = ex.getRootCause();
            return "Update Rashod error: " + e.getMessage();
        }  
        catch(Exception e) {
            return "Update Rashod error: " + e.toString();
        }
		return "Rashod promijenjen";
	}

	public String deleteRashod(int id){
		if(!pR.findById(id).isPresent()) return "Nemoguće je obrisati podatke za rashod";
		try{
			pR.deleteById(id);
		}
		catch(Exception e){
			return "delete Rashod error: " + e.toString();
		}
		return "Rashod obrisan";
	}

}
