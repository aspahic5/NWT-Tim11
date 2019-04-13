package com.example.demo.Services;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.demo.Entities.Rojenje;
import com.example.demo.Repositories.KosnicaRepository;
import com.example.demo.Repositories.RojenjeRepository;

import org.json.JSONObject;
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
        if(!kosnicaRepository.findById(idk).isPresent()) {
            JSONObject o1 = new JSONObject();
            o1.put("poruka",  "Košnica ne postoji");
            return o1.toString();
        }
        try {
            kosnicaRepository.findById(idk).map(kosnica -> {
                r.setKosnice(kosnica);
                return rojenjeRepository.save(r);
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
        } catch (Exception e) {
            JSONObject o1 = new JSONObject();
            o1.put("poruka",  e.toString());
            return o1.toString();
        }
        JSONObject o1 = new JSONObject();
        o1.put("poruka", "Rojenje spremljeno");
        return o1.toString();
    }

    public String updateRojenje(int id, Rojenje r){
        if(!rojenjeRepository.findById(id).isPresent()) {
            JSONObject o1 = new JSONObject();
            o1.put("poruka",  "Rojenje ne postoji");
            return o1.toString();
        }
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
        } catch (Exception e) {
            JSONObject o1 = new JSONObject();
            o1.put("poruka",  e.toString());
            return o1.toString();
        }
        JSONObject o1 = new JSONObject();
        o1.put("poruka",  "Rojenje uspješno ažurirano");
        return o1.toString();
    }

    public String deleteRojenje(int id){
        if(!rojenjeRepository.findById(id).isPresent()) {
            JSONObject o1 = new JSONObject();
            o1.put("poruka",  "Rojenje ne postoji");
            return o1.toString();
        }
        try{
            rojenjeRepository.deleteById(id);;
        }
        catch(Exception e){
            JSONObject o1 = new JSONObject();
            o1.put("poruka",  e.toString());
            return o1.toString();
        }
        JSONObject o1 = new JSONObject();
        o1.put("poruka",  "Rojenje uspješno obrisano");
        return o1.toString();
    }

    //Daj Rojenja od Košnice
    public Iterable<Rojenje> getRojenjaOdKosnice(int idk) throws Exception{
        if(!kosnicaRepository.findById(idk).isPresent()) {
            throw new Exception("{\"poruka\":\"Kosnica ne postoji\"}");
        }
        try {
            return rojenjeRepository.dajRojenjaOdKosnice(idk);
        } catch (Exception e) {
            throw new Exception("{\"poruka\":\"" + e.toString() + "\"}");
        }
    }
}