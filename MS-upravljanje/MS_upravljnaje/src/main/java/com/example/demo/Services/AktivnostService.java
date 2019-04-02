package com.example.demo.Services;

import java.util.Optional;

import javax.persistence.RollbackException;
import javax.validation.ConstraintViolationException;

import com.example.demo.Entities.Aktivnost;
import com.example.demo.Repositories.AktivnostRepositroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

@Service
public class AktivnostService {

    @Autowired
    AktivnostRepositroy aktivnostrepository;

    public Iterable<Aktivnost> findAll() {
        return aktivnostrepository.findAll();
    }

    public Optional<Aktivnost> findById(int id) {
        Optional<Aktivnost> a = aktivnostrepository.findById(id);
        return a;
    }

    public String addAktivnost(Aktivnost a){
        try {
            aktivnostrepository.save(a);
        }
        catch (TransactionSystemException  ex) {
            Throwable e = ex.getRootCause();
            return e.getMessage();
        } 
        catch (Exception e) {
            return e.getMessage();
        }
        return "Aktivnost saved";
    }

    public String updateAktivnost(int id, Aktivnost a) {
        if(!aktivnostrepository.findById(id).isPresent()) return "Aktivnost does not exist";
        try {
            aktivnostrepository.findById(id).map(aktivnost -> {
                aktivnost.setMjesec(a.getMjesec());
                aktivnost.setUradjeno(a.getUradjeno());
                aktivnost.setAktivnost(a.getAktivnost());
                return aktivnostrepository.save(aktivnost);
            });
        }
        catch (TransactionSystemException  ex) {
            Throwable e = ex.getRootCause();
            return "Update Aktinvost error: " + e.getMessage();
        }  
        catch(Exception e) {
            return "Update Aktinvost error: " + e.toString();
        }
        return "Aktivnost successfully updated";
    }

    public String deleteAktivnost(int id){
        if(!aktivnostrepository.findById(id).isPresent()) return "Aktivnost does not exist";
        try {
            aktivnostrepository.deleteById(id);
        } catch(Exception e) {
            return "delete Aktivnost error: " + e.toString();
        }
        return "Aktivnost successfully deleted";
    }
}