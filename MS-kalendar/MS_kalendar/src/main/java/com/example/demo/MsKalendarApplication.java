package com.example.demo;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.Entities.Biljka;
import com.example.demo.Entities.Lokacija;
import com.example.demo.Services.BiljkaService;
import com.example.demo.Services.LokacijaService;

@SpringBootApplication
public class MsKalendarApplication implements CommandLineRunner {
	
	@Autowired
	LokacijaService lokacijaService;
	
	@Autowired
	BiljkaService biljkaService;
	
	public static void main(String[] args) {
		SpringApplication.run(MsKalendarApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Lokacija lokacija1=new Lokacija("Zenica");
		Lokacija lokacija2=new Lokacija("Sarajevo");
		
		System.out.println(lokacijaService.addLokacija(lokacija1));
		System.out.println(lokacijaService.addLokacija(lokacija2));
		
		Set<Lokacija> set= new HashSet<Lokacija>(); 
		set.add(lokacija1);
		set.add(lokacija2);
		
		Biljka biljka1= new Biljka("bagrem","april","maj",set);
		Biljka biljka2= new Biljka("malina","maj","jun",set);
		
		System.out.println(biljkaService.addBiljka(biljka1));
		System.out.println(biljkaService.addBiljka(biljka2));
		
	}

}
