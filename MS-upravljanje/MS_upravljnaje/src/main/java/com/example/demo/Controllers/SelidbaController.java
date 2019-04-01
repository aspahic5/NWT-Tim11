package com.example.demo.Controllers;

import java.util.Optional;

import com.example.demo.Entities.Selidba;
import com.example.demo.Services.SelidbaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class SelidbaController {

    @Autowired
    SelidbaService selidbaServis;

    @RequestMapping(value = "/DajSveSelidbe", method = RequestMethod.GET)
    public Iterable<Selidba> getAllSelidbe() {
        return selidbaServis.findAll();
    }

    @RequestMapping(value = "/DajSelidbu/{id}", method = RequestMethod.GET)
    public Optional<Selidba> getSelidbaById(@PathVariable int id) {
        return selidbaServis.findById(id);
    }

    @RequestMapping(value = "/DodajSelidbu", method = RequestMethod.POST)
    public String createSelidba(@RequestBody Selidba s){
        return selidbaServis.addSelidba(s);
    }

    @RequestMapping(value="/AzurirajSelidbu/{id}", method=RequestMethod.PUT)
    public String updateSelidba(@PathVariable int id, @RequestBody Selidba s) {
        return selidbaServis.updateSelidba(id, s);
    }
    
    @RequestMapping(value="/ObrisiSelidbu/{id}", method=RequestMethod.DELETE)
    public String deleteSelidba(@PathVariable int id) {
        return selidbaServis.delteSelidba(id);
    }
    



}