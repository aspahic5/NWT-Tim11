package com.example.demo.Entities;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;

@Entity
@Table(name="Vrcanje")
public class Vrcanje {
	
	@Id
    @GeneratedValue
    @Column(name = "vrcanje_id", unique = true, nullable = false)
	private int id;
	public void setKolicina(double kolicina) {
		this.kolicina = kolicina;
	}
	public void setKmkg(double kmkg) {
		this.kmkg = kmkg;
	}

	
	@Column(name="kolicina", nullable=false)
	@Min(value = 0, message = "Neispravno unešena količina!")
	private double kolicina;
	
	@Column(name="km_kg", nullable=false)
	@Min(value = 0, message = "Potrebno je unijeti cijenu po kilogramu!")
	private double kmkg;

	@Column(name="date", nullable=false)
	private Date date;
		
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
	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDate() {
		return date;
	}


	public Vrcanje(double kolicina, double kmkg, Set<Kosnica> kosnice) {
		super();
		this.kolicina = kolicina;
		this.kmkg = kmkg;
		this.kosnice = kosnice;
	}
	
	public Vrcanje(double kolicina, double kmkg) {
		super();
		this.kolicina = kolicina;
		this.kmkg = kmkg;
		this.date = Date.valueOf(LocalDate.now().plusDays(1).toString());
	}
	
	public Vrcanje() {
		
	}
	
	

}
