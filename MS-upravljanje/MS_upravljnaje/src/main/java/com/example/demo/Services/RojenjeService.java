package com.example.demo.Services;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.demo.Validation;
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

    @Autowired
    Validation val;

    public Iterable<Rojenje> findAll() {
        return rojenjeRepository.findAll();
    }

    public Optional<Rojenje> findById(int id) {
        return rojenjeRepository.findById(id);
    }

    public String addRojenje(Rojenje r, int idk) {
        try {
            val.PostojiKosnica(idk);
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
            o1.put("poruka",  e.getMessage().toString());
            return o1.toString();
        }
        JSONObject o1 = new JSONObject();
        o1.put("poruka", "Rojenje spremljeno");
        return o1.toString();
    }

    public String updateRojenje(int id, Rojenje r){
        try {
            val.PostojiRojenje(id);
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
            o1.put("poruka",  e.getMessage().toString());
            return o1.toString();
        }
        JSONObject o1 = new JSONObject();
        o1.put("poruka",  "Rojenje uspješno ažurirano");
        return o1.toString();
    }

    public String deleteRojenje(int id){
        try{
            val.PostojiRojenje(id);
            rojenjeRepository.deleteById(id);;
        }
        catch(Exception e){
            JSONObject o1 = new JSONObject();
            o1.put("poruka",  e.getMessage().toString());
            return o1.toString();
        }
        JSONObject o1 = new JSONObject();
        o1.put("poruka",  "Rojenje uspješno obrisano");
        return o1.toString();
    }

    //Daj Rojenja od Košnice
    public Iterable<Rojenje> getRojenjaOdKosnice(int idk) throws Exception{
        try {
            val.PostojiKosnica(idk);
            return rojenjeRepository.dajRojenjaOdKosnice(idk);
        } catch (Exception e) {
            throw new Exception("{\"poruka\":\"" + e.getMessage().toString() + "\"}");
        }
    }
}