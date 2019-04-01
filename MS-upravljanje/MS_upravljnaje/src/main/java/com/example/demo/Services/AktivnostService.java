package com.example.demo.Services;

import java.util.Optional;

import com.example.demo.Entities.Aktivnost;
import com.example.demo.Repositories.AktivnostRepositroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        } catch (Exception e) {
            return e.toString();
        }
        return "Aktivnost saved";
    }

    public String updateAktivnost(int id, Aktivnost a){
        try {
            aktivnostrepository.findById(id).map(aktivnost -> {
                aktivnost.setMjesec(a.getMjesec());
                aktivnost.setUradjeno(a.getUradjeno());
                aktivnost.setAktivnost(a.getAktivnost());
                return aktivnostrepository.save(aktivnost);
            });
        } catch(Exception e) {
            return "Update Aktinvost error: " + e.toString();
        }
        return "Aktivnost successfully updated";
    }

    public String deleteAktivnost(int id){
        try {
            aktivnostrepository.deleteById(id);
        } catch(Exception e) {
            return "delete Aktivnost error: " + e.toString();
        }
        return "Aktivnost successfully deleted";
    }
}