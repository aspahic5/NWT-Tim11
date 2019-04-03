package com.example.demo.Controllers;

import java.util.Optional;

import com.example.demo.Entities.Maticna_mlijec;
import com.example.demo.Entities.Propolis;
import com.example.demo.Services.MaticnaMlijecService;
import com.example.demo.Services.PropolisService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Maticna_mlijecController {

    @Autowired
    MaticnaMlijecService pS;

    @RequestMapping(value = "/DajSveMaticne", method = RequestMethod.GET)
    public Iterable<Maticna_mlijec> GetAllMaticne() {
        return pS.findAll();
    }

    @RequestMapping(value = "/DajMaticnu/{id}", method = RequestMethod.GET)
    public Optional<Maticna_mlijec> getMaticnaById(@PathVariable int id) {
        return pS.findById(id);
    }

    @RequestMapping(value="/DodajMaticnu/{id}", method=RequestMethod.POST)
    public String createMaticna(@RequestBody Maticna_mlijec p, @PathVariable int id) {
        return pS.addMaticna(p, id);
    }

    @RequestMapping(value="/AzurirajMaticnu/{id}", method = RequestMethod.PUT)
    public String updateMaticna(@RequestBody Maticna_mlijec p, @PathVariable int id){
        return pS.updateMaticna(p, id);
    }

    @RequestMapping(value="/ObrisiMaticnu/{id}", method=RequestMethod.DELETE)
    public String deleteMaticna(@PathVariable int id) {
        return pS.deleteMaticna(id);
    }
    
}