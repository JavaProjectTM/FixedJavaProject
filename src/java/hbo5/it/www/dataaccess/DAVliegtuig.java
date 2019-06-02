/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataaccess;

import hbo5.it.www.beans.Vliegtuig;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
    
        public Vliegtuig getVliegtuigGegevensById(int id) {
        Vliegtuig VliegtuigGegevens = new Vliegtuig();

        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("SELECT * from Vliegtuig where id = ?");) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                VliegtuigGegevens.setId(resultSet.getInt("id"));
                VliegtuigGegevens.setVliegtuigType_id(resultSet.getInt("vliegtuigtype_id"));
                VliegtuigGegevens.setLuchtvaartMaatschappij_id(resultSet.getInt("luchtvaartmaatschappij_id"));
                    
                }
               
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return VliegtuigGegevens;
    }

//    CRUD OPERATIES
    //delete -- werkt alleen op alles aangezien luchthaven gekoppeld is aan andere dingen
    public boolean deleteVliegtuig(int id) {
        boolean resultaat = true;
        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("delete from vliegtuig "
                        + " where vliegtuig.id = ?");) {
            statement.setInt(1, id);
            statement.execute();
        } catch (Exception e) {
            resultaat = false;
            e.printStackTrace();
        }
        return resultaat;
    }

    public boolean insertVliegtuig(int typeId, int maatschappijId) {
        boolean resultaat = true;

        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("insert into vliegtuig (vliegtuigtype_id, luchtvaartmaatschappij_id) "
                        + "values (?,?)");) {
            statement.setInt(1, typeId);
            statement.setInt(2, maatschappijId);
        } catch (Exception e) {
            resultaat = false;
            e.printStackTrace();

        }
        return resultaat;
    }
     // Update
    public boolean updateVliegtuig(int id, int typeId, int maatschappijId) {
        boolean resultaat = true;

        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("update vliegtuig set vliegtuigtype_id=?, luchtvaartmaatschappij_id=? where id=?");) {
               statement.setInt(1, typeId);
               statement.setInt(2,maatschappijId);
               statement.setInt(3, id);
               
               statement.executeUpdate();
        } catch (Exception e) {
            resultaat = false;
            e.printStackTrace();
        }

        return resultaat;
    }
    
    
}
