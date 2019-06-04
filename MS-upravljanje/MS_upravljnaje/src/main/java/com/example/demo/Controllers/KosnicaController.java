package com.example.demo.Controllers;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;

import com.example.demo.Validation;
import com.example.demo.Entities.Kosnica;
import com.example.demo.Services.KosnicaService;
import com.example.demo.config.MessageProducer;
import com.google.gson.Gson;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KosnicaController {

	
	@Autowired
	private MessageProducer messageProducer;
	
    @Autowired
    private KosnicaService kosnicaService;

    @Autowired
    Validation v;
    
    @RequestMapping(value="/poruka",method=RequestMethod.POST)
    public String poruka(@RequestPart("message") String poruka) {
    	 messageProducer.sendMessage(poruka);
    	return "Poslana poruka = "+poruka;
    }
    
    @RequestMapping(value = "/DajSveKosnice", method = RequestMethod.POST)
    public String GetAllKosnice(@RequestPart("username") String username, @RequestPart("password") String password) {
    	try {
    		JSONObject o=v.provjeri(username,password);
    	}
    	catch(Exception e) {
    		return e.getMessage().toString();
    	}
    	messageProducer.sendMessage(new Gson().toJson(kosnicaService.findAll()).toString());
    	return "Poslana poruka ";
         
    }

    @RequestMapping(value = "/Kosnica/{id}", method = RequestMethod.OPTIONS)
    public String getKosnicaById(@PathVariable int id, @RequestPart("username") String username, @RequestPart("password") String password) {
    	try {
        	JSONObject o=v.provjeri(username,password);
        }
        catch(Exception e) {
        	return e.getMessage().toString();
        }
    	JSONObject o1 = new JSONObject(kosnicaService.findById(id).get());
        return o1.toString();
    }

    @RequestMapping(value="/Kosnica", method=RequestMethod.POST)
    public String createKosnica(@RequestPart("Kosnica") String k, @RequestPart("username") String username, @RequestPart("password") String password) {
    	JSONObject o;
    	try {
        	o=v.provjeri(username,password);
        }
        catch(Exception e) {
        	return e.getMessage().toString();
        }
        JSONObject o1 = new JSONObject(k); 
        String de = o1.getString("maticagod");
        DateFormat originalFormat = new SimpleDateFormat("dd/mm/yyyy");
        DateFormat targetFormat = new SimpleDateFormat("yyyy-mm-dd");
        java.util.Date date;
        try{
            date = originalFormat.parse(de);
        } 
        catch(Exception e) {
            return e.getMessage().toString();
        }
        
        Calendar c = Calendar.getInstance(); 
        c.setTime(date); 
        c.add(Calendar.DATE, 1);
        date = c.getTime();
        String formattedDate = targetFormat.format(date);  
       
        Kosnica k1 = new Kosnica(o.getInt("id"), Date.valueOf(formattedDate), o1.getInt("brojramova"), o1.getInt("brojnastavaka"), o1.getDouble("kolstimulansa"), o1.getString("tipstimulansa"), o1.getInt("brojhanemanki"), o1.getString("komentar"), null, null, null); 
        return kosnicaService.addKosnica(k1);
    }

    @RequestMapping(value="/SelidbaNaKosnicu/{id}/{ids}", method=RequestMethod.PUT)
    public String addSelidbaToKosnica(@PathVariable int ids, @PathVariable int id, @RequestPart("username") String username, @RequestPart("password") String password) {
    	try {
        	JSONObject o=v.provjeri(username,password);
        }
        catch(Exception e) {
        	return e.getMessage().toString();
        }
        return kosnicaService.addSelidbaToKosnica(ids, id);
        
    }

    @RequestMapping(value="/AktivnostNaKosnicu/{id}/{ida}", method=RequestMethod.PUT)
    public String addAktivnostToKosnica(@PathVariable int ida, @PathVariable int id, @RequestPart("username") String username, @RequestPart("password") String password) {
    	try {
        	JSONObject o=v.provjeri(username,password);
        }
        catch(Exception e) {
        	return e.getMessage().toString();
        }
        return kosnicaService.addAktivnostToKosnica(ida, id);
    }

    @RequestMapping(value="/KosnicaNaKosnicu/{id}/{idk}", method=RequestMethod.PUT)
    public String addKosnicaToKosnica(@PathVariable int idk, @PathVariable int id, @RequestPart("username") String username, @RequestPart("password") String password) {
    	try {
        	JSONObject o=v.provjeri(username,password);
        }
        catch(Exception e) {
        	return e.getMessage().toString();
        }
        return kosnicaService.addKosnicaToKosnica(idk, id);
    }
    
    @RequestMapping(value="/Kosnica/{id}", method = RequestMethod.PUT)
    public String updateKosnica(@RequestPart("Kosnica") String k, @PathVariable int id, @RequestPart("username") String username, @RequestPart("password") String password) {
    	try {
        	JSONObject o=v.provjeri(username,password);
        }
        catch(Exception e) {
        	return e.getMessage().toString();
        }
    	JSONObject o1 = new JSONObject(k);
    	Kosnica k1 = new Kosnica(o1.getInt("vlasnik_id"), Date.valueOf(o1.getString("maticagod")), o1.getInt("brojramova"), o1.getInt("brojnastavaka"), o1.getDouble("kolstimulansa"), o1.getString("tipstimulansa"), o1.getInt("brojhanemanki"), o1.getString("komentar"), null, null, null); 
        return kosnicaService.updateKosnica(id, k1);
    }

    @RequestMapping(value="/Kosnica/{id}", method=RequestMethod.DELETE)
    public String deleteKosnica(@PathVariable int id, @RequestPart("username") String username, @RequestPart("password") String password) {
    	try {
        	JSONObject o=v.provjeri(username,password);
        }
        catch(Exception e) {
        	return e.getMessage().toString();
        }
        return kosnicaService.deleteKosnica(id);
    }
    
    @RequestMapping(value="/Kosnica/{idv}", method=RequestMethod.PATCH)
	public String getKosniceOdVlasnika(@PathVariable int idv, @RequestPart("username") String username, @RequestPart("password") String password) {
    	try {
        	JSONObject o=v.provjeri(username,password);
        }
        catch(Exception e) {
        	return e.getMessage().toString();
        }
    	 return new Gson().toJson(kosnicaService.getKosniceOdVlasnika(idv)); 
	}
}