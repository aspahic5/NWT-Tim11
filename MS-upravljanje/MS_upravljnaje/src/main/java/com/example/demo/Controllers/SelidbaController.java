package com.example.demo.Controllers;

import java.sql.Date;

import com.example.demo.Validation;
import com.example.demo.Entities.Selidba;
import com.example.demo.Services.SelidbaService;
import com.google.gson.Gson;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
public class SelidbaController {

    @Autowired
    SelidbaService selidbaServis;

    @Autowired
    Validation v;

    @RequestMapping(value = "/DajSveSelidbe", method = RequestMethod.OPTIONS)
    public String getAllSelidbe(@RequestPart("username") String username, @RequestPart("password") String password) {
    	try {
        	JSONObject o=v.provjeri(username,password);
        }
        catch(Exception e) {
        	return e.getMessage().toString();
        }
    	return new Gson().toJson(selidbaServis.findAll());
    }

    @RequestMapping(value = "/Selidba/{id}", method = RequestMethod.OPTIONS)
    public String getSelidbaById(@PathVariable int id, @RequestPart("username") String username, @RequestPart("password") String password) {
    	try {
        	JSONObject o=v.provjeri(username,password);
        }
        catch(Exception e) {
        	return e.getMessage().toString();
        }
    	JSONObject o1 = new JSONObject(selidbaServis.findById(id).get());
        return o1.toString();
    }

    @RequestMapping(value = "/Selidba/{idk}", method = RequestMethod.POST)
    public String createSelidba( @PathVariable int idk, @RequestPart("Selidba") String s, @RequestPart("username") String username, @RequestPart("password") String password) {
    	try {
        	JSONObject o=v.provjeri(username,password);
        }
        catch(Exception e) {
        	return e.getMessage().toString();
        }
    	JSONObject o1 = new JSONObject(s);
    	Selidba s1 = new Selidba(o1.getInt("brojkosnica"), o1.getString("lokacija"), Date.valueOf(o1.getString("pocetak")), Date.valueOf(o1.getString("kraj")), o1.getDouble("dobit"));
        return selidbaServis.addSelidba(s1, idk);
    }

    @RequestMapping(value="/Selidba/{id}", method=RequestMethod.PUT)
    public String updateSelidba(@PathVariable int id, @RequestPart("Selidba") Selidba s, @RequestPart("username") String username, @RequestPart("password") String password) {
    	try {
        	JSONObject o=v.provjeri(username,password);
        }
        catch(Exception e) {
        	return e.getMessage().toString();
        }
    	JSONObject o1 = new JSONObject(s);
    	Selidba s1 = new Selidba(o1.getInt("brojkosnica"), o1.getString("lokacija"), Date.valueOf(o1.getString("pocetak")), Date.valueOf(o1.getString("kraj")), o1.getDouble("dobit"));
        return selidbaServis.updateSelidba(id, s1);
    }
    
    @RequestMapping(value="/Selidba/{id}", method=RequestMethod.DELETE)
    public String deleteSelidba(@PathVariable int id, @RequestPart("username") String username, @RequestPart("password") String password) {
    	try {
        	JSONObject o=v.provjeri(username,password);
        }
        catch(Exception e) {
        	return e.getMessage().toString();
        }
        return selidbaServis.delteSelidba(id);
    }
    
    @RequestMapping(value="/Selidba/{idk}", method=RequestMethod.PATCH)
    public String getSelidbeOdKosnica(@PathVariable int idk, @RequestPart("username") String username, @RequestPart("password") String password) {
            try {
                JSONObject o=v.provjeri(username,password);
                return new Gson().toJson(selidbaServis.getSelidbeOdKosnica(idk));
            }
            catch(Exception e) {
                return e.getMessage().toString();
            }
    }

    @RequestMapping(value="/Selidba/{ids}/{dobit}", method = RequestMethod.PUT)
    public String updateDobitOdSelidbe(@PathVariable("ids") int ids, @PathVariable("dobit") double dobit, @RequestPart("username") String username, @RequestPart("password") String password) {
        try {
            JSONObject o=v.provjeri(username,password);
            return selidbaServis.updateDobitOdSelidba(ids, dobit);
        }
        catch(Exception e) {
            return e.getMessage().toString();
        }
    }

}