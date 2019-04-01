package com.example.demo.Services;

import java.util.Optional;

import com.example.demo.Entities.Aktivnost;
import com.example.demo.Entities.Kosnica;
import com.example.demo.Entities.Selidba;
import com.example.demo.Repositories.KosnicaRepository;
import com.example.demo.Repositories.SelidbaRepository;
import com.example.demo.Repositories.AktivnostRepositroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KosnicaService {

    @Autowired
    KosnicaRepository kosnicarepository;

    @Autowired
    SelidbaRepository selidbaRepository;

    @Autowired
    AktivnostRepositroy aktivnostRepositroy;

    public Iterable<Kosnica> findAll() {
        return kosnicarepository.findAll();
    }

    public Optional<Kosnica> findById(int id) {
        return kosnicarepository.findById(id);
    }

    public String addKosnica(Kosnica k) {
        try {
            kosnicarepository.save(k);
        } catch (Exception e) {
            return e.toString();
        }
        return "Kosnica saved";
    }

    public String addSelidbaToKosnica(int ids, int id){
        Optional<Selidba> selidba = selidbaRepository.findById(ids);
        Selidba s = selidba.get();
        try {
            kosnicarepository.findById(id).map(kosnica -> {
                kosnica.setSelidba(s);
                return kosnicarepository.save(kosnica);
            });
        } catch(Exception e) {
            return "Add Selidba to Kosnica error: " + e.toString();
        }
        return "Selidba added to Košnica";
    }

    public String addAktivnostToKosnica(int ida, int id){
        Optional<Aktivnost> a = aktivnostRepositroy.findById(ida);
        Aktivnost akt = a.get();
        try {
            kosnicarepository.findById(id).map(kosnica -> {
                kosnica.setAktivnosti(akt);
                return kosnicarepository.save(kosnica);
            });
        } catch(Exception e) {
            return "Add Aktivnost to Kosnica error: " + e.toString();
        }
        return "Aktivnost added to Košnica";
    }
    
    public String addKosnicaToKosnica(int idk, int id) {
        Optional<Kosnica> k = kosnicarepository.findById(idk);
        Kosnica kosnica1 = k.get();
        try {
            kosnicarepository.findById(id).map(kosnica -> {
                kosnica.setKosnice(kosnica1);
                return kosnicarepository.save(kosnica1);
            });
        } catch(Exception e) {
            return "Add Kosnica to Kosnica error: " + e.toString();
        }
        return "Košnica added to Košnica";
    }

    public String updateKosnica(int id, Kosnica k){
        try {
            kosnicarepository.findById(id).map(kosnica -> {
                kosnica.setBrojhanemanki(k.getBrojhanemanki());
                kosnica.setBrojnastavaka(k.getBrojnastavaka());
                kosnica.setBrojramova(k.getBrojnastavaka());
                kosnica.setBrojramova(k.getBrojramova());
                kosnica.setKolstimulansa(k.getKolstimulansa());
                kosnica.setKomentar(k.getKomentar());
                kosnica.setMaticagod(k.getMaticagod());
                kosnica.setTipstimulansa(k.getTipstimulansa());
                return kosnicarepository.save(kosnica);
            });
        } catch(Exception e) {
            return "Update Kosnica error: " + e.toString();
        }
        return "Kosnica successfully updated";
    }

    public String deleteKosnica(int id){
        try{
            kosnicarepository.deleteById(id);
        } catch (Exception e) {
            return "Delete Kosnica error: " + e.toString();
        }
        return "Kosnica successfully deleted";
    }
}