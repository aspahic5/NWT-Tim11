package com.example.demo.Services;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.demo.Validation;
import com.example.demo.Entities.Selidba;
import com.example.demo.Repositories.KosnicaRepository;
import com.example.demo.Repositories.SelidbaRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

@Service
public class SelidbaService {

    @Autowired
    SelidbaRepository selidbaRepository;

    @Autowired
    KosnicaRepository kosnicaRepository;

    @Autowired
    Validation v;

    public Iterable<Selidba> findAll() {
        return selidbaRepository.findAll();
    }

    public Optional<Selidba> findById(int id) {
        return selidbaRepository.findById(id);
    }

    public String addSelidba(Selidba s, int idk) {
        try {
            v.PostojiKosnica(idk);
            kosnicaRepository.findById(idk).map(kosnica -> {
            kosnica.setSelidba(s);
            selidbaRepository.save(s);
            return kosnicaRepository.save(kosnica);
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
            o1.put("poruka", e.getMessage().toString());
            return o1.toString();
        }
        JSONObject o1 = new JSONObject();
        o1.put("poruka", "Selidba spremljena");
        return o1.toString();
    }

    public String updateSelidba(int id, Selidba s){
        try{
            v.PostojiSelidba(id);
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
            o1.put("poruka", e.getMessage().toString());
            return o1.toString();
        }
        JSONObject o1 = new JSONObject();
        o1.put("poruka",  "Selidba uspješno ažurirana");
        return o1.toString();
    }

    public String delteSelidba(int id){
        try{
            v.PostojiSelidba(id);
            selidbaRepository.deleteById(id);
        } catch(Exception e){
            JSONObject o1 = new JSONObject();
            o1.put("poruka",   e.getMessage().toString());
            return o1.toString();
        }
        JSONObject o1 = new JSONObject();
        o1.put("poruka",  "Selidba uspješno obrisana");
        return o1.toString();
    }

    //Daj selidbe od kosnice
    public Iterable<Selidba> getSelidbeOdKosnica(int idk) throws Exception {
        try {
            v.PostojiKosnica(idk);
            return selidbaRepository.dajSelidbeOdKosnice(idk);
        } catch (Exception e) {
            throw new Exception("{\"poruka\":\"" +  e.getMessage().toString() + "\"}");
        }
    }
    //Postavi dobit za selidbu
    public String updateDobitOdSelidba(int ids, double dobit) throws Exception {
        try {
            v.PostojiSelidba(ids);
            selidbaRepository.azurirajDobitOdSelidbe(dobit, ids);
        } catch(Exception e) {
            throw new Exception("{\"poruka\":\"" + e.getMessage().toString() + "\"}");
        }
        return "{\"poruka\":\"Dobit selidbe " + ids + " uspješno ažurirana\"}";
    }
}