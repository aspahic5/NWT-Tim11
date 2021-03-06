package com.example.demo.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "Roles")
public class Role {
	
	@Id
    @GeneratedValue
    @Column(name = "role_id", unique = true, nullable = false)
	private int id;
	
	
	
	@Column(name = "role",nullable = false, unique=true)
	@Pattern(regexp = "^[a-zA-Z]{4,30}$", message="nepravilan unos")
	private String role;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Role(String role) {
		super();
		this.role = role;
	}
	
	public Role(String role,int id) {
		super();
		this.id=id;
		this.role = role;
	}
	
	public Role() {}
	

}
