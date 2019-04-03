package com.example.demo.Services;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.demo.Entities.Aktivnost;
import com.example.demo.Entities.Kosnica;
import com.example.demo.Entities.Selidba;
import com.example.demo.Repositories.KosnicaRepository;
import com.example.demo.Repositories.SelidbaRepository;
import com.example.demo.Repositories.AktivnostRepositroy;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

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
        } catch (TransactionSystemException  ex) {
            Throwable e = ex.getRootCause();
            String poruka = e.getMessage();
            Pattern pattern = Pattern.compile("'(.*?)'");
            Matcher matcher = pattern.matcher(poruka);
            JSONObject o = new JSONObject();
            o.put("poruka", e.getMessage());
            if(matcher.find()) {
                String temp = matcher.group(1);
                JSONObject o1 = new JSONObject();
                o1.put("poruka", temp);
                return o1.toString();
            }
            return o.toString();
        } 
        catch (Exception e) {
            JSONObject o1 = new JSONObject();
            o1.put("poruka",  e.getMessage());
            return o1.toString();
        }
        JSONObject o1 = new JSONObject();
        o1.put("poruka",  "Košnica spremljena");
        return o1.toString();
    }

    public String addSelidbaToKosnica(int ids, int id){
        Optional<Selidba> selidba = selidbaRepository.findById(ids);
        if(!selidba.isPresent()) {
            JSONObject o1 = new JSONObject();
            o1.put("poruka",  "Selidba ne postoji");
            return o1.toString();
        }
        if(!kosnicarepository.findById(id).isPresent()) {
            JSONObject o1 = new JSONObject();
            o1.put("poruka",  "Košnica ne postoji");
            return o1.toString();
        }
        Selidba s = selidba.get();
        try {
            kosnicarepository.findById(id).map(kosnica -> {
                kosnica.setSelidba(s);
                return kosnicarepository.save(kosnica);
            });
        } catch(Exception e) {
            JSONObject o1 = new JSONObject();
            o1.put("poruka",  e.toString());
            return o1.toString();
        }
        JSONObject o1 = new JSONObject();
        o1.put("poruka",  "Selidba dodana na košnicu");
        return o1.toString();
    }

    public String addAktivnostToKosnica(int ida, int id){
        Optional<Aktivnost> a = aktivnostRepositroy.findById(ida);
        if(!a.isPresent()) {
            JSONObject o1 = new JSONObject();
            o1.put("poruka",  "Aktivnost ne postoji");
            return o1.toString();
        }
        if(!kosnicarepository.findById(id).isPresent()) {
            JSONObject o1 = new JSONObject();
            o1.put("poruka",  "Košnica ne postoji");
            return o1.toString();
        }
        Aktivnost akt = a.get();
        try {
            kosnicarepository.findById(id).map(kosnica -> {
                kosnica.setAktivnosti(akt);
                return kosnicarepository.save(kosnica);
            });
        } catch(Exception e) {
            JSONObject o1 = new JSONObject();
            o1.put("poruka",  e.toString());
            return o1.toString();
        }
        JSONObject o1 = new JSONObject();
            o1.put("poruka",  "Aktivnost dodana na košnicu");
            return o1.toString();
    }
    
    public String addKosnicaToKosnica(int idk, int id) {
        Optional<Kosnica> k = kosnicarepository.findById(idk);
        if(!k.isPresent()) {
            JSONObject o1 = new JSONObject();
            o1.put("poruka",  "Košnica ne postoji");
            return o1.toString();
        }
        if(!kosnicarepository.findById(id).isPresent()) {
            JSONObject o1 = new JSONObject();
            o1.put("poruka",  "Košnica ne postoji");
            return o1.toString();
        } 
        Kosnica kosnica1 = k.get();
        try {
            kosnicarepository.findById(id).map(kosnica -> {
                kosnica.setKosnice(kosnica1);
                return kosnicarepository.save(kosnica1);
            });
        } catch(Exception e) {
            JSONObject o1 = new JSONObject();
            o1.put("poruka",  e.toString());
            return o1.toString();
        }

        JSONObject o1 = new JSONObject();
        o1.put("poruka",  "Košnica je dodana na košnicu");
        return o1.toString();
    }

    public String updateKosnica(int id, Kosnica k){
        if(!kosnicarepository.findById(id).isPresent()) {
            JSONObject o1 = new JSONObject();
            o1.put("poruka",  "Košnica ne postoji");
            return o1.toString();
        }
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
        } catch (TransactionSystemException  ex) {
            Throwable e = ex.getRootCause();
            String poruka = e.getMessage();
            Pattern pattern = Pattern.compile("'(.*?)'");
            Matcher matcher = pattern.matcher(poruka);
            JSONObject o = new JSONObject();
            o.put("poruka", e.getMessage());
            if(matcher.find()) {
                String temp = matcher.group(1);
                JSONObject o1 = new JSONObject();
                o1.put("poruka", temp);
                return o1.toString();
            }
            return o.toString();
        } 
        catch(Exception e) {
            JSONObject o1 = new JSONObject();
            o1.put("poruka",  e.toString());
            return o1.toString();
        }
        JSONObject o1 = new JSONObject();
        o1.put("poruka",  "Košnica uspješno ažurirana");
        return o1.toString();
    }

    public String deleteKosnica(int id){
        if(!kosnicarepository.findById(id).isPresent()) {
            JSONObject o1 = new JSONObject();
            o1.put("poruka",  "Košnica ne postoji");
            return o1.toString();
        }
        try{
            kosnicarepository.deleteById(id);
        } catch (Exception e) {
            JSONObject o1 = new JSONObject();
            o1.put("poruka",  e.toString());
            return o1.toString();
        }
        JSONObject o1 = new JSONObject();
        o1.put("poruka",  "Košnica uspješno obrisana");
        return o1.toString();
    }
}