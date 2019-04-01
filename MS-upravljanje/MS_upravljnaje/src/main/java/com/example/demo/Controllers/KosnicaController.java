package com.example.demo.Controllers;

import java.util.Optional;

import com.example.demo.Entities.Kosnica;
import com.example.demo.Services.KosnicaService;

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

    @RequestMapping(value = "/DajKosnicu/{id}", method = RequestMethod.GET)
    public Optional<Kosnica> getKosnicaById(@PathVariable int id) {
        return kosnicaService.findById(id);
    }

    @RequestMapping(value="/DodajKosnicu", method=RequestMethod.POST)
    public String createKosnica(@RequestBody Kosnica k) {
        return kosnicaService.addKosnica(k);
    }

    @RequestMapping(value="/DodajSelidbuNaKosnicu/{id}/{ids}", method=RequestMethod.PUT)
    public String addSelidbaToKosnica(@PathVariable int ids, @PathVariable int id) {
        return kosnicaService.addSelidbaToKosnica(ids, id);
        
    }

    @RequestMapping(value="/DodajAktivnostNaKosnicu/{id}/{ida}", method=RequestMethod.PUT)
    public String addAktivnostToKosnica(@PathVariable int ida, @PathVariable int id) {
        return kosnicaService.addAktivnostToKosnica(ida, id);
    }

    @RequestMapping(value="/DodajKosnicuNaKosnicu/{id}/{idk}", method=RequestMethod.PUT)
    public String addKosnicaToKosnica(@PathVariable int idk, @PathVariable int id) {
        return kosnicaService.addKosnicaToKosnica(idk, id);
    }
    
    @RequestMapping(value="/AzurirajKosnicu/{id}", method = RequestMethod.PUT)
    public String updateKosnica(@RequestBody Kosnica k, @PathVariable int id){
        return kosnicaService.updateKosnica(id, k);
    }
    
    /*@RequestMapping(value="/ObsisiSelidbeOdKosnice/{id}/{ids}", method = RequestMethod.PUT)
    public String deleteSelidbeFromKosnice(@RequestParam int ids, @RequestParam int id){
        return "";
    }

    @RequestMapping(value="/ObsisiAktivnostiOdKosnice/{id}/{idk}", method = RequestMethod.PUT)
    public String deleteAktivnostiFromKosnice(@RequestParam int idk, @RequestParam int id){
        return "";
    }*/ //MOŽDA NE TREBA

    @RequestMapping(value="/ObrisiKosnicu/{id}", method=RequestMethod.DELETE)
    public String deleteKosnica(@PathVariable int id) {
        return kosnicaService.deleteKosnica(id);
    }
    
}