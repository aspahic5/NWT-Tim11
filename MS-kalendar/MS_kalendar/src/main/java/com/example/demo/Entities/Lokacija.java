package com.example.demo.Entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="Lokacija")
public class Lokacija {
	
	@Id
    @GeneratedValue
    @Column(name = "lokacija_id", unique = true, nullable = false)
	private int id;
	
	@Pattern(regexp = "^[a-zA-Z-čćžš]{3,30}$",message="naziv lokacije može sadržavati samo slova")
	@Column(name = "lokacija", nullable = false)
	private String lokcaija;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLokcaija() {
		return lokcaija;
	}

	public void setLokcaija(String lokcaija) {
		this.lokcaija = lokcaija;
	}

	public Lokacija(String lokcaija) {
		super();
		this.lokcaija = lokcaija;
	}
	
	public Lokacija(){}
	
	

}
