package com.example.demo.Controllers;

import java.util.Optional;

import com.example.demo.Entities.Varoa;
import com.example.demo.Services.VaroaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
public class VaroaController {

    @Autowired
    VaroaService varoaService;

    @RequestMapping(value = "/DajSveVaroe", method = RequestMethod.GET)
    public Iterable<Varoa> getAllVaroe() {
        return varoaService.findAll();
    }

    @RequestMapping(value = "/DajVarou/{id}", method = RequestMethod.GET)
    public Optional<Varoa> getVaroaById(@PathVariable int id) {
        return varoaService.findById(id);
    }

    @RequestMapping(value="/DodajVarou", method=RequestMethod.POST)
    public String addVaroa(@RequestBody Varoa v) {
        return varoaService.addVaroa(v);
    }
    @RequestMapping(value="/AzurirajVarou/{id}", method=RequestMethod.PUT)
    public String updateVaroa(@PathVariable int id, @RequestBody Varoa v) {
        return varoaService.updateVaroa(id, v);
    }
    
    @RequestMapping(value="/ObrisiVarou/{id}", method=RequestMethod.DELETE)
    public String deleteVaroa(@PathVariable int id) {
        return varoaService.deleteVaroa(id);
    }
    

    
}