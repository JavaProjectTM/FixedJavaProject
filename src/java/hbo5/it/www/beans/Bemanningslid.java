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
public class Bemanningslid extends Persoon{
    
    private int id;
    private int luchtvaartMaatschappij_id;
    private int persoon_id;
    private int functie_id;

   
    public Bemanningslid(int functie_id){
    this.functie_id=functie_id;}

    public Bemanningslid(int id, int luchtvaartMaatschappij_id, int persoon_id, int functie_id) {
        super(persoon_id);
        this.id = id;
        this.luchtvaartMaatschappij_id = luchtvaartMaatschappij_id;
        this.functie_id = functie_id;
    }
    public Bemanningslid() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLuchtvaartMaatschappij_id() {
        return luchtvaartMaatschappij_id;
    }

    public void setLuchtvaartMaatschappij_id(int luchtvaartMaatschappij_id) {
        this.luchtvaartMaatschappij_id = luchtvaartMaatschappij_id;
    }

    public int getPersoon_id() {
        return persoon_id;
    }

    public void setPersoon_id(int persoon_id) {
        this.persoon_id = persoon_id;
    }

    public int getFunctie_id() {
        return functie_id;
    }

    public void setFunctie_id(int functie_id) {
        this.functie_id = functie_id;
    }

    
    
    
}
