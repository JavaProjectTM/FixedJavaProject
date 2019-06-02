/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.beans;

/**
 *
 * @author Sven
 */
public class Functie extends Bemanningslid{
    
    private int id;
    private String functieNaam;
    private String omschrijving;

    public Functie(int id, String functieNaam, String omschrijving) {
        super(id);
        this.functieNaam = functieNaam;
        this.omschrijving = omschrijving;
    }
    
     public Functie() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFunctieNaam() {
        return functieNaam;
    }

    public void setFunctieNaam(String functieNaam) {
        this.functieNaam = functieNaam;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }
    
    
    
            
    
}
