package com.example.demo.Services;

import java.util.Optional;

import com.example.demo.Entities.Selidba;
import com.example.demo.Repositories.SelidbaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

@Service
public class SelidbaService {

    @Autowired
    SelidbaRepository selidbaRepository;

    public Iterable<Selidba> findAll() {
        return selidbaRepository.findAll();
    }

    public Optional<Selidba> findById(int id) {
        return selidbaRepository.findById(id);
    }

    public String addSelidba(Selidba s) {
        try {
            selidbaRepository.save(s);
        } catch (TransactionSystemException  ex) {
            Throwable e = ex.getRootCause();
            return e.getMessage();
        }catch (Exception e) {
            return e.toString();
        }
        return "Selidba saved";
    }

    public String updateSelidba(int id, Selidba s){
        if(!selidbaRepository.findById(id).isPresent()) return "Selidba does not exist";
        try{
            selidbaRepository.findById(id).map(selidba -> {
                selidba.setBrojkosnica(s.getBrojkosnica());
                selidba.setDobit(s.getDobit());
                selidba.setKraj(s.getKraj());
                selidba.setPocetak(s.getPocetak());
                selidba.setLokacija(s.getLokacija());
                return selidbaRepository.save(selidba);
            }); 
        } catch (TransactionSystemException  ex) {
            Throwable e = ex.getRootCause();
            return "Update Selidba error: " + e.getMessage();
        }catch(Exception e) {
            return "Update Selidba error: " + e.toString();
        }
        return "Selidba successfully updated";
    }

    public String delteSelidba(int id){
        if(!selidbaRepository.findById(id).isPresent()) return "Selidba does not exist";
        try{
            selidbaRepository.deleteById(id);
        } catch(Exception e){
            return "Delete Selidba error: " + e.toString();
        }
        return "Selidba successfully deleted";
    }
}