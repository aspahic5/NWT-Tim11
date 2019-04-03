package com.example.demo.Services;

import java.util.Optional;

import com.example.demo.Entities.Rojenje;
import com.example.demo.Repositories.KosnicaRepository;
import com.example.demo.Repositories.RojenjeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

@Service
public class RojenjeService {

    @Autowired
    RojenjeRepository rojenjeRepository;

    @Autowired
    KosnicaRepository kosnicaRepository;

    public Iterable<Rojenje> findAll() {
        return rojenjeRepository.findAll();
    }

    public Optional<Rojenje> findById(int id) {
        return rojenjeRepository.findById(id);
    }

    public String addRojenje(Rojenje r, int idk) {
        if(!kosnicaRepository.findById(idk).isPresent()) return "Kosnica does not exist";
        try {
            kosnicaRepository.findById(idk).map(kosnica -> {
                r.setKosnice(kosnica);
                return rojenjeRepository.save(r);
            });
            
        } catch (TransactionSystemException  ex) {
            Throwable e = ex.getRootCause();
            return e.getMessage();
        } catch (Exception e) {
            return e.toString();
        }
        return "Rojenje saved";
    }

    public String updateRojenje(int id, Rojenje r){
        if(!rojenjeRepository.findById(id).isPresent()) return "Rojenje does not exist";
        try {
            rojenjeRepository.findById(id).map(rojenje -> {
                rojenje.setBrojmaticnjaka(r.getBrojmaticnjaka());
                rojenje.setKomentar(r.getKomentar());
                rojenje.setStarostmaticnjaka(r.getStarostmaticnjaka());
                rojenje.setTipmaticnjaka(r.getTipmaticnjaka());
                return rojenjeRepository.save(rojenje);
            });
        } catch (TransactionSystemException  ex) {
            Throwable e = ex.getRootCause();
            return "Update error: " + e.getMessage();
        } catch (Exception e) {
            return "Update error: " + e.toString();
        }
        return "Rojenje successfully updated";
    }

    public String deleteRojenje(int id){
        if(!rojenjeRepository.findById(id).isPresent()) return "Rojenje does not exist";
        try{
            rojenjeRepository.deleteById(id);;
        }
        catch(Exception e){
            return "Delete error: " + e.toString();
        }
        return "Rojenje successfully deleted";
    }
}