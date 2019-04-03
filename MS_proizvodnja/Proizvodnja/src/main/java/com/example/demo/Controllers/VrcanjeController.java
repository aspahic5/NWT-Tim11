package com.example.demo.Controllers;

import java.util.Optional;

import com.example.demo.Entities.Vrcanje;
import com.example.demo.Repositories.VrcanjeRepository;
import com.example.demo.Services.VrcanjeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VrcanjeController {

    @Autowired
    VrcanjeService pS;

    @RequestMapping(value = "/DajSvaVrcanja", method = RequestMethod.GET)
    public Iterable<Vrcanje> GetAllVrcanja() {
        return pS.findAll();
    }

    @RequestMapping(value = "/DajVrcanje/{id}", method = RequestMethod.GET)
    public Optional<Vrcanje> getVrcanjeById(@PathVariable int id) {
        return pS.findById(id);
    }

    @RequestMapping(value="/DodajVrcanje/{id}", method=RequestMethod.POST)
    public String createVrcanje(@RequestBody Vrcanje p, @PathVariable int id) {
        return pS.addVrcanje(p, id);
    }

    @RequestMapping(value="/AzurirajVrcanje/{id}", method = RequestMethod.PUT)
    public String updateVrcanje(@RequestBody Vrcanje p, @PathVariable int id){
        return pS.updateVrcanje(p, id);
    }

    @RequestMapping(value="/ObrisiVrcanje/{id}", method=RequestMethod.DELETE)
    public String deleteVrcanje(@PathVariable int id) {
        return pS.deleteVrcanje(id);
    }
    
}