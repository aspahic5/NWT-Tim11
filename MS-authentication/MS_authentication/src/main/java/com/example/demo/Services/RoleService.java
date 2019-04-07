package com.example.demo.Services;

import java.util.Optional;

import org.json.JSONObject;
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
	
	public JSONObject addRole(Role r) {
		JSONObject o = new JSONObject();
		try {
			roleRepository.save(r);
		}
		catch(TransactionSystemException ex) {
			o.put("message",ex.getRootCause().getMessage().toString());
			return o;
			
		}
		
		o.put("message", "Role saved");
		
		return o;
		
	}

	
	public JSONObject updateRole(Role r) {
		JSONObject o = new JSONObject();
		try {
		roleRepository.save(r);
		}
		catch(TransactionSystemException ex) {
			o.put("message",ex.getRootCause().getMessage().toString());
			return o;
			
		}
		
		o.put("message", "Role updated");
		
		return o;
	}
	
	public JSONObject deleteRole(int id) {
		JSONObject o = new JSONObject();
		try {
		roleRepository.deleteById(id);
		}
		catch(TransactionSystemException ex) {
			o.put("message",ex.getRootCause().getMessage().toString());
			return o;
			
		}
		
		o.put("message", "Role deleted");
		
		return o;
	}
}
