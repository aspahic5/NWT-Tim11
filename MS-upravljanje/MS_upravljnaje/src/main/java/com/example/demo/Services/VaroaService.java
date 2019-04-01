package com.example.demo.Services;

import java.util.Optional;

import com.example.demo.Entities.Varoa;
import com.example.demo.Repositories.VaroaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VaroaService {

    @Autowired
    VaroaRepository varoaRepository;

    public Iterable<Varoa> findAll() {
        return varoaRepository.findAll();
    }

    public Optional<Varoa> findById(int id) {
        return varoaRepository.findById(id);
    }

    public String addVaroa(Varoa v) {
        try {
            varoaRepository.save(v);
        } catch (Exception e) {
            return "Add Varoa error: " + e.toString();
        }
        return "Selidba saved";
    }

    public String updateVaroa(int id, Varoa v){
        try {
            varoaRepository.findById(id).map(varoa -> {
                varoa.setBroj(v.getBroj());
                varoa.setKomentar(v.getKomentar());
                varoa.setPrimjecena(v.getPrimjecena());
                return varoaRepository.save(v);
            });
        } catch(Exception e) {
            return "Update Varoa error: " + e.toString();   
        }
        return "Varoa successfully updated";
    }

    public String deleteVaroa(int id){
        try{
            varoaRepository.deleteById(id);
        } catch(Exception e) {
            return "Delete Varoa error: "  + e.toString();
        }
        return "Varoa successfully deleted";
    }
}