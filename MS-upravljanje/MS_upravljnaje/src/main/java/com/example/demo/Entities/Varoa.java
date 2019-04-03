package com.example.demo.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import java.sql.Date;

import javax.persistence.Column;

@Entity
@Table(name = "varoa")
public class Varoa {

    public Varoa(){}
    public Varoa(Kosnica kosnice, int broj, Date primjecena, String komentar){
        super();
        this.kosnice = kosnice;
        this.broj = broj;
        this.primjecena = primjecena;
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
    @Min(value = 1, message = "Broj varoe mora biti veći od nule.")
    private int broj;

    @Column(name = "primjecena")
    private Date primjecena;

    @Column(name = "komentar")
    @Size(min = 10, message = "Prekratak komentar.")
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
     * @return Kosnica return the kosnice
     */
    public Kosnica getKosnice() {
        return kosnice;
    }

    /**
     * @param kosnice the kosnice to set
     */
    public void setKosnice(Kosnica kosnice) {
        this.kosnice = kosnice;
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
     * @return Date return the primjecena
     */
    public Date getPrimjecena() {
        return primjecena;
    }

    /**
     * @param primjecena the primjecena to set
     */
    public void setPrimjecena(Date primjecena) {
        this.primjecena = primjecena;
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