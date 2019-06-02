/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataaccess;

import  hbo5.it.www.beans.Functie;
import hbo5.it.www.beans.Luchthaven;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Kevin
 */
public class DAFunctie {
    private final String url, login, password;

    public DAFunctie(String url, String login, String password, String driver) throws ClassNotFoundException {
        Class.forName(driver);
        this.url = url;
        this.login = login;
        this.password = password;
    }

    public Functie getFunctie() {
        Functie functie = null;
        
         try (
             Connection connection = DriverManager.getConnection(url, login, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM functie");) 
            {
            if (resultSet.next()) {
                functie = new Functie();
                functie.setId(resultSet.getInt("id"));
                functie.setFunctieNaam(resultSet.getString("functieNaam"));
                functie.setOmschrijving(resultSet.getString("Omschrijving"));
                            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return functie;
}

    
    public ArrayList<Functie> getFunctieGegevens() {
        ArrayList<Functie> FunctieGegevens = new ArrayList<>();

        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * from functie ORDER BY id");) {
            while (resultSet.next()) {
                Functie functie = new Functie();
                functie.setId(resultSet.getInt("id"));
                functie.setFunctieNaam(resultSet.getString("functienaam"));
                functie.setOmschrijving(resultSet.getString("omschrijving"));
                
                FunctieGegevens.add(functie);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return FunctieGegevens;
    }
    
    }
    
    
    
    

