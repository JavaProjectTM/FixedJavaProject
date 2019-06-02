/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataaccess;

import hbo5.it.www.beans.Hangar;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Kevin
 */
public class DAHangar {
    
    private final String url, login, password;
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
}
