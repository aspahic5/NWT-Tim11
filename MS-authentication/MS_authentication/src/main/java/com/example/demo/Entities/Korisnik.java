package com.example.demo.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "Korisnici")
public class Korisnik {
	
	@Id
    @GeneratedValue
    @Column(name = "korisnik_id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "ime", nullable = false)
	private String ime;
	
	@Column(name = "prezime",nullable = false)
	private String prezime;
	
	@Column(name = "username",nullable = false, unique=true)
	private String username;

	@Column(name = "password",nullable = false)
	private String password;
	
	@Column(name = "broj_telefona",nullable = false)
	private String broj_telefona;
	
	@ManyToOne
	@JoinColumn(name = "role_id")
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

	public Korisnik(String ime, String prezime, String username, String password, String broj_telefona, Role role) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.username = username;
		this.password = password;
		this.broj_telefona = broj_telefona;
		this.role = role;
	}

	
	
	
}
