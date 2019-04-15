package com.example.demo;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Entities.Kosnica;
import com.example.demo.Entities.Maticna_mlijec;
import com.example.demo.Entities.Propolis;
import com.example.demo.Entities.Rashodi;
import com.example.demo.Entities.Unos;
import com.example.demo.Entities.Vrcanje;
import com.example.demo.Services.KosnicaService;
import com.example.demo.Services.MaticnaMlijecService;
import com.example.demo.Services.PropolisService;
import com.example.demo.Services.RashodiService;
import com.example.demo.Services.UnosService;
import com.example.demo.Services.VrcanjeService;

@EnableEurekaClient
@SpringBootApplication
public class MsProizvodnjaApplication implements CommandLineRunner{

	@Autowired
	private KosnicaService kosnicaService;
	@Autowired
	private RashodiService rashodiService;
	@Autowired
	private MaticnaMlijecService mlijecService;
	@Autowired
	private PropolisService propolisService;
	@Autowired
	private UnosService unosService;
	@Autowired
	private VrcanjeService vrcanjeService;
	
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(MsProizvodnjaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		Kosnica k1=new Kosnica(1);
		Kosnica k2=new Kosnica(2);
		
		System.out.println(kosnicaService.addKosnica(k1));
		System.out.println(kosnicaService.addKosnica(k2));
		
		Set<Kosnica> setKosnica1= new HashSet<Kosnica>(); 
		Set<Kosnica> setKosnica2= new HashSet<Kosnica>(); 
		
		setKosnica1.add(k1);
		
		setKosnica2.add(k1);
		setKosnica2.add(k2);
		
		
		Rashodi r1=new Rashodi(123.0,setKosnica1);
		Rashodi r2=new Rashodi(123.0,setKosnica2);
		
		System.out.println(rashodiService.addRashod(r1));
		System.out.println(rashodiService.addRashod(r2));
		
		Maticna_mlijec mm1 = new Maticna_mlijec(1, 1000, setKosnica1);
		Maticna_mlijec mm2 = new Maticna_mlijec(1.5, 1000, setKosnica2);
		
		System.out.println(mlijecService.addMlijec(mm1));
		System.out.println(mlijecService.addMlijec(mm2));
		
		Propolis p1 = new Propolis(50, 500, setKosnica1);
		Propolis p2 = new Propolis(110, 500, setKosnica1);
		
		System.out.println(propolisService.addPropolis(p1));
		System.out.println(propolisService.addPropolis(p2));
		
		
		Unos u1 = new Unos(100, Date.valueOf(LocalDate.now()), k1);
		Unos u2 = new Unos(150, Date.valueOf(LocalDate.now()), k2);
		
		System.out.println(unosService.addUnos(u1));
		System.out.println(unosService.addUnos(u2));
		
		Vrcanje v1 = new Vrcanje(40, 20, setKosnica1);
		Vrcanje v2 = new Vrcanje(40, 20, setKosnica2);
		
		System.out.println(vrcanjeService.addVrcanje(v1));
		System.out.println(vrcanjeService.addVrcanje(v2));
		*/
		/*
		Kosnica k1=new Kosnica(1);
		Kosnica k2=new Kosnica(2);
		
		System.out.println(kosnicaService.addKosnica(k1));
		System.out.println(kosnicaService.addKosnica(k2));
		
		Set<Kosnica> setKosnica1= new HashSet<Kosnica>(); 
		Set<Kosnica> setKosnica2= new HashSet<Kosnica>(); 
		
		setKosnica1.add(k1);
		
		setKosnica2.add(k1);
		setKosnica2.add(k2);
		
		
		Rashodi r1=new Rashodi(123.0,setKosnica1);
		Rashodi r2=new Rashodi(123.0,setKosnica2);
		
		System.out.println(rashodiService.addRashod(r1,1));
		System.out.println(rashodiService.addRashod(r2,2));
		
		Maticna_mlijec mm1 = new Maticna_mlijec(1, 1000, setKosnica1);
		Maticna_mlijec mm2 = new Maticna_mlijec(1.5, 1000, setKosnica2);
		
		System.out.println(mlijecService.addMaticna(mm1,1));
		System.out.println(mlijecService.addMaticna(mm2,2));
		*/
		
	}

}
