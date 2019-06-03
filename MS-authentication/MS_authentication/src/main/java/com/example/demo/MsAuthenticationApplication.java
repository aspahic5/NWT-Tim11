package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entities.Korisnik;
import com.example.demo.Entities.Role;
import com.example.demo.Repositories.KorisnikRepository;
import com.example.demo.Services.KorisnikService;
import com.example.demo.Services.RoleService;
import com.netflix.appinfo.InstanceInfo;


@EnableEurekaClient
@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
public class MsAuthenticationApplication implements CommandLineRunner{

	@Autowired
	KorisnikService korisnikService;
	
	@Autowired
	KorisnikRepository korisnikrepo;
	
	@Autowired
    RoleService roleService;
	
	public static void main(String[] args) {
		SpringApplication.run(MsAuthenticationApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		

		
		
		
		System.out.println(korisnikrepo.findAll().toString());
		
		
	}
}
	
	@RestController
	class ServiceInstanceRestController {

	    @Autowired
	    private DiscoveryClient discoveryClient;

	    @RequestMapping("/service-instances/{applicationName}")
	    public List<ServiceInstance> serviceInstancesByApplicationName(
	            @PathVariable String applicationName) {
	        return this.discoveryClient.getInstances(applicationName);
	    }
	
	

}
