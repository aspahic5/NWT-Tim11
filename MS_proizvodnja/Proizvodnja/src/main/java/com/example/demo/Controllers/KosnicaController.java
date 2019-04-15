package com.example.demo.Controllers;

import java.util.Optional;

import com.example.demo.Entities.Kosnica;
import com.example.demo.Services.KosnicaService;
import com.example.demo.config.MessageProducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KosnicaController {
	
	@Autowired
	MessageProducer messageProducer;
	
	@RequestMapping(value="/poruka",method=RequestMethod.POST)
    public String poruka(@RequestPart("message") String poruka) {
    	 messageProducer.sendMessage(poruka);
    	return "Poslana poruka = "+poruka;
    }
	
    /*
    @Autowired
    KosnicaService kS;

    @RequestMapping(value = "/DajSveKosniceC", method = RequestMethod.GET)
    public Iterable<Kosnica> GetAllKosnice() {
        return kS.findAll();
    }

    @RequestMapping(value = "/DajKosnicuC/{id}", method = RequestMethod.GET)
    public Optional<Kosnica> getKosnicaById(@PathVariable int id) {
        return kS.findById(id);
    }

    @RequestMapping(value="/DodajKosnicuC/{id}", method=RequestMethod.POST)
    public String createKosnica(@RequestBody Kosnica k) {
        return kS.addKosnica(k);
    }

    @RequestMapping(value="/AzurirajKosnicuC/{id}", method = RequestMethod.PUT)
    public String updateKosnica(@RequestBody Kosnica k, @PathVariable int id){
        return kS.updateKosnica(id, k);
    }

    @RequestMapping(value="/ObrisiKosnicuC/{id}", method=RequestMethod.DELETE)
    public String deleteKosnica(@PathVariable int id) {
        return kS.deleteKosnica(id);
    }
    */
    
}