package com.engeto.lekce12.entity;

import javax.persistence.*;


// entita definuje jak ten objekt vypada
@Entity
@Table(name="ucitel")
public class UcitelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //@Column(name="jmeno")  //pokud se sloupec jmenuje jinak lze přejmenovat, defaultně stačí bez
    @Column
    private String jmeno;

    @Column
    private String prijmeni;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }


}
