package com.example.demo.Entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;

@Entity
@Table(name="Maticana_mlijec")
public class Maticna_mlijec {
	
	@Id
    @GeneratedValue
    @Column(name = "mlijec_id", unique = true, nullable = false)
	private int id;

	
	@Column(name="kolicina", nullable=false)
	@Min(value = 0, message = "Neispravno unešena količina matične mliječi!")
	private double kolicina;
	
	@Column(name="km_kg", nullable=false)
	@Min(value = 0, message = "Potrebno je unijeti cijenu po kilogramu!")
	private double kmkg;
	
	public void setKolicina(double kolicina) {
		this.kolicina = kolicina;
	}
	public void setKmkg(double kmkg) {
		this.kmkg = kmkg;
	}
	
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



	public Maticna_mlijec(double kolicina, double kmkg, Set<Kosnica> kosnice) {
		super();
		this.kolicina = kolicina;
		this.kmkg = kmkg;
		this.kosnice = kosnice;
	}
	
	public Maticna_mlijec(double kolicina, double kmkg) {
		super();
		this.kolicina = kolicina;
		this.kmkg = kmkg;
	}
	
	public Maticna_mlijec() {
		
	}
	
	

}
