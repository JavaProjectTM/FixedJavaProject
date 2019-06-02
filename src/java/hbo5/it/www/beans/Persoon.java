/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

 */

package hbo5.it.www.beans;

import java.sql.Date;

/**
 *
 * @author c1045370
 */
public class Persoon 
{
    private int id;
    private String voornaam;
    private String familienaam;
    private String huisnummer;
    private String straat;
    private String postcode;
    private String woonplaats;
    private String land;
    private Date geboortedatum;
    private String login;
    private String paswoord;
    private char soort;
    
    //<editor-fold desc="constructors">

    public Persoon(int id, String voornaam, String familienaam, String huisnummer, String straat, String postcode, String woonplaats, String land, Date geboortedatum, String login, String paswoord, char soort) {
        this.id = id;
        this.voornaam = voornaam;
        this.familienaam = familienaam;
        this.huisnummer = huisnummer;
        this.straat = straat;
        this.postcode = postcode;
        this.woonplaats = woonplaats;
        this.land = land;
        this.geboortedatum = geboortedatum;
        this.login = login;
        this.paswoord = paswoord;
        this.soort = soort;
    }
    public Persoon() {
    }

    public Persoon(int id) {
        this.id = id;
    }
    
    
    //</editor-fold>
    //<editor-fold desc="getters en setters">

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getFamilienaam() {
        return familienaam;
    }

    public void setFamilienaam(String familienaam) {
        this.familienaam = familienaam;
    }

    public String getHuisnummer() {
        return huisnummer;
    }

    public void setHuisnummer(String huisnummer) {
        this.huisnummer = huisnummer;
    }

    public String getStraat() {
        return straat;
    }

    public void setStraat(String straat) {
        this.straat = straat;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getWoonplaats() {
        return woonplaats;
    }

    public void setWoonplaats(String woonplaats) {
        this.woonplaats = woonplaats;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public Date getGeboortedatum() {
        return geboortedatum;
    }

    public void setGeboortedatum(Date geboortedatum) {
        this.geboortedatum = geboortedatum;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPaswoord() {
        return paswoord;
    }

    public void setPaswoord(String paswoord) {
        this.paswoord = paswoord;
    }

    public char getSoort() {
        return soort;
    }

    public void setSoort(char soort) {
        this.soort = soort;
    }
    
    //</editor-fold>
//<editor-fold desc="tostring">

    @Override
    public String toString() {
        return "Persoon{" + "id=" + id + ", voornaam=" + voornaam + ", familienaam=" + familienaam + ", huisnummer=" + huisnummer + ", straat=" + straat + ", postcode=" + postcode + ", woonplaats=" + woonplaats + ", land=" + land + ", geboortedatum=" + geboortedatum + ", login=" + login + ", paswoord=" + paswoord + ", soort=" + soort + '}';
    }
    //</editor-fold>
}
