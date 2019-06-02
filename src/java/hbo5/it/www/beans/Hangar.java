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
public class Hangar extends Stockage {
    
    private int id;
    private String hangarNaam;

    public Hangar(int id, String hangarNaam) {
        super();
        this.id = id;
        this.hangarNaam = hangarNaam;
    }
    public Hangar(int id){
        this.id=id;
    }

    public Hangar() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHangarNaam() {
        return hangarNaam;
    }

    public void setHangarNaam(String hangarNaam) {
        this.hangarNaam = hangarNaam;
    }
    
    
    
    
}
