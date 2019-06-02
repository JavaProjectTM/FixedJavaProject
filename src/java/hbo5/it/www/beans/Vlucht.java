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
public class Vlucht {
    
    private int id;
    private String code;
    private Date vertrekTijd;
    private Date aankomstTijd;
    private int vliegtuig_id;
    private int vertrekluchthaven_id;
    private int aankomstluchthaven_id;
    private VliegtuigType vliegtuigType;
    private Luchthaven vertrekLuchthaven;
    private Luchthaven aankomstLuchthaven;
    private Vliegtuig vliegtuig;
    public Vlucht(int id, String code, Date vertrekTijd, Date aankomstTijd, int vliegtuig_id, int vertrekluchthaven_id, int aankomstluchthaven_id) {
        this.id = id;
        this.code = code;
        this.vertrekTijd = vertrekTijd;
        this.aankomstTijd = aankomstTijd;
        this.vliegtuig_id = vliegtuig_id;
        this.vertrekluchthaven_id = vertrekluchthaven_id;
        this.aankomstluchthaven_id = aankomstluchthaven_id;
    }
    
    public Vlucht(int vliegtuig_id){
    this.vliegtuig_id = vliegtuig_id;
    }
    public Vlucht(){}

    public Vliegtuig getVliegtuig() {
        return vliegtuig;
    }

    public void setVliegtuig(Vliegtuig vliegtuig) {
        this.vliegtuig = vliegtuig;
    }
    
    public int getId() {
        return id;
    }

    public VliegtuigType getVliegtuigType() {
        return vliegtuigType;
    }

    public void setVliegtuigType(VliegtuigType vliegtuigType) {
        this.vliegtuigType = vliegtuigType;
    }

    public Luchthaven getVertrekLuchthaven() {
        return vertrekLuchthaven;
    }

    public void setVertrekLuchthaven(Luchthaven vertrekLuchthaven) {
        this.vertrekLuchthaven = vertrekLuchthaven;
    }

    public Luchthaven getAankomstLuchthaven() {
        return aankomstLuchthaven;
    }

    public void setAankomstLuchthaven(Luchthaven aankomstLuchthaven) {
        this.aankomstLuchthaven = aankomstLuchthaven;
    }
    

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getVertrekTijd() {
        return vertrekTijd;
    }

    public void setVertrekTijd(Date vertrekTijd) {
        this.vertrekTijd = vertrekTijd;
    }

    public Date getAankomstTijd() {
        return aankomstTijd;
    }

    public void setAankomstTijd(Date aankomstTijd) {
        this.aankomstTijd = aankomstTijd;
    }

    public int getVliegtuig_id() {
        return vliegtuig_id;
    }

    public void setVliegtuig_id(int vliegtuig_id) {
        this.vliegtuig_id = vliegtuig_id;
    }

    public int getVertrekluchthaven_id() {
        return vertrekluchthaven_id;
    }

    public void setVertrekluchthaven_id(int vertrekluchthaven_id) {
        this.vertrekluchthaven_id = vertrekluchthaven_id;
    }

    public int getAankomstluchthaven_id() {
        return aankomstluchthaven_id;
    }

    public void setAankomstluchthaven_id(int aankomstluchthaven_id) {
        this.aankomstluchthaven_id = aankomstluchthaven_id;
    }
    
    
    
}
