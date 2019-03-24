package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.demo.Entities.Korisnik;
import com.example.demo.Entities.Role;
import com.example.demo.Services.KorisnikService;
import com.example.demo.Services.RoleService;

@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
public class MsAuthenticationApplication implements CommandLineRunner{

	@Autowired
	KorisnikService korisnikService;
	
	@Autowired
    RoleService roleService;
	
	public static void main(String[] args) {
		SpringApplication.run(MsAuthenticationApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		

		Role rola1=new Role("admin");
		Role rola2=new Role("korisnik");
		
		System.out.println(roleService.addRole(rola1));
		System.out.println(roleService.addRole(rola2));
		
		
		Korisnik korisnik1=new Korisnik("korisnik1-ime","krisnik1-prezime","korisnik1-username","korisnik1-password","korisnik1-brojtelefona",rola1);
		Korisnik korisnik2=new Korisnik("korisnik2-ime","krisnik2-prezime","korisnik2-username","korisnik2-password","korisnik2-brojtelefona",rola1);
	
		System.out.println(korisnikService.addKorisnik(korisnik1));
		System.out.println(korisnikService.addKorisnik(korisnik2));
		
		
	}
	
	 

}
