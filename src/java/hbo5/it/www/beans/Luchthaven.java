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
public class Luchthaven extends Vlucht
{
    private int id;
    private String luchthavennaam;
    private String stad;
    private int land_id;
    
    //<editor-fold desc="constructors">

    public Luchthaven(int id, String luchthavennaam, String stad, int land_id) {
        super(id);
        this.luchthavennaam = luchthavennaam;
        this.stad = stad;
        this.land_id = land_id;
    }

    public Luchthaven() {
    }
    

    public Luchthaven(int land_id) {
        super();
        this.land_id=land_id;
    }
    //</editor-fold>
    //<editor-fold desc="getters en setters">

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLuchthavennaam() {
        return luchthavennaam;
    }

    public void setLuchthavennaam(String luchthavennaam) {
        this.luchthavennaam = luchthavennaam;
    }

    public String getStad() {
        return stad;
    }

    public void setStad(String stad) {
        this.stad = stad;
    }

    public int getLand_id() {
        return land_id;
    }

    public void setLand_id(int land_id) {
        this.land_id = land_id;
    }
    //</editor-fold>
    //<editor-fold desc="tostring">

    @Override
    public String toString() {
        return "Luchthaven{" + "id=" + id + ", luchthavennaam=" + luchthavennaam + ", stad=" + stad + ", land_id=" + land_id + '}';
    }
    //</editor-fold>





}

