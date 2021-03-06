package com.example.demo.Entities;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table( name = "kosnica")
public class Kosnica {

    public Kosnica() {}
    public Kosnica(int vlasnik_id, Date maticagod, int brojramova, int brojnastavaka, double kolstimulansa, String tipstimulansa, int brojhanemanki, String komentar, Kosnica kosnice, Set<Aktivnost> aktivnosti, Set<Selidba> selidbe){
        super(); 
        this.vlasnik_id = vlasnik_id;
        this.maticagod = maticagod;
        this.brojramova = brojramova;
        this.brojnastavaka = brojnastavaka;
        this.kolstimulansa = kolstimulansa;
        this.tipstimulansa = tipstimulansa;
        this.brojhanemanki = brojhanemanki;
        this.komentar = komentar;
        this.kosnice = kosnice;
        this.selidbe = selidbe;
        this.aktivnosti = aktivnosti;
    }

	@Id
    @GeneratedValue
    @Column(name = "kosnica_id", unique = true, nullable = false)
    private int id;

    @Column( name = "vlasnik_id", unique = false, nullable = false)
    private int vlasnik_id;

    @ManyToOne
    @JoinColumn (name = "nastalaodkosnice_id", referencedColumnName = "kosnica_id", nullable = true)
    private Kosnica kosnice;

    @Column ( name = "maticagod", nullable = false)
    private Date maticagod;

    @Column ( name = "brojramova", nullable = false)
    @Min(value = 1, message = "Broj ramova mora biti veći od nule")
    private int brojramova;

    @Column ( name = "brojnastavaka", nullable = false)
    @Min(value = 0, message = "Broj nastavaka ne može biti manji od nule")
    private int brojnastavaka;

    @Column ( name = "kolstimulansa", nullable = false)
    @Min(value = 0, message = "Količina stimulansa ne može biti manja od nule")
    private double kolstimulansa;

    @Column ( name = "tipstimulansa", nullable = false)
    @Size(min = 0, max = 20)
    private String tipstimulansa;

    @Column ( name = "brojhanemanki", nullable = false)
    @Min(value = 0, message = "Broj hanemanki ne može biti manji od nule")
    private int brojhanemanki;

    @Column ( name = "komentar", nullable = false)
    private String komentar;  

    @ManyToMany
    @Column(nullable = true)
    Set<Selidba> selidbe;

    @ManyToMany
    @Column(nullable = true)
    Set<Aktivnost> aktivnosti;


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

    public void setSelidba(Selidba selidba) {
        selidbe.add(selidba);
    }

    public void setAktivnosti(Aktivnost aktivnost) {
        aktivnosti.add(aktivnost);
    }

    /**
     * @return int return the vlasnik_id
     */
    public int getVlasnik_id() {
        return vlasnik_id;
    }

    /**
     * @param vlasnik_id the vlasnik_id to set
     */
    public void setVlasnik_id(int vlasnik_id) {
        this.vlasnik_id = vlasnik_id;
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
     * @return Date return the maticagod
     */
    public Date getMaticagod() {
        return maticagod;
    }

    /**
     * @param maticagod the maticagod to set
     */
    public void setMaticagod(Date maticagod) {
        this.maticagod = maticagod;
    }

    /**
     * @return int return the brojramova
     */
    public int getBrojramova() {
        return brojramova;
    }

    /**
     * @param brojramova the brojramova to set
     */
    public void setBrojramova(int brojramova) {
        this.brojramova = brojramova;
    }

    /**
     * @return int return the brojnastavaka
     */
    public int getBrojnastavaka() {
        return brojnastavaka;
    }

    /**
     * @param brojnastavaka the brojnastavaka to set
     */
    public void setBrojnastavaka(int brojnastavaka) {
        this.brojnastavaka = brojnastavaka;
    }

    /**
     * @return double return the kolstimulansa
     */
    public double getKolstimulansa() {
        return kolstimulansa;
    }

    /**
     * @param kolstimulansa the kolstimulansa to set
     */
    public void setKolstimulansa(double kolstimulansa) {
        this.kolstimulansa = kolstimulansa;
    }

    /**
     * @return String return the tipstimulansa
     */
    public String getTipstimulansa() {
        return tipstimulansa;
    }

    /**
     * @param tipstimulansa the tipstimulansa to set
     */
    public void setTipstimulansa(String tipstimulansa) {
        this.tipstimulansa = tipstimulansa;
    }

    /**
     * @return int return the brojhanemanki
     */
    public int getBrojhanemanki() {
        return brojhanemanki;
    }

    /**
     * @param brojhanemanki the brojhanemanki to set
     */
    public void setBrojhanemanki(int brojhanemanki) {
        this.brojhanemanki = brojhanemanki;
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