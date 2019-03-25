package com.example.demo.Entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Vrcanje")
public class Vrcanje {
	
	@Id
    @GeneratedValue
    @Column(name = "vrcanje_id", unique = true, nullable = false)
	private int id;

	
	@Column(name="kolicina", nullable=false)
	private double kolicina;
	
	@Column(name="km_kg", nullable=false)
	private double kmkg;
		
	@ManyToMany
    Set<Kosnica> kosnice;


	public int getId() {
		return id;
	}


	public double getKolicina() {
		return kolicina;
	}


	public double getKmkg() {
		return kmkg;
	}


	public Set<Kosnica> getKosnice() {
		return kosnice;
	}


	public Vrcanje(double kolicina, double kmkg, Set<Kosnica> kosnice) {
		super();
		this.kolicina = kolicina;
		this.kmkg = kmkg;
		this.kosnice = kosnice;
	}
	public Vrcanje() {
		
	}
	
	

}
