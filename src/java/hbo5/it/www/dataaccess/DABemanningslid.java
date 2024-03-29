/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataaccess;
import  hbo5.it.www.beans.Bemanningslid;
import hbo5.it.www.beans.Hangar;
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
public class DABemanningslid {
    
    private final String url, login, password;
    private int teller = 20;
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
                BemanningslidGegevens.setLuchtvaartMaatschappij_id(resultSet.getInt("luchtvaartmaatschappij_id"));
                BemanningslidGegevens.setFunctie_id(resultSet.getInt("persoon_id"));                
                BemanningslidGegevens.setPersoon_id(resultSet.getInt("functie_id"));
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

    public boolean insertBemanningslid(int id,int functieId, int maatschappijId, int persoonId) {
        boolean resultaat = true;
        id = teller;
        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("insert into bemanningslid (id, luchtvaartmaatschappij_id, persoon_id, functie_id) "
                        + "values (?,?,?,?)");) {
            statement.setInt(1, id);
            statement.setInt(2, maatschappijId);
            statement.setInt(3, persoonId);          
            statement.setInt(4, functieId);
            statement.executeUpdate();
        } catch (Exception e) {
            resultaat = false;
            e.printStackTrace();

        }
        teller++;
        return resultaat;
    }
     // Update
    public boolean updateBemanningslid(int id, int functieId, int maatschappijId, int persoonId) {
        boolean resultaat = true;

        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("update bemanningslid set luchtvaartmaatschappij_id=?, persoon_id=?, funcie_id=? where id=?");) {
               
               statement.setInt(1, maatschappijId);
               statement.setInt(2, persoonId);
               statement.setInt(3, functieId);
               statement.setInt(3, id);
               statement.executeUpdate();
        } catch (Exception e) {
            resultaat = false;
            e.printStackTrace();
        }

        return resultaat;
    }

    
    public ArrayList<Bemanningslid> getBemanningsLeden() {
          ArrayList<Bemanningslid> bemanningGegevens = new ArrayList<>();
        
         try (
             Connection connection = DriverManager.getConnection(url, login, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * from bemanningslid");)
            {
            while (resultSet.next()) {
                Bemanningslid bemanningslid = new Bemanningslid();
                bemanningslid.setId(resultSet.getInt("id"));
                bemanningslid.setLuchtvaartMaatschappij_id(resultSet.getInt("luchtvaartmaatschappij_id"));
                bemanningslid.setPersoon_id(resultSet.getInt("persoon_id"));
                bemanningslid.setFunctie_id(resultSet.getInt("functie_id"));
                bemanningGegevens.add(bemanningslid);
                            }
        } catch (Exception e) {
            e.printStackTrace();
        }
         return bemanningGegevens  ;
    }
    
}
