package com.example.demo.Controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entities.Biljka;
import com.example.demo.Entities.Lokacija;
import com.example.demo.Services.BiljkaService;
import com.example.demo.Services.LokacijaService;

@RestController
public class BiljkaController {
	
	@Autowired
	private BiljkaService biljkaService;
	
	@Autowired
	private LokacijaService lokacijaService;
	
	@RequestMapping("/getAllBiljke")
	public Iterable<Biljka> getBiljke(){
		return biljkaService.findAll();
	}
	
	@RequestMapping("/getBiljkaByID/{id}")
	public Optional<Biljka> getBiljkaID(@PathVariable int id){
		return biljkaService.findById(id);
	}
	
	@RequestMapping(value="/deleteBiljka/{id}", method= RequestMethod.DELETE )
	public String deleteBiljka(@PathVariable int id) {
		Optional<Biljka> b=biljkaService.findById(id);
		if(!b.isPresent())return "Ne postoji biljka sa datim id identifikatorom";
		return biljkaService.deleteBiljka(id);
	}
	
	@RequestMapping(value="/addBiljka", method= RequestMethod.PUT )
	public String addBiljka(@RequestBody Biljka b) {
		Iterable<Lokacija> Lokacije= b.getLokacije();
		for (Lokacija l : Lokacije) {
			int id =l.getId();
			Optional<Lokacija> ln=lokacijaService.findById(id);
			if(!ln.isPresent() || !l.equals(ln) )return "ne postoje unesene lokacije";
		}
		Biljka newb= new Biljka(b.getBiljka(),b.getPoc_mjesec(),b.getKraj_mjesec(),b.getLokacije());
		
		return biljkaService.addBiljka(newb);
	}
	
	@RequestMapping(value="/updateBiljka", method= RequestMethod.POST )
	public String updateBiljka(@RequestBody Biljka b) {
		Iterable<Lokacija> Lokacije= b.getLokacije();
		for (Lokacija l : Lokacije) {
			int id =l.getId();
			Optional<Lokacija> ln=lokacijaService.findById(id);
			if(!ln.isPresent() || !l.getLokcaija().equals(ln.get().getLokcaija()) )return "ne postoje unesene lokacije";
		}
		return biljkaService.updateBiljka(b);
	}
	
	
	

}
