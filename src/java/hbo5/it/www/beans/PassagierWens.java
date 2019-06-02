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
public class PassagierWens {
    
    private String beschrijving;
    private String soort;

    public PassagierWens(String beschrijving, String soort) {
        this.beschrijving = beschrijving;
        this.soort = soort;
    }

    public PassagierWens() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public String getSoort() {
        return soort;
    }

    public void setSoort(String soort) {
        this.soort = soort;
    }
    
    
            
    
}
