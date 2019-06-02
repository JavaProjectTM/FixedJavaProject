/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataaccess;
import  hbo5.it.www.beans.Bemanningslid;
import java.sql.Connection;
import java.sql.DriverManager;
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
    
    
    
    
}
