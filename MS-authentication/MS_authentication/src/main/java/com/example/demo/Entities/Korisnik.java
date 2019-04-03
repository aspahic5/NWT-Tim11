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



@Entity
@Table(name = "Korisnici")
public class Korisnik {
	
	@Id
    @GeneratedValue
    @Column(name = "korisnik_id", unique = true, nullable = false)
	private int id;
	
	@NotNull
	@Pattern(regexp = "^[a-zA-Z-čćžš]{3,30}$")
	@Column(name = "ime", nullable = false)
	private String ime;
	
	@NotNull
	@Pattern(regexp = "^[a-zA-Z-čćžš]{3,30}$")
	@Column(name = "prezime",nullable = false)
	private String prezime;
	
	@NotNull
	@Pattern(regexp = "^[a-zA-Z-1-9]{4,30}$")
	@Column(name = "username",nullable = false, unique=true)
	private String username;

	@NotNull
	@Pattern(regexp = "^[a-zA-Z-1-9]{4,30}$")
	@Column(name = "password",nullable = false)
	private String password;
	
	@NotNull
	@Pattern(regexp = "^\\d{3}\\/\\d{3}\\-\\d{3}$")
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
