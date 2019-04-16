package com.example.demo.Services;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintViolationException;

import com.example.demo.Validation;
import com.example.demo.Entities.Aktivnost;
import com.example.demo.Repositories.AktivnostRepositroy;
import com.example.demo.Repositories.KosnicaRepository;
import com.fasterxml.jackson.databind.util.JSONPObject;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;
import org.json.JSONObject;

@Service
public class AktivnostService {

    @Autowired
    AktivnostRepositroy aktivnostrepository;

    @Autowired
    KosnicaRepository kosnicaRepository;

    @Autowired
    Validation val;

    public Iterable<Aktivnost> findAll() {
        return aktivnostrepository.findAll();
    }

    public Optional<Aktivnost> findById(int id) {
        Optional<Aktivnost> a = aktivnostrepository.findById(id);
        return a;
    }

    public String addAktivnost(Aktivnost a, int idk){
        try {
            val.PostojiKosnica(idk);
            kosnicaRepository.findById(idk).map(kosnica -> {
                kosnica.setAktivnosti(a);
                aktivnostrepository.save(a);
                return kosnicaRepository.save(kosnica);
            });
        }
        catch (TransactionSystemException  ex) {
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
        o1.put("poruka",  "Aktivnost spremljena");
        return o1.toString();
    }

    public String updateAktivnost(int id, Aktivnost a) {
        try {
            val.PostojiAktivnost(id);
            aktivnostrepository.findById(id).map(aktivnost -> {
                aktivnost.setMjesec(a.getMjesec());
                aktivnost.setUradjeno(a.getUradjeno());
                aktivnost.setAktivnost(a.getAktivnost());
                return aktivnostrepository.save(aktivnost);
            });
        }
        catch (TransactionSystemException  ex) {
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
            o1.put("poruka",  e.getMessage().toString());
            return o1.toString();
        }
        JSONObject o1 = new JSONObject();
        o1.put("poruka",  "Aktivnost uspješno ažurirana");
        return o1.toString();
    }

    public String deleteAktivnost(int id){
        try {
            val.PostojiAktivnost(id);
            aktivnostrepository.deleteById(id);
        } catch(Exception e) {
            JSONObject o = new JSONObject();
            o.put("poruka", e.toString());
            return o.toString();
        }
        JSONObject o = new JSONObject();
        o.put("poruka", "Aktivnost uspješno obrisana");
        return o.toString();
    }
    
    //daj aktivnosti od košnice
    public Iterable<Aktivnost>  getAktivnostiOdKosnica(int idk) throws Exception {
        try {
            val.PostojiKosnica(idk);
            return aktivnostrepository.dajAktinvostiOdKosnice(idk);
        } catch(Exception e) {
            throw new Exception("{\"poruka\":\"" + e.getMessage().toString() + "\"}");
        }
    }

}