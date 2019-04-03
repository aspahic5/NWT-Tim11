package com.example.demo.Controllers;

import java.util.Optional;

import com.example.demo.Entities.Rojenje;
import com.example.demo.Services.RojenjeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RojenjeController {

    @Autowired
    RojenjeService rojenjeService;

    @RequestMapping(value = "/DajSvaRojenja", method = RequestMethod.GET)
    public Iterable<Rojenje> getAllRojenje() {
        return rojenjeService.findAll();
    }

    @RequestMapping(value = "/Rojenje/{id}", method = RequestMethod.GET)
    public Optional<Rojenje> getRojenjeById(@PathVariable int id) {
        return rojenjeService.findById(id);
    }

    @RequestMapping(value="/Rojenje/{idk}", method=RequestMethod.POST)
    public String createRojenje(@RequestBody Rojenje r, @PathVariable int idk) {
        return rojenjeService.addRojenje(r, idk);
    }

    @RequestMapping(value = "/Rojenje/{id}", method=RequestMethod.PUT)
    public String updateRojenje(@PathVariable int id, @RequestBody Rojenje r) {
        return rojenjeService.updateRojenje(id, r);
    }
    
    @RequestMapping(value = "/Rojenje/{id}", method=RequestMethod.DELETE)
    public String updateRojenje(@PathVariable int id) {
        return rojenjeService.deleteRojenje(id);
    }

}