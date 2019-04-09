package com.example.demo.Controllers;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entities.Korisnik;
import com.example.demo.Entities.Role;
import com.example.demo.Services.KorisnikService;

@RestController
public class KorisnikController {
	
	@Autowired
	private KorisnikService korisnikService;
	
	@RequestMapping(value="/provjeri",method=RequestMethod.POST)
	public String provjeri(@RequestPart("username") String username, @RequestPart("password") String password) {
		
		return korisnikService.provjeri(username, password).toString();
	}
	
	
	@RequestMapping("/Korisnik/{id}")
	public Optional<Korisnik> getKorisnikByID(@PathVariable Integer id){
		return korisnikService.getKorisnikById(id);
	}

	@RequestMapping(value="/Korisnik",method=RequestMethod.PUT)
	public String addKorisnik(@RequestBody Korisnik k){
		Korisnik newk= new Korisnik(k.getIme(),k.getPrezime(),k.getUsername(),k.getPassword(),k.getBroj_telefona(),k.getRole());
		
		return korisnikService.addKorisnik(newk).toString();
		
		
	}
	
	@RequestMapping(value="/Korisnik/{id}",method=RequestMethod.DELETE)
	public String deleteKorisnik(@PathVariable int id) {
		Optional<Korisnik> k=korisnikService.getKorisnikById(id);
		if(!k.isPresent())return new JSONObject().put("message","Ne postoji korisnik sa datim id identifikatorom").toString();
		return korisnikService.deleteKorisnik(id).toString();
	}

	@RequestMapping(value="/Korisnik",method=RequestMethod.POST)
	public String update(@RequestBody Korisnik k){
		
		
		return korisnikService.updateKorisnik(k).toString();
		
		
	}
}
