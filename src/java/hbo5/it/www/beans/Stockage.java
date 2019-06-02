/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.beans;

import java.util.Date;

/**
 *
 * @author Sven
 */
public class Stockage {
    
    private int id;
    private String reden;
    private Date vanDatum;
    private Date totDatum;
    private int vliegtuig_id;
    private int hangar_id;

    public Stockage(int id, String reden, Date vanDatum, Date totDatum, int vliegtuig_id, int hangar_id) {
        this.id = id;
        this.reden = reden;
        this.vanDatum = vanDatum;
        this.totDatum = totDatum;
        this.vliegtuig_id = vliegtuig_id;
        this.hangar_id = hangar_id;
    }
    public Stockage(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReden() {
        return reden;
    }

    public void setReden(String reden) {
        this.reden = reden;
    }

    public Date getVanDatum() {
        return vanDatum;
    }

    public void setVanDatum(Date vanDatum) {
        this.vanDatum = vanDatum;
    }

    public Date getTotDatum() {
        return totDatum;
    }

    public void setTotDatum(Date totDatum) {
        this.totDatum = totDatum;
    }

    public int getVliegtuig_id() {
        return vliegtuig_id;
    }

    public void setVliegtuig_id(int vliegtuig_id) {
        this.vliegtuig_id = vliegtuig_id;
    }

    public int getHangar_id() {
        return hangar_id;
    }

    public void setHangar_id(int hanger_id) {
        this.hangar_id = hangar_id;
    }
    
    
    
}
