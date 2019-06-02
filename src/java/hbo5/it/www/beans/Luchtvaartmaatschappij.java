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
public class Luchtvaartmaatschappij {
    
    private int id;
    private String luchtvaartNaam;

    public Luchtvaartmaatschappij(int id, String luchtvaartNaam) {
        this.id = id;
        this.luchtvaartNaam = luchtvaartNaam;
    }

    public Luchtvaartmaatschappij() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLuchtvaartNaam() {
        return luchtvaartNaam;
    }

    public void setLuchtvaartNaam(String luchtvaartNaam) {
        this.luchtvaartNaam = luchtvaartNaam;
    }
    
    
    
}
