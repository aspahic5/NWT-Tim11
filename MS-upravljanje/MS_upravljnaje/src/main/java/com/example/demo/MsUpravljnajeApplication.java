package com.example.demo;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.example.demo.Entities.Aktivnost;
import com.example.demo.Entities.Kosnica;
import com.example.demo.Entities.Rojenje;
import com.example.demo.Entities.Selidba;
import com.example.demo.Entities.Varoa;
import com.example.demo.Services.AktivnostService;
import com.example.demo.Services.KosnicaService;
import com.example.demo.Services.RojenjeService;
import com.example.demo.Services.SelidbaService;
import com.example.demo.Services.VaroaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@SpringBootApplication
public class MsUpravljnajeApplication implements CommandLineRunner {

	@Autowired
	AktivnostService aktivnostService;

	@Autowired
	KosnicaService kosnicaService;

	@Autowired
	RojenjeService rojenjeService;

	@Autowired 
	SelidbaService selidbaService;

	@Autowired
	VaroaService varoaService;

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	

	public static void main(String[] args) {
		SpringApplication.run(MsUpravljnajeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	/*	try {
			Aktivnost aktivnost1 = new Aktivnost("januar", "uradi nesto", 0);
			Selidba selidba1 = new Selidba(2, "Doboj", Date.valueOf(LocalDate.now()), Date.valueOf(LocalDate.now()), 1000.00);
			Aktivnost aktivnost2 = new Aktivnost("februar", "uradi nesto2", 0);
			Selidba selidba2 = new Selidba(2, "Čaršija", Date.valueOf(LocalDate.now()), Date.valueOf(LocalDate.now()), 120.00);

			System.out.println(aktivnostService.addAktivnost(aktivnost1));
			System.out.println(aktivnostService.addAktivnost(aktivnost2));
			System.out.println(selidbaService.addSelidba(selidba1));
			System.out.println(selidbaService.addSelidba(selidba2));
			Set<Aktivnost> aktivnosti = new HashSet<Aktivnost>();
			aktivnosti.add(aktivnost1);
			aktivnosti.add(aktivnost2);
			Set<Selidba> selidbe = new HashSet<Selidba>();
			selidbe.add(selidba1);
			selidbe.add(selidba2);
			Kosnica kosnica = new Kosnica(1, Date.valueOf("2019-4-1"), 10, 2, 200.23, "pogaca", 1, "bla blaf sdaf", null, aktivnosti, selidbe);
			Kosnica kosnica3 = new Kosnica(4, Date.valueOf(LocalDate.now()), 10, 2, 200.23, "pogaca", 1, "bla bla nbfdd", null, null, null);
			Kosnica kosnica2 = new Kosnica(2, Date.valueOf(LocalDate.now()), 10, 2, 200.23, "pogaca", 1, "bla bla blas", kosnica, aktivnosti, selidbe);
			
			System.out.println(kosnicaService.addKosnica(kosnica));
			System.out.println(kosnicaService.addKosnica(kosnica2));
			System.out.println(kosnicaService.addKosnica(kosnica3));

			Rojenje rojenje = new Rojenje(kosnica, 1, Date.valueOf(LocalDate.now()), "Za rojenje", "Neki komentar");

			System.out.println(rojenjeService.addRojenje(rojenje));
			Varoa varoa = new Varoa(kosnica, 23, Date.valueOf(LocalDate.now()), "Neki komentar za varou tako da");

			System.out.println(varoaService.addVaroa(varoa));
		} catch(Exception e) {
			e.printStackTrace();
		} */
		
		
	}

}
