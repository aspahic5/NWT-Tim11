package com.example.demo.Controllers;

import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entities.Korisnik;
import com.example.demo.Entities.Role;
import com.example.demo.Services.KorisnikService;
import com.example.demo.Services.RoleService;

@RestController
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value="/Role/{id}")
	public Optional<Role> getRole(@PathVariable int id) {
		return roleService.getRoleById(id);
	}
	
	@RequestMapping(value="/Role/{role}",method=RequestMethod.PUT)
	public String addRole(@PathVariable String role){
		
		Role r=new Role(role.toString());
		return roleService.addRole(r).toString();
		
		
	}
	
	@RequestMapping(value="/Role/{id}",method=RequestMethod.DELETE)
	public String deleteRole(@PathVariable int id) {
		Optional<Role> r=roleService.getRoleById(id);
		if(!r.isPresent())return new JSONObject().put("message","Ne postoji rola sa datim id identifikatorom").toString();
		return roleService.deleteRole(id).toString();
	}
	
	@RequestMapping(value="/Role",method=RequestMethod.POST)
	public String updateRole(@RequestBody Role r) {
		return roleService.updateRole(r).toString();
	}
	
	

}
