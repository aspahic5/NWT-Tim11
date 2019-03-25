package com.example.demo.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Kosnica")
public class Kosnica {
	
	@Id
    @Column(name = "kosnica_id", unique = true, nullable = false)
	private int id;
	
	

	public int getId() {
		return id;
	}

	public Kosnica(int id) {
		super();
		this.id = id;
	}

	public Kosnica() {
		
	}

	
	
	
	
	

}
