/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.beans;

/**
 *
 * @author c1045370
 */
public class Vliegtuigklasse extends Passagier
{
private int id;
private String klassenaam;

//<editor-fold desc="constructors">

    public Vliegtuigklasse(int id, String klassenaam) {
        super();
        this.id = id;
        this.klassenaam = klassenaam;
    }

    public Vliegtuigklasse() {
    }
    public Vliegtuigklasse(int id){
    }
    
//</editor-fold>
//<editor-fold desc="getters en setters">

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKlassenaam() {
        return klassenaam;
    }

    public void setKlassenaam(String klassenaam) {
        this.klassenaam = klassenaam;
    }
    //</editor-fold>
//<editor-fold desc="tostring">

    @Override
    public String toString() {
        return "Vliegtuigklasse{" + "id=" + id + ", klassenaam=" + klassenaam + '}';
    }
    //</editor-fold>
}
 