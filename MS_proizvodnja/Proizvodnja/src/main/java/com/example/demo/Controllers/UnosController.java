package com.example.demo.Controllers;

import java.util.Optional;

import com.example.demo.Entities.Unos;
import com.example.demo.Services.UnosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UnosController {
    
    @Autowired
    UnosService pS;

    @RequestMapping(value = "/DajSveUnose", method = RequestMethod.GET)
    public Iterable<Unos> GetAllUnose() {
        return pS.findAll();
    }

    @RequestMapping(value = "/DajUnos/{id}", method = RequestMethod.GET)
    public Optional<Unos> getUnosById(@PathVariable int id) {
        return pS.findById(id);
    }

    @RequestMapping(value="/DodajUnos/{id}", method=RequestMethod.POST)
    public String createUnos(@RequestBody Unos p, @PathVariable int id) {
        return pS.addUnos(p, id);
    }

    @RequestMapping(value="/AzurirajUnos/{id}", method = RequestMethod.PUT)
    public String updateUnos(@RequestBody Unos p, @PathVariable int id){
        return pS.updateUnos(p, id);
    }

    @RequestMapping(value="/ObrisiUnos/{id}", method=RequestMethod.DELETE)
    public String deleteUnos(@PathVariable int id) {
        return pS.deleteUnos(id);
    }

}