/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.beans;

import java.util.Date;

/**
 *
 * @author Kevin
 */
public class Boeking 
{
    int passagier_id;
    int id;
    int aantalVolwassenen;
    int aantalKinderen;
    int bagage;
    int Handbagage;
    String aankomst;
    Date datum;
    double Price;

    public Boeking(int passagier_id, int id, int aantalVolwassenen, int aantalKinderen, int bagage, int Handbagage, String aankomst, Date datum, double Price) {
        this.id = id;
        this.aantalVolwassenen = aantalVolwassenen;
        this.aantalKinderen = aantalKinderen;
        this.bagage = bagage;
        this.Handbagage = Handbagage;
        this.aankomst = aankomst;
        this.datum = datum;
        this.Price = Price;
        this.passagier_id=passagier_id;
    }

    public int getPassagier_id() {
        return passagier_id;
    }

    public void setPassagier_id(int passagier_id) {
        this.passagier_id = passagier_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAantalVolwassenen() {
        return aantalVolwassenen;
    }

    public void setAantalVolwassenen(int aantalVolwassenen) {
        this.aantalVolwassenen = aantalVolwassenen;
    }

    public int getAantalKinderen() {
        return aantalKinderen;
    }

    public void setAantalKinderen(int aantalKinderen) {
        this.aantalKinderen = aantalKinderen;
    }

    public int getBagage() {
        return bagage;
    }

    public void setBagage(int bagage) {
        this.bagage = bagage;
    }

    public int getHandbagage() {
        return Handbagage;
    }

    public void setHandbagage(int Handbagage) {
        this.Handbagage = Handbagage;
    }

    public String getAankomst() {
        return aankomst;
    }

    public void setAankomst(String aankomst) {
        this.aankomst = aankomst;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }
    
    
    
}
