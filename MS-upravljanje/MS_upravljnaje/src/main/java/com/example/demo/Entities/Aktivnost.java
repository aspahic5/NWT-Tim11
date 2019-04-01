package com.example.demo.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table( name = "aktivnost")
public class Aktivnost {

    public Aktivnost() {}
    public Aktivnost (String mjesec, String aktivnost, int uradjeno){
        super();
        this.mjesec = mjesec;
        this.aktivnost = aktivnost;
        this.uradjeno = uradjeno;
    }

    @Id
    @GeneratedValue
    @Column( name = "aktivnost_id",  unique = true, nullable = false)
    private int id;

    @Column ( name = "mjesec", nullable = false)
    @Pattern(regexp = "^[jJ]anuar|[Ff]ebruar|[Mm]art|[Aa]pril|[Mm]aj|[Jj]uni|[Jj]uli|[Aa][uv]gust|[Ss]eptembar|[Oo]ktobar|[Nn]ovembar|[Dd]ecembar$", message = "Neispravno unesen mjesec")
    private String mjesec;

    @Column ( name = "aktivnost", nullable = false)
    @Size(min = 10, message = "Tekst aktivnosti prekratak")
    private String aktivnost;
    
    @Column ( name = "uradjeno", nullable = false)
    private int uradjeno;


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
     * @return String return the mjesec
     */
    public String getMjesec() {
        return mjesec;
    }

    /**
     * @param mjesec the mjesec to set
     */
    public void setMjesec(String mjesec) {
        this.mjesec = mjesec;
    }

    /**
     * @return String return the aktivnost
     */
    public String getAktivnost() {
        return aktivnost;
    }

    /**
     * @param aktivnost the aktivnost to set
     */
    public void setAktivnost(String aktivnost) {
        this.aktivnost = aktivnost;
    }

    /**
     * @return int return the uradjeno
     */
    public int getUradjeno() {
        return uradjeno;
    }

    /**
     * @param uradjeno the uradjeno to set
     */
    public void setUradjeno(int uradjeno) {
        this.uradjeno = uradjeno;
    }

}