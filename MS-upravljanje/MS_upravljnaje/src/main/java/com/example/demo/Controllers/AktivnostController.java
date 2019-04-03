package com.example.demo.Controllers;

import java.util.Optional;

import com.example.demo.Entities.Aktivnost;
import com.example.demo.Services.AktivnostService;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AktivnostController {

    @Autowired
    AktivnostService aktivnostService;

    @RequestMapping(value = "/DajSveAktivnosti", method = RequestMethod.GET)
    public Iterable<Aktivnost> getAllAktivnosti() {
        return aktivnostService.findAll();
    }

    @RequestMapping(value = "/Aktivnost/{id}", method = RequestMethod.GET)
    public Optional<Aktivnost> getAktivnostById(@PathVariable int id) {
        return aktivnostService.findById(id);
    }

    @RequestMapping(value="/Aktivnost/{idk}", method=RequestMethod.POST)
    public String createAktivnost(@RequestBody Aktivnost a, @PathVariable int idk) {
        return aktivnostService.addAktivnost(a, idk);
    }

    @RequestMapping(value="/Aktivnost/{id}", method=RequestMethod.PUT)
    public String updateAktivnost(@PathVariable int id, @RequestBody Aktivnost a) {
        return aktivnostService.updateAktivnost(id, a);
    }

    @RequestMapping(value="/Aktivnost/{id}", method=RequestMethod.DELETE)
    public String deleteAktivnost(@PathVariable int id) {
        return aktivnostService.deleteAktivnost(id);
    }
    

}