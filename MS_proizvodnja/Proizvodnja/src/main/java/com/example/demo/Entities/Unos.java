package com.example.demo.Entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.PastOrPresent;

@Entity
@Table(name="Unos")
public class Unos {
	
	@Id
    @GeneratedValue
    @Column(name = "unos_id", unique = true, nullable = false)
	private int id;

	
	@Column(name="kolicina", nullable=false)
	@Min(value = 0, message = "Neispravno unešena kolličina!")
	private double kolicina;

	@Column(name="date", nullable=false)
	//@PastOrPresent(message = "Neispravno unešen datum unosa.")
    private Date date;
	
	@ManyToOne
	@JoinColumn(name = "kosnica_id")
	private Kosnica kosnica;

	public int getId() {
		return id;
	}
	public void setKosnica(Kosnica kosnica) {
		this.kosnica = kosnica;
	}

	public double getKolicina() {
		return kolicina;
	}
	public void setKolicina(double kolicina) {
		this.kolicina = kolicina;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public Kosnica getKosnica() {
		return kosnica;
	}

	public Unos(double kolicina, Date date, Kosnica kosnica) {
		super();
		this.kolicina = kolicina;
		this.date = date;
		this.kosnica = kosnica;
	}
	
	public Unos() {
		
	}
	
	
}
