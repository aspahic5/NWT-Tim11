package com.example.demo.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Role;
import com.example.demo.Repositories.RoleRepository;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	public Iterable<Role> AllRoles() {
		
		return roleRepository.findAll();
		
	}
	
	public Optional<Role> getRoleId(int id) {
		
		return roleRepository.findById(id);
		
	}
	
	public String addRole(Role r) {
		
		try {
			roleRepository.save(r);
		}
		catch(Exception e) {
			return e.toString();
		}
		
		return "Role saved";
		
	}

}
