package com.example.demo.Entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table( name = "rojenje")
public class Rojenje {

    public Rojenje(Kosnica kosnice, int brojmaticnjaka, Date starostmaticnjaka, String tipmaticnjaka, String komentar) {
        super();
        this.kosnice = kosnice;
        this.brojmaticnjaka = brojmaticnjaka;
        this.starostmaticnjaka = starostmaticnjaka;
        this.tipmaticnjaka = tipmaticnjaka;
        this.komentar = komentar;
    }

    @Id
    @GeneratedValue
    @Column( name = "rojenje_id", unique = true, nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn( name = "kosnica_id" )
    private Kosnica kosnice;

    @Column( name = "brojmaticnjaka")
    private int brojmaticnjaka;

    @Column( name = "starostmaticnjaka")
    private Date starostmaticnjaka;

    @Column ( name = "tipmaticnjaka")
    private String tipmaticnjaka;

    @Column ( name = "komentar")
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
     * @return int return the brojmaticnjaka
     */
    public int getBrojmaticnjaka() {
        return brojmaticnjaka;
    }

    /**
     * @param brojmaticnjaka the brojmaticnjaka to set
     */
    public void setBrojmaticnjaka(int brojmaticnjaka) {
        this.brojmaticnjaka = brojmaticnjaka;
    }

    /**
     * @return String return the starostmaticnjaka
     */
    public Date getStarostmaticnjaka() {
        return starostmaticnjaka;
    }

    /**
     * @param starostmaticnjaka the starostmaticnjaka to set
     */
    public void setStarostmaticnjaka(Date starostmaticnjaka) {
        this.starostmaticnjaka = starostmaticnjaka;
    }

    /**
     * @return String return the tipmaticnjaka
     */
    public String getTipmaticnjaka() {
        return tipmaticnjaka;
    }

    /**
     * @param tipmaticnjaka the tipmaticnjaka to set
     */
    public void setTipmaticnjaka(String tipmaticnjaka) {
        this.tipmaticnjaka = tipmaticnjaka;
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