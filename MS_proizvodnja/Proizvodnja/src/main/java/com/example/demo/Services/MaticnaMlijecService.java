package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

import java.util.Optional;

import com.example.demo.Entities.Maticna_mlijec;
import com.example.demo.Repositories.KosnicaRepository;
import com.example.demo.Repositories.MaticnaMlijecRepository;

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
		
		if(!kR.findById(idk).isPresent()) return "Kosnica ne postoji";
		try {
			kR.findById(idk).map(kosnica -> {
                kosnica.setMaticna(m);
                mR.save(m);
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
		return "Matična mliječ spremljena";
	}

	public String updateMaticna(Maticna_mlijec m, int id){
		if(!mR.findById(id).isPresent()) return "Nemoguće je unijeti podatke za matičnu mliječ";
		try{
			mR.findById(id).map(maticna -> {
				maticna.setKolicina(m.getKolicina());
				maticna.setKmkg(m.getKmkg());
				return mR.save(maticna);
			});
		}
		catch (TransactionSystemException  ex) {
            Throwable e = ex.getRootCause();
            return "Update Matična mliječ error: " + e.getMessage();
        }  
        catch(Exception e) {
            return "Update Matična mliječ error: " + e.toString();
        }
		return "Matična mliječ promijenjena";
	}

	public String deleteMaticna(int id){
		if(!mR.findById(id).isPresent()) return "Nemoguće je obrisati podatke za matičnu mliječ";
		try{
			mR.deleteById(id);
		}
		catch(Exception e){
			return "delete Matična mliječ error: " + e.toString();
		}
		return "Matična mliječ obrisana";
	}

}
