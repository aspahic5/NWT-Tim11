package com.example.demo;

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


	public static void main(String[] args) {
		SpringApplication.run(MsUpravljnajeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Aktivnost aktivnost1 = new Aktivnost("januar", "uradi nesto", 0);
		Selidba selidba1 = new Selidba(2, "Doboj", "01.02.2019.", "14.02.2019.", "1000.00");
		Aktivnost aktivnost2 = new Aktivnost("februar", "uradi nesto2", 0);
		Selidba selidba2 = new Selidba(2, "Čaršija", "21.03.2019.", "04.04.2019.", "120.00");

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
		Kosnica kosnica = new Kosnica(1, "2016", 10, 2, "200.23 grama", "pogaca", 1, "bla bla", null, selidbe, aktivnosti);
		Kosnica kosnica2 = new Kosnica(2, "2016", 10, 2, "200.23 grama", "pogaca", 1, "bla bla", kosnica, selidbe, aktivnosti);
		
		System.out.println(kosnicaService.addKosnica(kosnica));
		System.out.println(kosnicaService.addKosnica(kosnica2));

		Rojenje rojenje = new Rojenje(kosnica, 1, "04.04.2019.", "Za rojenje", "Neki komentar");

		System.out.println(rojenjeService.addRojenje(rojenje));
		Varoa varoa = new Varoa(kosnica, 23, "Neki komentar za varou");

		System.out.println(varoaService.addVaroa(varoa));

		
	}

}
