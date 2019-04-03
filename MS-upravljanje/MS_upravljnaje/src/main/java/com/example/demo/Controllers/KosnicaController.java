package com.example.demo.Controllers;

import java.util.Optional;

import com.example.demo.Entities.Kosnica;
import com.example.demo.Services.KosnicaService;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class KosnicaController {

    @Autowired
    KosnicaService kosnicaService;

    @RequestMapping(value = "/DajSveKosnice", method = RequestMethod.GET)
    public Iterable<Kosnica> GetAllKosnice() {
        return kosnicaService.findAll();
    }

    @RequestMapping(value = "/Kosnica/{id}", method = RequestMethod.GET)
    public Optional<Kosnica> getKosnicaById(@PathVariable int id) {
        return kosnicaService.findById(id);
    }

    @RequestMapping(value="/Kosnica", method=RequestMethod.POST)
    public String createKosnica(@RequestBody Kosnica k) {
        return kosnicaService.addKosnica(k);
    }

    @RequestMapping(value="/SelidbaNaKosnicu/{id}/{ids}", method=RequestMethod.PUT)
    public String addSelidbaToKosnica(@PathVariable int ids, @PathVariable int id) {
        return kosnicaService.addSelidbaToKosnica(ids, id);
        
    }

    @RequestMapping(value="/AktivnostNaKosnicu/{id}/{ida}", method=RequestMethod.PUT)
    public String addAktivnostToKosnica(@PathVariable int ida, @PathVariable int id) {
        return kosnicaService.addAktivnostToKosnica(ida, id);
    }

    @RequestMapping(value="/KosnicaNaKosnicu/{id}/{idk}", method=RequestMethod.PUT)
    public String addKosnicaToKosnica(@PathVariable int idk, @PathVariable int id) {
        return kosnicaService.addKosnicaToKosnica(idk, id);
    }
    
    @RequestMapping(value="/Kosnica/{id}", method = RequestMethod.PUT)
    public String updateKosnica(@RequestBody Kosnica k, @PathVariable int id){
        return kosnicaService.updateKosnica(id, k);
    }

    @RequestMapping(value="/Kosnica/{id}", method=RequestMethod.DELETE)
    public String deleteKosnica(@PathVariable int id) {
        return kosnicaService.deleteKosnica(id);
    }
    
}