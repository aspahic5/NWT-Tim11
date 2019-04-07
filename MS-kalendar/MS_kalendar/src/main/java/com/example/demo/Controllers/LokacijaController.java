package com.example.demo.Controllers;

import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entities.Lokacija;
import com.example.demo.Services.LokacijaService;

import antlr.collections.List;

@RestController
public class LokacijaController {
	
	@Autowired
	public LokacijaService lokacijaService;
	
	@RequestMapping(value="/lokacija/{id}",method=RequestMethod.GET)
	public Optional<Lokacija> Lokacija(@PathVariable int id){
		return lokacijaService.findById(id);
	}
	
	@RequestMapping(value="/lokacije",method=RequestMethod.GET)
	public Iterable<Lokacija> Lokacije(){
		return lokacijaService.findAll();
	}
	
	@RequestMapping(value="/lokacija",method=RequestMethod.POST)
	public JSONObject updateLokacija(@RequestBody Lokacija l ){
		return lokacijaService.updateLokacija(l);
	}
	
	@RequestMapping(value="/lokacija/{id}",method=RequestMethod.DELETE)
	public JSONObject deleteLokacija(@PathVariable int id){
		Optional<Lokacija> l=lokacijaService.findById(id);
		if(!l.isPresent())return new JSONObject().put("message","ne postoji lokacija sa datim id identifikatorom");
		return lokacijaService.deleteLokacija(id);
	}
	
	@RequestMapping(value="/lokacija/{name}",method=RequestMethod.PUT)
	public JSONObject addLokacija(@PathVariable String name ){
		return lokacijaService.addLokacija(new Lokacija(name));
	}

}
