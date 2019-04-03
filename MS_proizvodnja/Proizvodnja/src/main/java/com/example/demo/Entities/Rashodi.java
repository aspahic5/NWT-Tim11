package com.example.demo.Entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;

@Entity
@Table(name="Rashodi")
public class Rashodi {
	
	
	@Id
    @GeneratedValue
    @Column(name = "rashod_id", unique = true, nullable = false)
	private int id;

	
	@Column(name="cijena", nullable=false)
	@Min(value = 0, message = "Potrebno je unijeti cijenu!")
	private double cijena;
	
	
	@ManyToMany
    Set<Kosnica> kosnice;


	public int getId() {
		return id;
	}


	public double getCijena() {
		return cijena;
	}


	public Set<Kosnica> getKosnice() {
		return kosnice;
	}
	public void setCijena(double cijena) {
		this.cijena = cijena;
	}


	public Rashodi(double cijena, Set<Kosnica> kosnice) {
		super();
		this.cijena = cijena;
		this.kosnice = kosnice;
	}
	
	public Rashodi() {
		
	}


	

	
	
	
}
