package com.example.demo.Controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.json.JSONObject;
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
	
	@RequestMapping("/Biljka")
	public Iterable<Biljka> getBiljke(){
		return biljkaService.findAll();
	}
	
	@RequestMapping("/BiljkaLokacija/{lokacija}")
	public ArrayList<Biljka> getBiljkaLokacija(@PathVariable String lokacija){
		return biljkaService.biljkaLokacija(lokacija);
	}
	
	@RequestMapping("/Biljka/{id}")
	public Optional<Biljka> getBiljkaID(@PathVariable int id){
		return biljkaService.findById(id);
	}
	
	@RequestMapping(value="/Biljka/{id}", method= RequestMethod.DELETE )
	public String deleteBiljka(@PathVariable int id) {
		Optional<Biljka> b=biljkaService.findById(id);
		if(!b.isPresent())return new JSONObject().put("message","Ne postoji biljka sa datim id identifikatorom").toString();
		return biljkaService.deleteBiljka(id);
	}
	
	@RequestMapping(value="/Biljka", method= RequestMethod.PUT )
	public String addBiljka(@RequestBody Biljka b) {
		Iterable<Lokacija> Lokacije= b.getLokacije();
		for (Lokacija l : Lokacije) {
			System.out.println(l.getId()+" "+l.getLokcaija());
			int id =l.getId();
			Optional<Lokacija> ln=lokacijaService.findById(id);
			if(!ln.isPresent())return new JSONObject().put("message","ne postoje unesene lokacije").toString();
		}
		
		Biljka newb= new Biljka(b.getBiljka(),b.getPoc_mjesec(),b.getKraj_mjesec(),b.getLokacije());
		
		return biljkaService.addBiljka(newb);
	}
	
	@RequestMapping(value="/Biljka", method= RequestMethod.POST )
	public String updateBiljka(@RequestBody Biljka b) {
		Iterable<Lokacija> Lokacije= b.getLokacije();
		for (Lokacija l : Lokacije) {
			int id =l.getId();
			Optional<Lokacija> ln=lokacijaService.findById(id);
			if(!ln.isPresent() || !l.getLokcaija().equals(ln.get().getLokcaija()) )return new JSONObject().put("message","ne postoje unesene lokacije").toString();
		}
		return biljkaService.updateBiljka(b);
	}
	
	
	

}
