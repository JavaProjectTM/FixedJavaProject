/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataaccess;

import hbo5.it.www.beans.Luchthaven;
import hbo5.it.www.beans.Luchtvaartmaatschappij;
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
public class DALuchtvaartmaatschappij 
{
    private final String url, login, password;
    private int teller = 20;

    public DALuchtvaartmaatschappij(String url, String login, String password, String driver) throws ClassNotFoundException {
        Class.forName(driver);
        this.url = url;
        this.login = login;
        this.password = password;
    }

    public Luchtvaartmaatschappij getLuchtvaartmaatschappij() {
         Luchtvaartmaatschappij  luchtvaartmaatschappij = null;
        
         try (
             Connection connection = DriverManager.getConnection(url, login, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM sportcentrum where id = 1");) 
            {
            if (resultSet.next()) {
                 luchtvaartmaatschappij = new Luchtvaartmaatschappij();
                 luchtvaartmaatschappij.setId(resultSet.getInt("id"));
                 luchtvaartmaatschappij.setLuchtvaartNaam(resultSet.getString("luchtvaartnaam"));

                 }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  luchtvaartmaatschappij;
    }
    
    public ArrayList<Luchtvaartmaatschappij> getLuchtvaartmaatschappijGegevens() {
          ArrayList<Luchtvaartmaatschappij> LuchtvaartmaatschappijGegevens = new ArrayList<>();
        
         try (
             Connection connection = DriverManager.getConnection(url, login, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * from luchtvaartmaatschappij");)
            {
            while (resultSet.next()) {
                Luchtvaartmaatschappij luchtvaartmaatschappij = new Luchtvaartmaatschappij();
                luchtvaartmaatschappij.setId(resultSet.getInt("id"));
                luchtvaartmaatschappij.setLuchtvaartNaam(resultSet.getString("luchtvaartnaam"));
                LuchtvaartmaatschappijGegevens.add(luchtvaartmaatschappij);
                            }
        } catch (Exception e) {
            e.printStackTrace();
        }
         return LuchtvaartmaatschappijGegevens  ;
    }
    
    public String getLuchtvaartById(int id) {
            String luchtvaartNaam = null;

        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM LUCHTVAARTMAATSCHAPPIJ WHERE ID like ?");) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                Luchtvaartmaatschappij luchtvaartmaatschappij = new Luchtvaartmaatschappij();
                luchtvaartmaatschappij.setLuchtvaartNaam(resultSet.getString("luchtvaartnaam"));
                luchtvaartNaam = luchtvaartmaatschappij.getLuchtvaartNaam();
            }
        } catch (Exception e) {
            {
                e.printStackTrace();
            }
        }
            return luchtvaartNaam;
    }
    public Luchtvaartmaatschappij getLuchtHavenGegevensById(int id) {
        Luchtvaartmaatschappij LuchtHavenmaatschappijGegevens = new Luchtvaartmaatschappij();

        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("SELECT * from luchtvaartmaatschappij where id = ?");) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                LuchtHavenmaatschappijGegevens.setId(resultSet.getInt("id"));
                LuchtHavenmaatschappijGegevens.setLuchtvaartNaam(resultSet.getString("LUCHTVAARTNAAM"));
                Luchtvaartmaatschappij test = LuchtHavenmaatschappijGegevens;
                }
               
        } catch (Exception e) {
            e.printStackTrace();
        }
        return LuchtHavenmaatschappijGegevens;
    }

//    CRUD OPERATIES
    //delete -- werkt alleen op alles aangezien luchthaven gekoppeld is aan andere dingen
    public boolean deleteLuchthavenmaatschappij(int id) {
        boolean resultaat = true;
        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("delete from luchtvaartmaatschappij "
                        + " where id=?");) {
            statement.setInt(1, id);
            statement.execute();
        } catch (Exception e) {
            resultaat = false;
            e.printStackTrace();
        }
        return resultaat;
    }

    public boolean insertLuchthavenMaatschappij(int id, String luchtvaartNaam) {
        boolean resultaat = true;
        id = teller;
        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                //auto increment iets met seq.nextvalue.
                PreparedStatement statement = connection.prepareStatement("INSERT INTO luchtvaartmaatschappij"
                        + "(ID, LUCHTVAARTNAAM) VALUES"
                        + "(?,?)");) {
            
                                                                                                  
            statement.setInt(1, id);
            statement.setString(2, luchtvaartNaam);
            
            statement.executeUpdate();
        } catch (Exception e) {
            resultaat = false;
            e.printStackTrace();

        }
        teller++;
        return resultaat;
        
    }
     // Update
    public boolean updateLuchthavenMaatschappij(int id, String luchtvaartNaam) {
        boolean resultaat = true;

        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("update luchtvaartmaatschappij set luchtvaartnaam=? where id=?");) {
               statement.setString(1, luchtvaartNaam);
               statement.setInt(2, id);
               
               statement.executeUpdate();
        } catch (Exception e) {
            resultaat = false;
            e.printStackTrace();
        }

        return resultaat;
    }
    
}
