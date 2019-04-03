package com.example.demo.Controllers;

import java.util.Optional;

import com.example.demo.Entities.Rashodi;
import com.example.demo.Services.RashodiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


public class RashodController {
    @Autowired
    RashodiService pS;

    @RequestMapping(value = "/DajSveRashode", method = RequestMethod.GET)
    public Iterable<Rashodi> GetAllRashods() {
        return pS.findAll();
    }

    @RequestMapping(value = "/DajRashod/{id}", method = RequestMethod.GET)
    public Optional<Rashodi> getPRashodById(@PathVariable int id) {
        return pS.findById(id);
    }

    @RequestMapping(value="/DodajRashod/{id}", method=RequestMethod.POST)
    public String createRashod(@RequestBody Rashodi p, @PathVariable int id) {
        return pS.addRashod(p, id);
    }

    @RequestMapping(value="/AzurirajRashod/{id}", method = RequestMethod.PUT)
    public String updateRashod(@RequestBody Rashodi p, @PathVariable int id){
        return pS.updateRashod(p, id);
    }

    @RequestMapping(value="/ObrisiRashod/{id}", method=RequestMethod.DELETE)
    public String deleteRashod(@PathVariable int id) {
        return pS.deleteRashod(id);
    }
}