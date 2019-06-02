/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataaccess;
import  hbo5.it.www.beans.Bemanningslid;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author Kevin
 */
public class DABemanningslid {
    
    private final String url, login, password;

    public DABemanningslid(String url, String login, String password, String driver) throws ClassNotFoundException {
        Class.forName(driver);
        this.url = url;
        this.login = login;
        this.password = password;
    }

    public Bemanningslid getBemanningslid() {
        Bemanningslid bemanningslid = null;
        
         try (
             Connection connection = DriverManager.getConnection(url, login, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM sportcentrum where id = 1");) 
            {
            if (resultSet.next()) {
                bemanningslid = new Bemanningslid();
                bemanningslid.setId(resultSet.getInt("id"));
                bemanningslid.setLuchtvaartMaatschappij_id(resultSet.getInt("luchtvaartMaatschappij_id"));
                bemanningslid.setPersoon_id(resultSet.getInt("persoon_id"));
                bemanningslid.setFunctie_id(resultSet.getInt("functie_id"));
                            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bemanningslid;
    }
    
    public Bemanningslid getBemanningslidGegevensById(int id) {
        Bemanningslid BemanningslidGegevens = new Bemanningslid();

        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("SELECT * from Bemanningslid where id = ?");) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                BemanningslidGegevens.setId(resultSet.getInt("id"));
                BemanningslidGegevens.setLuchtvaartMaatschappij_id(resultSet.getInt("vliegtuigtype_id"));
                BemanningslidGegevens.setFunctie_id(resultSet.getInt("functie_id"));                
                BemanningslidGegevens.setPersoon_id(resultSet.getInt("persoon_id"));
                }
               
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return BemanningslidGegevens;
    }

//    CRUD OPERATIES
    //delete -- werkt alleen op alles aangezien luchthaven gekoppeld is aan andere dingen
    public boolean deleteBemanningslid(int id) {
        boolean resultaat = true;
        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("delete from bemanningslid "
                        + " where bemanningslid.id = ?");) {
            statement.setInt(1, id);
            statement.execute();
        } catch (Exception e) {
            resultaat = false;
            e.printStackTrace();
        }
        return resultaat;
    }

    public boolean insertBemanningslid(int functieId, int maatschappijId, int persoonId) {
        boolean resultaat = true;

        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("insert into bemanningslid (luchtvaartmaatschappij_id, persoon_id, functie_id) "
                        + "values (?,?,?)");) {
            statement.setInt(1, maatschappijId);
            statement.setInt(2, persoonId);          
            statement.setInt(3, functieId);
        } catch (Exception e) {
            resultaat = false;
            e.printStackTrace();

        }
        return resultaat;
    }
     // Update
    public boolean updateBemanningslid(int id, int functieId, int maatschappijId, int persoonId) {
        boolean resultaat = true;

        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("update bemanningslid set luchtvaartmaatschappij_id=?, functie_id=?, persoon_id=? where id=?");) {
               statement.setInt(1, maatschappijId);
               statement.setInt(2, functieId);
               statement.setInt(3, persoonId);
               statement.setInt(3, id);
               
               statement.executeUpdate();
        } catch (Exception e) {
            resultaat = false;
            e.printStackTrace();
        }

        return resultaat;
    }
    
    
}
