/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataaccess;

import hbo5.it.www.beans.Stockage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Kevin
 */
public class DAStockage 
{
    
    private final String url, login, password;

    public DAStockage(String url, String login, String password, String driver) throws ClassNotFoundException {
        Class.forName(driver);
        this.url = url;
        this.login = login;
        this.password = password;
    }

    public Stockage getStockage() {
        Stockage stockage = null;
        
         try (
             Connection connection = DriverManager.getConnection(url, login, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM sportcentrum where id = 1");) 
            {
            if (resultSet.next()) {
                stockage = new Stockage();
                stockage.setId(resultSet.getInt("id"));
                stockage.setReden(resultSet.getString("reden"));
		stockage.setVanDatum(resultSet.getDate("vanDatum"));
		stockage.setTotDatum(resultSet.getDate("totDatum"));
		stockage.setVliegtuig_id(resultSet.getInt("bliegtuig_id"));
		stockage.setHangar_id(resultSet.getInt("hangar_id"));
                            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stockage;
    }
    
    
    
    
}
