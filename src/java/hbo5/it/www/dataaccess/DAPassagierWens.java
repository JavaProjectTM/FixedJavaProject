/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataaccess;

import hbo5.it.www.beans.PassagierWens;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Kevin
 */
public class DAPassagierWens 
{
    private final String url, login, password;

    public DAPassagierWens(String url, String login, String password, String driver) throws ClassNotFoundException {
        Class.forName(driver);
        this.url = url;
        this.login = login;
        this.password = password;
    }

    public PassagierWens getPassagierWens() {
        PassagierWens passagierWens = null;
        
         try (
             Connection connection = DriverManager.getConnection(url, login, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM sportcentrum where id = 1");) 
            {
            if (resultSet.next()) {
                passagierWens = new PassagierWens();
                passagierWens.setBeschrijving(resultSet.getString("beschrijving"));
                passagierWens.setSoort(resultSet.getString("soort"));
                            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return passagierWens;
    }
    
}
