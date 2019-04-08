package com.example.demo.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class Korisnik {
	
	private int id;
	private String ime;
	private String prezime;
	private String username;
	private String password;
	private String broj_telefona;
	
	private Role role;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBroj_telefona() {
		return broj_telefona;
	}

	public void setBroj_telefona(String broj_telefona) {
		this.broj_telefona = broj_telefona;
	}
	

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Korisnik(String ime, String prezime, String username, String password, String broj_telefona, Role role) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.username = username;
		this.password = password;
		this.broj_telefona = broj_telefona;
		this.role = role;
	}

	public Korisnik() {}
	
	
	
}
