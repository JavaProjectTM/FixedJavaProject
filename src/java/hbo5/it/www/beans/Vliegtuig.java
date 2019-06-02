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
public class Vliegtuig extends Vlucht{
    
    private int id;
    private int vliegtuigType_id;
    private int luchtvaartMaatschappij_id;

    public Vliegtuig(int id, int vliegtuigType_id, int luchtvaartMaatschappij_id) {
        super(id);
        this.vliegtuigType_id = vliegtuigType_id;
        this.luchtvaartMaatschappij_id = luchtvaartMaatschappij_id;
    }

    public Vliegtuig(int vliegtuigType_id){
        this.vliegtuigType_id=vliegtuigType_id;
    }
    public Vliegtuig() {
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVliegtuigType_id() {
        return vliegtuigType_id;
    }

    public void setVliegtuigType_id(int vliegtuigType_id) {
        this.vliegtuigType_id = vliegtuigType_id;
    }

    public int getLuchtvaartMaatschappij_id() {
        return luchtvaartMaatschappij_id;
    }

    public void setLuchtvaartMaatschappij_id(int luchtvaartMaatschappij) {
        this.luchtvaartMaatschappij_id = luchtvaartMaatschappij;
    }
    
    
    
    
}
