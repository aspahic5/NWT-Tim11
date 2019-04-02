package com.example.demo.Services;

import java.util.Optional;

import com.example.demo.Entities.Varoa;
import com.example.demo.Repositories.KosnicaRepository;
import com.example.demo.Repositories.VaroaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

@Service
public class VaroaService {

    @Autowired
    VaroaRepository varoaRepository;

    @Autowired
    KosnicaRepository kosnicaRepository;

    public Iterable<Varoa> findAll() {
        return varoaRepository.findAll();
    }

    public Optional<Varoa> findById(int id) {
        return varoaRepository.findById(id);
    }

    public String addVaroa(Varoa v, int idk) {
        if(!kosnicaRepository.findById(idk).isPresent()) return "Kosnica does not exist";
        try {
            kosnicaRepository.findById(idk).map(kosnica -> {
                v.setKosnice(kosnica);
                return varoaRepository.save(v);
            });
        } catch (TransactionSystemException  ex) {
            Throwable e = ex.getRootCause();
            return "Add Varoa error: " + e.getMessage();
        }catch (Exception e) {
            return "Add Varoa error: " + e.toString();
        }
        return "Varoa saved";
    }

    public String updateVaroa(int id, Varoa v) {
        if(!varoaRepository.findById(id).isPresent()) return "Varoa does not exist";
        try {
            varoaRepository.findById(id).map(varoa -> {
                varoa.setBroj(v.getBroj());
                varoa.setKomentar(v.getKomentar());
                varoa.setPrimjecena(v.getPrimjecena());
                return varoaRepository.save(varoa);
            });
        } catch (TransactionSystemException  ex) {
            Throwable e = ex.getRootCause();
            return "Update Varoa error: " + e.getMessage();
        }catch (Exception e) {
            return "Update Varoa error: " + e.toString();
        }
        return "Varoa successfully updated";
    }

    public String deleteVaroa(int id){
        if(!varoaRepository.findById(id).isPresent()) return "Varoa does not exist";
        try{
            varoaRepository.deleteById(id);
        } catch(Exception e) {
            return "Delete Varoa error: "  + e.toString();
        }
        return "Varoa successfully deleted";
    }
}