package com.example.demo;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.example.demo.Entities.Biljka;
import com.example.demo.Entities.Lokacija;
import com.example.demo.Services.BiljkaService;
import com.example.demo.Services.LokacijaService;

@EnableEurekaClient
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
		
		/*
		Lokacija lokacija1=new Lokacija("Zenica");
		Lokacija lokacija2=new Lokacija("Sarajevo");
		Lokacija lokacija3=new Lokacija("Tuzla");
		
		System.out.println(lokacijaService.addLokacija(lokacija1));
		System.out.println(lokacijaService.addLokacija(lokacija2));
		System.out.println(lokacijaService.addLokacija(lokacija3));
		
		Set<Lokacija> set1= new HashSet<Lokacija>(); 
		set1.add(lokacija1);
		set1.add(lokacija2);
		
		Set<Lokacija> set2= new HashSet<Lokacija>(); 
		set2.add(lokacija1);
		set2.add(lokacija3);
		
		Biljka biljka1= new Biljka("Bagrem","april","maj",set1);
		Biljka biljka2= new Biljka("Lipa","maj","jun",set2);
		Biljka biljka3= new Biljka("Lijeska","maj","jun",set2);
		
		System.out.println(biljkaService.addBiljka(biljka1));
		System.out.println(biljkaService.addBiljka(biljka2));
		System.out.println(biljkaService.addBiljka(biljka3));
		*/
		
	}

}
