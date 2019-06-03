/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataaccess;

import hbo5.it.www.beans.VliegtuigType;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Kevin
 */
public class DAVliegtuigType {
    
    private final String url, login, password;

    public DAVliegtuigType(String url, String login, String password, String driver) throws ClassNotFoundException {
        Class.forName(driver);
        this.url = url;
        this.login = login;
        this.password = password;
    }

    public VliegtuigType getVliegtuigType() {
        VliegtuigType vliegtuigType = null;
        
         try (
             Connection connection = DriverManager.getConnection(url, login, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM sportcentrum where id = 1");) 
            {
            if (resultSet.next()) {
                vliegtuigType = new VliegtuigType();
                vliegtuigType.setId(resultSet.getInt("id"));
                vliegtuigType.setTypenaam(resultSet.getString("typenaam"));
                            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vliegtuigType;
    }
    
            public VliegtuigType getVliegtuigTypeById(int id) {
            //String vliegtuigType = null;
            VliegtuigType vliegtuigtype = new VliegtuigType();
        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM VLIEGTUIGTYPE WHERE ID = ?");) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                
                vliegtuigtype.setId(resultSet.getInt("id"));
                vliegtuigtype.setTypenaam(resultSet.getString("typenaam"));
            }
        } catch (Exception e) {
            {
                e.printStackTrace();
            }
        }
            return vliegtuigtype;
    }
    
    
    
    
}