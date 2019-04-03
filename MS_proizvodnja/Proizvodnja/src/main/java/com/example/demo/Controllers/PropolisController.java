package com.example.demo.Controllers;

import java.util.Optional;

import com.example.demo.Entities.Propolis;
import com.example.demo.Services.PropolisService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PropolisController {

    @Autowired
    PropolisService pS;

    @RequestMapping(value = "/DajSvePropolise", method = RequestMethod.GET)
    public Iterable<Propolis> GetAllPropolises() {
        return pS.findAll();
    }

    @RequestMapping(value = "/DajPropolis/{id}", method = RequestMethod.GET)
    public Optional<Propolis> getPropolisById(@PathVariable int id) {
        return pS.findById(id);
    }

    @RequestMapping(value="/DodajPropolis/{id}", method=RequestMethod.POST)
    public String createPropolis(@RequestBody Propolis p, @PathVariable int id) {
        return pS.addPropolis(p, id);
    }

    @RequestMapping(value="/AzurirajPropolis/{id}", method = RequestMethod.PUT)
    public String updatePropolis(@RequestBody Propolis p, @PathVariable int id){
        return pS.updatePropolis(p, id);
    }

    @RequestMapping(value="/ObrisiPropolis/{id}", method=RequestMethod.DELETE)
    public String deletePropolis(@PathVariable int id) {
        return pS.deletePropolis(id);
    }
    
}