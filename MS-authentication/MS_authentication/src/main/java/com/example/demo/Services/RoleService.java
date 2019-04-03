package com.example.demo.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

import com.example.demo.Entities.Role;
import com.example.demo.Repositories.RoleRepository;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	public Iterable<Role> AllRoles() {
		
		return roleRepository.findAll();
		
	}
	
	public Optional<Role> getRoleById(int id) {
		
		return roleRepository.findById(id);
		
	}
	
	public String addRole(Role r) {
		
		try {
			roleRepository.save(r);
		}
		catch(TransactionSystemException ex) {
			return ex.getRootCause().getMessage().toString();
			
		}
		
		return "Role saved";
		
	}

	
	public String updateRole(Role r) {
		
		try {
		roleRepository.save(r);
		}
		catch(TransactionSystemException ex) {
			return ex.getRootCause().getMessage().toString();
			
		}
		return "Role updated";
	}
	
	public String deleteRole(int id) {
		try {
		roleRepository.deleteById(id);
		}
		catch(TransactionSystemException ex) {
			return ex.getRootCause().getMessage().toString();
			
		}
		return "Role deleted";
	}
}
