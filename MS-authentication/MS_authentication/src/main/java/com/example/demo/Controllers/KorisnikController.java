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
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class KorisnikController {
	
	@Autowired
	private KorisnikService korisnikService;
	
	@RequestMapping(value="/provjeri",method=RequestMethod.POST)
	public String provjeri(@RequestPart("username") String username, @RequestPart("password") String password) {
		
		return korisnikService.provjeri(username, password).toString();
	}
	
	@RequestMapping(value="/Korisnik", method=RequestMethod.OPTIONS)
	public Iterable<Korisnik> getAll(@RequestPart("username") String username, @RequestPart("password") String password) {
		JSONObject o= korisnikService.provjeri(username, password);
		if(!o.getBoolean("prijavljen"))return null;
		return korisnikService.getAll();
	}
	
	
	@RequestMapping(value="/Korisnik/{id}",method=RequestMethod.OPTIONS)
	public Optional<Korisnik> getKorisnikByID(@PathVariable Integer id,@RequestPart("username") String username, @RequestPart("password") String password){
		JSONObject o= korisnikService.provjeri(username, password);
		if(!o.getBoolean("prijavljen"))return null;
		return korisnikService.getKorisnikById(id);
	}

	@RequestMapping(value="/Korisnik",method=RequestMethod.PUT)
	public String addKorisnik(@RequestPart("korisnik") String korisnik,@RequestPart("role") String role,@RequestPart("username") String username, @RequestPart("password") String password){
		JSONObject o= korisnikService.provjeri(username, password);
		if(!o.getBoolean("prijavljen"))return o.toString();
		JSONObject k=new JSONObject(korisnik);
		JSONObject r= new JSONObject(role);
		Korisnik newk= new Korisnik(k.getString("ime"),k.getString("prezime"),k.getString("username"),k.getString("password"),k.getString("broj_telefona"),new Role(r.getString("role"),r.getInt("id")));
		
		return korisnikService.addKorisnik(newk).toString();
		
		
	}
	
	@RequestMapping(value="/Korisnik/{id}",method=RequestMethod.DELETE)
	public String deleteKorisnik(@PathVariable int id,@RequestPart("username") String username, @RequestPart("password") String password) {
		Optional<Korisnik> k=korisnikService.getKorisnikById(id);
		JSONObject o= korisnikService.provjeri(username, password);
		if(!o.getBoolean("prijavljen"))return o.toString();
		if(!k.isPresent())return new JSONObject().put("message","Ne postoji korisnik sa datim id identifikatorom").toString();
		return korisnikService.deleteKorisnik(id).toString();
	}

	@RequestMapping(value="/Korisnik",method=RequestMethod.POST)
	public String update(@RequestPart("korisnik") String korisnik,@RequestPart("role") String role,@RequestPart("username") String username, @RequestPart("password") String password){
		JSONObject o= korisnikService.provjeri(username, password);
		if(!o.getBoolean("prijavljen"))return o.toString();
		JSONObject k=new JSONObject(korisnik);
		JSONObject r= new JSONObject(role);
		Korisnik newk= new Korisnik(k.getString("ime"),k.getString("prezime"),k.getString("username"),k.getString("password"),k.getString("broj_telefona"),new Role(r.getString("role"),r.getInt("id")));
		
		return korisnikService.updateKorisnik(newk).toString();
		
		
	}
}
