/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataaccess;

import hbo5.it.www.beans.Hangar;
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
public class DAHangar {
    
    private final String url, login, password;
    private int teller = 20;
    public DAHangar(String url, String login, String password, String driver) throws ClassNotFoundException {
        Class.forName(driver);
        this.url = url;
        this.login = login;
        this.password = password;
    }

    public Hangar getHangar() {
        Hangar hangar = null;
        
         try (
             Connection connection = DriverManager.getConnection(url, login, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM hangar");) 
            {
            if (resultSet.next()) {
                hangar = new Hangar();
                hangar.setId(resultSet.getInt("id"));
                hangar.setHangarNaam(resultSet.getString("hangarnaam"));
                            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hangar;
     
}
        public ArrayList<Hangar> getHangarGegevens() {
          ArrayList<Hangar> HangarGegevens = new ArrayList<>();
        
         try (
             Connection connection = DriverManager.getConnection(url, login, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * from hangar");)
            {
            while (resultSet.next()) {
                Hangar hangar = new Hangar();
                hangar.setId(resultSet.getInt("id"));
                hangar.setHangarNaam(resultSet.getString("hangarnaam"));
                HangarGegevens.add(hangar);
                            }
        } catch (Exception e) {
            e.printStackTrace();
        }
         return HangarGegevens  ;
    }
        
        public Hangar getHangarGegevensById(int id) {
        Hangar hangarGegevens = new Hangar();

        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("SELECT * from hangar where id = ?");) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                hangarGegevens.setId(resultSet.getInt("id"));
                hangarGegevens.setHangarNaam(resultSet.getString("HANGARNAAM"));
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hangarGegevens;
    }

//    CRUD OPERATIES
    //delete -- werkt alleen op alles aangezien luchthaven gekoppeld is aan andere dingen
    public boolean deleteHangar(int id) {
        boolean resultaat = true;
        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("delete from hangar "
                        + " where id=?");) {
            statement.setInt(1, id);
            statement.execute();
        } catch (Exception e) {
            resultaat = false;
            e.printStackTrace();
        }
        return resultaat;
    }

    public boolean insertHangar(int id, String hangarNaam) {
        boolean resultaat = true;
        id = teller;
        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                //auto increment iets met seq.nextvalue.
                PreparedStatement statement = connection.prepareStatement("INSERT INTO hangar"
                        + "(ID, HANGARNAAM) VALUES"
                        + "(?,?)");) {
            
                                                                                                  
            statement.setInt(1, id);
            statement.setString(2, hangarNaam);
            
            statement.executeUpdate();
        } catch (Exception e) {
            resultaat = false;
            e.printStackTrace();

        }
        teller++;
        return resultaat;
        
    }
     // Update
    public boolean updateLuchthavenMaatschappij(int id, String hangarNaam) {
        boolean resultaat = true;

        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("update hangar set hangarnaam=? where id=?");) {
               statement.setString(1, hangarNaam);
               statement.setInt(2, id);
               
               statement.executeUpdate();
        } catch (Exception e) {
            resultaat = false;
            e.printStackTrace();
        }

        return resultaat;
    }
}
