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
@Table(name="Biljka")
public class Biljka {
	
	@Id
    @GeneratedValue
    @Column(name = "biljka_id", unique = true, nullable = false)
	private int id;
	
	@Pattern(regexp = "^[a-zA-Z-čćžš]{3,30}$", message="naziv biljke može sadržavati samo slova i mora imati dužinu 3-30 slova")
	@Column(name = "biljka", nullable = false)
	private String biljka;

	@Pattern(regexp = "^[a-zA-Z-čćžš]{3,30}$", message="naziv mjeseca može sadržavati samo slova")
	@Column(name = "poc_mjesec", nullable = false)
	private String poc_mjesec;
	
	@Pattern(regexp = "^[a-zA-Z-čćžš]{3,30}$",message="naziv mjeseca može sadržavati samo slova")
	@Column(name = "kraj_mjesec", nullable = false)
	private String kraj_mjesec;
	
	@ManyToMany
    Set<Lokacija> lokacije;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBiljka() {
		return biljka;
	}

	public void setBiljka(String biljka) {
		this.biljka = biljka;
	}

	public String getPoc_mjesec() {
		return poc_mjesec;
	}

	public void setPoc_mjesec(String poc_mjesec) {
		this.poc_mjesec = poc_mjesec;
	}

	public String getKraj_mjesec() {
		return kraj_mjesec;
	}

	public void setKraj_mjesec(String kraj_mjesec) {
		this.kraj_mjesec = kraj_mjesec;
	}

	public Set<Lokacija> getLokacije() {
		return lokacije;
	}

	public void setLokacije(Set<Lokacija> lokacije) {
		this.lokacije = lokacije;
	}

	public Biljka(String biljka, String poc_mjesec, String kraj_mjesec, Set<Lokacija> lokacije) {
		super();
		this.biljka = biljka;
		this.poc_mjesec = poc_mjesec;
		this.kraj_mjesec = kraj_mjesec;
		this.lokacije = lokacije;
	}
	
	public Biljka() {}
	
	
}
