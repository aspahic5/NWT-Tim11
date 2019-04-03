package com.example.demo.Services;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.demo.Entities.Varoa;
import com.example.demo.Repositories.KosnicaRepository;
import com.example.demo.Repositories.VaroaRepository;

import org.json.JSONObject;
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
        if(!kosnicaRepository.findById(idk).isPresent()) {
            JSONObject o1 = new JSONObject();
            o1.put("poruka",  "Košnica ne postoji");
            return o1.toString();
        }
        try {
            kosnicaRepository.findById(idk).map(kosnica -> {
                v.setKosnice(kosnica);
                return varoaRepository.save(v);
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
        o1.put("poruka",  "Varoa spremljena");
        return o1.toString();
    }

    public String updateVaroa(int id, Varoa v) {
        if(!varoaRepository.findById(id).isPresent()) {
            JSONObject o1 = new JSONObject();
            o1.put("poruka",  "Varoa ne postoji");
            return o1.toString();
        }
        try {
            varoaRepository.findById(id).map(varoa -> {
                varoa.setBroj(v.getBroj());
                varoa.setKomentar(v.getKomentar());
                varoa.setPrimjecena(v.getPrimjecena());
                return varoaRepository.save(varoa);
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
        o1.put("poruka",  "Varoa uspješno ažurirana");
        return o1.toString();
    }

    public String deleteVaroa(int id){
        if(!varoaRepository.findById(id).isPresent()) {
            JSONObject o1 = new JSONObject();
            o1.put("poruka",  "Varoa ne postoji");
            return o1.toString();
        }
        try{
            varoaRepository.deleteById(id);
        } catch(Exception e) {
            JSONObject o1 = new JSONObject();
            o1.put("poruka",  e.toString());
            return o1.toString();
        }
        JSONObject o1 = new JSONObject();
        o1.put("poruka",  "Varoa uspješno obrisana");
        return o1.toString();
    }
}