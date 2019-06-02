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
public class VluchtBemanning extends Bemanningslid
{
private int id;
private String taak;
private int bemanningslid_id;
private int vlucht_id;
private Vlucht vlucht = null;

//<editor-fold desc="constructors">

    public VluchtBemanning(int id, String taak, int bemanningslid_id, int vlucht_id) {
        super();
        this.id = id;
        this.taak = taak;
        this.bemanningslid_id = bemanningslid_id;
        this.vlucht_id = vlucht_id;
    }

    public VluchtBemanning() {
    }
    //</editor-fold>
//<editor-fold desc="getters en setters">

    public Vlucht getVlucht() {
        return vlucht;
    }

    public void setVlucht(Vlucht vlucht) {
        this.vlucht = vlucht;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaak() {
        return taak;
    }

    public void setTaak(String taak) {
        this.taak = taak;
    }

    public int getBemanningslid_id() {
        return bemanningslid_id;
    }

    public void setBemanningslid_id(int bemanningslid_id) {
        this.bemanningslid_id = bemanningslid_id;
    }

    public int getVlucht_id() {
        return vlucht_id;
    }

    public void setVlucht_id(int vlucht_id) {
        this.vlucht_id = vlucht_id;
    }

//</editor-fold>
//<editor-fold desc="to-string">

    @Override
    public String toString() {
        return "VluchtBemanning{" + "id=" + id + ", taak=" + taak + ", bemanningslid_id=" + bemanningslid_id + ", vlucht_id=" + vlucht_id + '}';
    }
    //</editor-fold>

}
