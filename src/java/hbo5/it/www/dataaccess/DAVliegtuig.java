/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataaccess;

import hbo5.it.www.beans.Vliegtuig;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Kevin
 */
public class DAVliegtuig {
    
    private final String url, login, password;

    public DAVliegtuig(String url, String login, String password, String driver) throws ClassNotFoundException {
        Class.forName(driver);
        this.url = url;
        this.login = login;
        this.password = password;
    }

    public Vliegtuig getVliegtuig() {
         Vliegtuig  vliegtuig = null;
        
         try (
             Connection connection = DriverManager.getConnection(url, login, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM sportcentrum where id = 1");) 
            {
            if (resultSet.next()) {
                 vliegtuig = new Vliegtuig();
                 vliegtuig.setId(resultSet.getInt("id"));
                 //moet aangepast worden in de javaklasse "Vliegtuig"
                 vliegtuig.setVliegtuigType_id(resultSet.getInt("vliegtuigtype_id"));
                 vliegtuig.setLuchtvaartMaatschappij_id(resultSet.getInt("luchtvaartMaatschappij_id"));
                 }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  vliegtuig;
    }
    
        public ArrayList<Vliegtuig> getVliegtuigGegevens() {
          ArrayList<Vliegtuig> VliegtuigGegevens = new ArrayList<>();
        
         try (
             Connection connection = DriverManager.getConnection(url, login, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * from vliegtuig");)
            {
            while (resultSet.next()) {
                Vliegtuig vliegtuig = new Vliegtuig();
                vliegtuig.setId(resultSet.getInt("id"));
                vliegtuig.setLuchtvaartMaatschappij_id(resultSet.getInt("luchtvaartmaatschappij_id"));
                vliegtuig.setVliegtuigType_id(resultSet.getInt("vliegtuigtype_id"));
                VliegtuigGegevens.add(vliegtuig);
                            }
        } catch (Exception e) {
            e.printStackTrace();
        }
         return VliegtuigGegevens  ;
    }
    
    
    
    
}
