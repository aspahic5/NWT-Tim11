package com.example.demo.Entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Kosnica")
public class Kosnica {
	
	@Id
    @Column(name = "kosnica_id", unique = true, nullable = false)
	private int id;
	
	@ManyToMany
    @Column(nullable = true)
    Set<Propolis> propolis;

	@ManyToMany
    @Column(nullable = true)
	Set<Maticna_mlijec> maticna;
	
	@ManyToMany
    @Column(nullable = true)
	Set<Vrcanje> vrcanje;
	
	@ManyToMany
    @Column(nullable = true)
    Set<Rashodi> rashodi;


	public int getId() {
		return id;
	}

	public Kosnica(int id) {
		super();
		this.id = id;
	}

	public Kosnica() {
		
	}

	public void setPropolis(Propolis pr) {
        propolis.add(pr);
	}
	
	public void setMaticna(Maticna_mlijec pr) {
        maticna.add(pr);
	}
	
	public void setRashod(Rashodi pr) {
        rashodi.add(pr);
	}
	
	public void setVrcanje(Vrcanje pr) {
        vrcanje.add(pr);
	}
	
	
	
	
	
	

}
