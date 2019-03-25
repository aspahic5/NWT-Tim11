package com.example.demo.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "varoa")
public class Varoa {

    public Varoa(Kosnica kosnice, int broj, String komentar){
        super();
        this.kosnice = kosnice;
        this.broj = broj;
        this.komentar = komentar;
    }

    @Id
    @GeneratedValue
    @Column( name = "varoa_id", unique = true, nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn( name = "kosnica_id")
    private Kosnica kosnice;

    @Column(name = "broj")
    private int broj;

    @Column(name = "komentar")
    private String komentar;

    /**
     * @return int return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return int return the broj
     */
    public int getBroj() {
        return broj;
    }

    /**
     * @param broj the broj to set
     */
    public void setBroj(int broj) {
        this.broj = broj;
    }

    /**
     * @return String return the komentar
     */
    public String getKomentar() {
        return komentar;
    }

    /**
     * @param komentar the komentar to set
     */
    public void setKomentar(String komentar) {
        this.komentar = komentar;
    }

}