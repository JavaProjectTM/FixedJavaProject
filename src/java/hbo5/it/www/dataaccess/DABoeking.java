/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Date;

/**
 *
 * @author Kevin
 */
public class DABoeking {
    
        private final String url, login, password;
       int teller = 1;

    public DABoeking(String url, String login, String password, String driver) throws ClassNotFoundException {
        Class.forName(driver);
        this.url = url;
        this.login = login;
        this.password = password;
    }
 public boolean deleteBoeking(int id) {
        boolean resultaat = true;
        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("delete from boeking "
                        + " where boeking.id = ?");) {
            statement.setInt(1, id);
            statement.execute();
        } catch (Exception e) {
            resultaat = false;
            e.printStackTrace();
        }
        return resultaat;
    }

    public boolean insertBoeking(int passagier_id, int id, int aantalVolwassenen, int aantalKinderen, int bagage, int Handbagage, String aankomst, Date datum, double Price) {
        boolean resultaat = true;
        id = teller;
        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                //auto increment iets met seq.nextvalue.
                PreparedStatement statement = connection.prepareStatement("INSERT INTO Boeking"
                        + "(passagier_id, id, aantalVolwassenen, aantalKinderen, bagage, handBagage, aankomst, datum, price) VALUES"
                        + "(?,?,?,?,?,?,?,?,?)");) {
            
                                                                                                  
            statement.setInt(1, passagier_id);
            statement.setInt(2, id);
            statement.setInt(3, aantalVolwassenen );
            statement.setInt(4, aantalKinderen);
            statement.setInt(5, bagage);
            statement.setInt(6,Handbagage);
            statement.setString(7,aankomst);
            statement.setDate(8, (java.sql.Date) datum);
            statement.setDouble(9,Price);
            statement.executeUpdate();
        } catch (Exception e) {
            resultaat = false;
            e.printStackTrace();

        }
        teller++;
        return resultaat;
        
    }
}
