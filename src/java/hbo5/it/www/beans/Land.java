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
public class Land extends Luchthaven
{
private int id;
private String landnaam;

//<editor-fold desc="constructors">

    public Land(int id, String landnaam) {
        super(id);
        this.landnaam = landnaam;
    }

    public Land() {
        super();
    }
    
    
    //</editor-fold>
//<editor-fold desc="getters en setters">

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLandnaam() {
        return landnaam;
    }

    public void setLandnaam(String landnaam) {
        this.landnaam = landnaam;
    }
    //</editor-fold>
//<editor-fold desc="tostring">

    @Override
    public String toString() {
        return "Land{" + "id=" + id + ", landnaam=" + landnaam + '}';
    }
    //</editor-fold>
    
}
