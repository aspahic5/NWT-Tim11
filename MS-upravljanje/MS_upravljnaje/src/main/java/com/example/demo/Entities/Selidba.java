package com.example.demo.Entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

@Entity
@Table( name = "selidba")
public class Selidba {

    public Selidba() {}
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
    @Min(value = 1, message = "Neispravan broj košnica.")
    private int brojkosnica;

    @Column( name = "lokacija")
    @Size(min = 3, message = "Neispravno unešena lokacija.")
    private String lokacija;

    @Column( name = "pocetak")
    //@PastOrPresent( message = "Neispravno unešen datum početka selidbe.")
    private Date pocetak;

    @Column( name = "kraj")
    //@FutureOrPresent( message = "Neispravno unešen datum kraja selidbe.")
    private Date kraj;

    @Column( name = "dobit")
    @Min( value = 0, message = "Vrijednost dobiti mora biti pozitivna.")
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