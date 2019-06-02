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
public class Passagier extends Persoon
{
    
    private int id;
    private int ingeschreven;
    private int ingecheckt;
    private int klasse_id;
    private int persoon_id;
    private int vlucht_id;
    private String plaats;
    private Vlucht vlucht;
    private Persoon persoon;

    
    //<editor-fold desc="constructors">
    public Passagier(int id, int ingeschreven, int ingecheckt, int klasse_id, int persoon_id, int vlucht_id, String plaats) {
        super(persoon_id);
        this.id = id;
        this.ingeschreven = ingeschreven;
        this.ingecheckt = ingecheckt;
        this.klasse_id=klasse_id;
        this.vlucht_id = vlucht_id;
        this.plaats = plaats;
    }

    public Passagier() {
    }
//</editor-fold>
    //<editor-fold desc="getters en setters">

    public Vlucht getVlucht() {
        return vlucht;
    }

    public void setVlucht(Vlucht vlucht) {
        this.vlucht = vlucht;
    }

    public Persoon getPersoon() {
        return persoon;
    }

    public void setPersoon(Persoon persoon) {
        this.persoon = persoon;
    }
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIngeschreven() {
        return ingeschreven;
    }

    public void setIngeschreven(int ingeschreven) {
        this.ingeschreven = ingeschreven;
    }

    public int getIngecheckt() {
        return ingecheckt;
    }

    public void setIngecheckt(int ingecheckt) {
        this.ingecheckt = ingecheckt;
    }

    public int getKlasse_id() {
        return klasse_id;
    }

    public void setKlasse_id(int klasse_id) {
        this.klasse_id = klasse_id;
    }

    public int getPersoon_id() {
        return persoon_id;
    }

    public void setPersoon_id(int persoon_id) {
        this.persoon_id = persoon_id;
    }

    public int getVlucht_id() {
        return vlucht_id;
    }

    public void setVlucht_id(int vlucht_id) {
        this.vlucht_id = vlucht_id;
    }

    public String getPlaats() {
        return plaats;
    }

    public void setPlaats(String plaats) {
        this.plaats = plaats;
    }
    //</editor-fold>
    //<editor-fold desc="toString">
    @Override
    public String toString() {
        return "Passagier{" + "id=" + id + ", ingeschreven=" + ingeschreven + ", ingecheckt=" + ingecheckt + ", klasse_id=" + klasse_id + ", persoon_id=" + persoon_id + ", vlucht_id=" + vlucht_id + ", plaats=" + plaats + '}';
    }
    //</editor-fold>
}
