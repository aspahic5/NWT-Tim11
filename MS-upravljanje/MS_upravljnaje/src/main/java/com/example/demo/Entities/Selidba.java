package com.example.demo.Entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "selidba")
public class Selidba {

    public Selidba(int brojkosnica, String lokacija, Date pocetak, Date kraj, double dobit) {
        super();
        this.brojkosnica = brojkosnica;
        this.lokacija = lokacija;
        this.pocetak = pocetak;
        this.kraj = kraj;
        this.dobit = dobit;
    }

    @Id
    @GeneratedValue
    @Column( name = "selidba_id")
    private int id;

    @Column( name = "brojkosnica")
    private int brojkosnica;

    @Column( name = "lokacija")
    private String lokacija;

    @Column( name = "pocetak")
    private Date pocetak;

    @Column( name = "kraj")
    private Date kraj;

    @Column( name = "dobit")
    private double dobit;

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
     * @return int return the brojkosnica
     */
    public int getBrojkosnica() {
        return brojkosnica;
    }

    /**
     * @param brojkosnica the brojkosnica to set
     */
    public void setBrojkosnica(int brojkosnica) {
        this.brojkosnica = brojkosnica;
    }

    /**
     * @return String return the lokacija
     */
    public String getLokacija() {
        return lokacija;
    }

    /**
     * @param lokacija the lokacija to set
     */
    public void setLokacija(String lokacija) {
        this.lokacija = lokacija;
    }

    /**
     * @return String return the pocetak
     */
    public Date getPocetak() {
        return pocetak;
    }

    /**
     * @param pocetak the pocetak to set
     */
    public void setPocetak(Date pocetak) {
        this.pocetak = pocetak;
    }

    /**
     * @return String return the kraj
     */
    public Date getKraj() {
        return kraj;
    }

    /**
     * @param kraj the kraj to set
     */
    public void setKraj(Date kraj) {
        this.kraj = kraj;
    }

    /**
     * @return String return the dobit
     */
    public double getDobit() {
        return dobit;
    }

    /**
     * @param dobit the dobit to set
     */
    public void setDobit(double dobit) {
        this.dobit = dobit;
    }

}