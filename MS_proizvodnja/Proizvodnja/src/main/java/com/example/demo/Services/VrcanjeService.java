package com.example.demo.Services;

import org.json.JSONObject;
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

	public Iterable<Vrcanje> findAllK(int idk){
		return pR.getIdSviK(idk);
	}


	public Optional<Vrcanje> findById(int id){
		return pR.findById(id);
	}
	
	public String addVrcanje(Vrcanje k, int idk) {
		JSONObject o = new JSONObject();
		if(!kR.findById(idk).isPresent()){
			 o.put("poruka", "Košnica ne postoji");
			 return o.toString();
		}
		try {
			kR.findById(idk).map(kosnica -> {
                kosnica.setVrcanje(k);
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
		o.put("poruka", "Vrcanje spremljeno");
		return o.toString();
	}

	public String updateVrcanje(Vrcanje k, int id){
		JSONObject o = new JSONObject();
		if(!pR.findById(id).isPresent()){
			o.put("poruka", "Nemoguće je unijeti podatke za vrcanje");
			 return o.toString();
		};
		try{
			pR.findById(id).map(vrcanje -> {
				vrcanje.setKolicina(k.getKolicina());
				vrcanje.setKmkg(k.getKmkg());
				return pR.save(vrcanje);
			});
		}
		catch (TransactionSystemException  ex) {
			Throwable e = ex.getRootCause();
			o.put("Update Vrcanje error", e.getMessage());
            return o.toString();
        }  
        catch(Exception e) {
            o.put("Update Vrcanje error", e.getMessage());
            return o.toString();
		}
		o.put("poruka", "Vrcanje promijenjeno");
		return o.toString();
	}

	public String deleteVrcanje(int id){
		JSONObject o = new JSONObject();
		if(!pR.findById(id).isPresent()){
			o.put("poruka", "Nemoguće je obrisati podatke za vrcanje");
			return o.toString();
		} 
		try{
			pR.deleteById(id);
		}
		catch(Exception e){
			o.put("delete Vrcanje error", e.getMessage());
            return o.toString();
		}
		o.put("poruka", "Vrcanje obrisano");
		return o.toString();
	}
}
