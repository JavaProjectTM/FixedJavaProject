/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.beans;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author Sven
 */
public class CrewPlanning {
 
    private String beschrijving;
    private Date vertrek;
    private String vluchtCode;
    private Date aankomstDatum;
    private Time vertrekTijd;

    public CrewPlanning(String beschrijving, Date vertrek, String vluchtCode, Date aankomstDatum, Time vertrekTijd) {
        this.beschrijving = beschrijving;
        this.vertrek = vertrek;
        this.vluchtCode = vluchtCode;
        this.aankomstDatum = aankomstDatum;
        this.vertrekTijd = vertrekTijd;
    }

    public CrewPlanning() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public Date getVertrek() {
        return vertrek;
    }

    public void setVertrek(Date vertrek) {
        this.vertrek = vertrek;
    }

    public String getVluchtCode() {
        return vluchtCode;
    }

    public void setVluchtCode(String vluchtCode) {
        this.vluchtCode = vluchtCode;
    }

    public Date getAankomstDatum() {
        return aankomstDatum;
    }

    public void setAankomstDatum(Date aankomstDatum) {
        this.aankomstDatum = aankomstDatum;
    }

    public Time getVertrekTijd() {
        return vertrekTijd;
    }

    public void setVertrekTijd(Time vertrekTijd) {
        this.vertrekTijd = vertrekTijd;
    }
    
    
    
    
    
    
}
