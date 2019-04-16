package com.example.demo.Controllers;

import com.example.demo.Validation;
import com.example.demo.Entities.Aktivnost;
import com.example.demo.Services.AktivnostService;
import com.google.gson.Gson;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class AktivnostController {

    @Autowired
    AktivnostService aktivnostService;
    
	@Autowired
    Validation v;

    @RequestMapping(value = "/DajSveAktivnosti", method = RequestMethod.OPTIONS)
    public String getAllAktivnosti(@RequestPart("username") String username, @RequestPart("password") String password) {
    	try {
    	JSONObject o=v.provjeri(username,password);
    	} catch(Exception e) {
    		return e.getMessage().toString();
    	}
    	return new Gson().toJson(aktivnostService.findAll()); 
    	
    }

    @RequestMapping(value = "/Aktivnost/{id}", method = RequestMethod.OPTIONS)
    public String getAktivnostById(@PathVariable int id, @RequestPart("username") String username, @RequestPart("password") String password) {
    	try {
        	JSONObject o=v.provjeri(username,password);
        } catch(Exception e) {
        	return e.getMessage().toString();
        }
    	JSONObject o1 = new JSONObject(aktivnostService.findById(id).get());
        return o1.toString();
    }

    @RequestMapping(value="/Aktivnost/{idk}", method=RequestMethod.POST)
    public String createAktivnost(@RequestPart("Aktivnost") String a, @PathVariable int idk, @RequestPart("username") String username, @RequestPart("password") String password) {
    	try {
        	JSONObject o=v.provjeri(username,password);
        } catch(Exception e) {
        	return e.getMessage().toString();
        }
    	JSONObject o1 = new JSONObject(a);
    	Aktivnost aktivnost = new Aktivnost(o1.getString("mjesec"),o1.getString("aktivnost"),o1.getInt("uradjeno"));
        return aktivnostService.addAktivnost(aktivnost, idk);
    }

    @RequestMapping(value="/Aktivnost/{id}", method=RequestMethod.PUT)
    public String updateAktivnost(@PathVariable int id, @RequestPart("Aktivnost") String a, @RequestPart("username") String username, @RequestPart("password") String password) {
    	try {
        	JSONObject o=v.provjeri(username,password);
        } catch(Exception e) {
        	return e.getMessage().toString();
        }
    	JSONObject o1 = new JSONObject(a);
    	Aktivnost aktivnost = new Aktivnost(o1.getString("mjesec"),o1.getString("aktivnost"),o1.getInt("uradjeno"));
        return aktivnostService.updateAktivnost(id, aktivnost);
    }

    @RequestMapping(value="/Aktivnost/{id}", method=RequestMethod.DELETE)
    public String deleteAktivnost(@PathVariable int id, @RequestPart("username") String username, @RequestPart("password") String password) {
    	try {
        	JSONObject o=v.provjeri(username,password);
        } catch(Exception e) {
        	return e.getMessage().toString();
        }
        return aktivnostService.deleteAktivnost(id);
	}
	
	@RequestMapping(value="/Aktivnost/{idk}", method=RequestMethod.PATCH)
	public String getAktivnostiOdKosncia(@PathVariable int idk, @RequestPart("username") String username, @RequestPart("password") String password) {
    	try {
			JSONObject o=v.provjeri(username,password);
			return new Gson().toJson(aktivnostService.getAktivnostiOdKosnica(idk));
        } catch(Exception e) {
    		return e.getMessage().toString();
		}
	}
}