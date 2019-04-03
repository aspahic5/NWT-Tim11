package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

import java.util.Optional;

import com.example.demo.Entities.Vrcanje;
import com.example.demo.Repositories.KosnicaRepository;
import com.example.demo.Repositories.VrcanjeRepository;

@Service
public class VrcanjeService {
	
	@Autowired
	private VrcanjeRepository pR;

	@Autowired
	private KosnicaRepository kR;

	public Iterable<Vrcanje> findAll(){
		return pR.findAll();
	}


	public Optional<Vrcanje> findById(int id){
		return pR.findById(id);
	}
	
	public String addVrcanje(Vrcanje k, int idk) {
		if(!kR.findById(idk).isPresent()) return "Kosnica ne postoji";
		try {
			kR.findById(idk).map(kosnica -> {
                kosnica.setVrcanje(k);
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
		return "Vrcanje spremljeno";
	}

	public String updateVrcanje(Vrcanje k, int id){
		if(!pR.findById(id).isPresent()) return "Nemoguće je unijeti podatke za vrcanje";
		try{
			pR.findById(id).map(vrcanje -> {
				vrcanje.setKolicina(k.getKolicina());
				vrcanje.setKmkg(k.getKmkg());
				return pR.save(vrcanje);
			});
		}
		catch (TransactionSystemException  ex) {
            Throwable e = ex.getRootCause();
            return "Update Vrcanje error: " + e.getMessage();
        }  
        catch(Exception e) {
            return "Update Vrcanje error: " + e.toString();
        }
		return "Vrcanje promijenjeno";
	}

	public String deleteVrcanje(int id){
		if(!pR.findById(id).isPresent()) return "Nemoguće je obrisati podatke za vrcanje";
		try{
			pR.deleteById(id);
		}
		catch(Exception e){
			return "delete Vrcanje error: " + e.toString();
		}
		return "Vrcanje obrisano";
	}
}
