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
		

		Role rola1=new Role("8");
		
		
		System.out.println(rola1.getRole());
		
		
	}
	
	 

}
