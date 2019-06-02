/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataaccess;

import hbo5.it.www.beans.Luchthaven;
import hbo5.it.www.beans.Persoon;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author Kevin
 */
public class DAPersoon {
    private final String url, login, password;

    public DAPersoon(String url, String login, String password, String driver) throws ClassNotFoundException {
        Class.forName(driver);
        this.url = url;
        this.login = login;
        this.password = password;
    }

    public Persoon getPersoon() {
        Persoon persoon = null;
    
        
         try (
             Connection connection = DriverManager.getConnection(url, login, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM sportcentrum where id = 1");) 
            {
            if (resultSet.next()) {
                 persoon = new Persoon();
                 persoon.setId(resultSet.getInt("id"));
                 persoon.setVoornaam(resultSet.getString("voornaam"));
                 persoon.setFamilienaam(resultSet.getString("familienaam"));
	 persoon.setHuisnummer(resultSet.getString("huisnummer"));
	 persoon.setStraat(resultSet.getString("straat"));
	 persoon.setPostcode(resultSet.getString("postcode"));
	 persoon.setWoonplaats(resultSet.getString("woonplaats"));
	 persoon.setLand(resultSet.getString("land"));
	 persoon.setGeboortedatum(resultSet.getDate("geboortedatum"));
	 persoon.setLogin(resultSet.getString("login"));
 	 persoon.setPaswoord(resultSet.getString("paswoord"));
	 persoon.setSoort(resultSet.getString("soort").charAt(0));
                 }
        } catch (Exception e) {
            e.printStackTrace();
    }

    return persoon;
}
    public Persoon getPersoonByName(String name) {
        Persoon persoon = null;

        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM PERSOON WHERE login like ?");) {
            statement.setString(1, name.toLowerCase());
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                persoon = new Persoon();
                persoon.setId(resultSet.getInt("id"));
                persoon.setVoornaam(resultSet.getString("voornaam"));
                persoon.setFamilienaam(resultSet.getString("familienaam"));
                persoon.setHuisnummer(resultSet.getString("huisnr"));
                persoon.setStraat(resultSet.getString("straat"));
                persoon.setPostcode(resultSet.getString("postcode"));
                persoon.setWoonplaats(resultSet.getString("woonplaats"));
        	persoon.setLand(resultSet.getString("land"));
                persoon.setGeboortedatum(resultSet.getDate("geboortedatum"));
                persoon.setLogin(resultSet.getString("login"));
                persoon.setPaswoord(resultSet.getString("paswoord"));
        	persoon.setSoort(resultSet.getString("soort").charAt(0));
            }
        } catch (Exception e) {
            {
                e.printStackTrace();
            }
        }
            return persoon;
    }
    
    public boolean insertPersoon(String userLogin,String userPass){
        boolean resultaat = true;
        
        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("INSERT INTO PERSOON VALUES (persoon_seq.nextval,?,?,?,?,?,?,?,?,?,?,?) ");) {

                
                statement.setString(1, "x");
                statement.setString(2, "x");
                statement.setString(3, "x");
                statement.setString(4, "x");    
                statement.setString(5, "x");
                statement.setString(6, "x");
                statement.setString(7, "x");
                statement.setDate(8, new Date(01/01/1996));
                statement.setString(9, userLogin.toLowerCase());
                statement.setString(10, userPass.toLowerCase());
                statement.setString(11, "P");

                statement.executeUpdate();
        } catch (Exception e) {
            {
                resultaat = false;
                e.printStackTrace();
            }
        }
        return resultaat;
    }
    
        public boolean updatePersoon(int Id, String userVoornaam,String userFamilienaam,String userStraat,String userHuisnr,String userPostcode,String userWoonplaats,String userLand,String userGeboortedatum){
        boolean resultaat = true;
        
        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("update persoon set voornaam=?, familienaam=?, straat=?, huisnr=?, postcode=?, woonplaats=?, land=?, geboortedatum=? where id=?")
                ;) {

                
                statement.setString(1, userVoornaam);
                statement.setString(2, userFamilienaam);
                statement.setString(3, userStraat);    
                statement.setString(4, userHuisnr);
                statement.setString(5, userPostcode);
                statement.setString(6, userWoonplaats);
                statement.setString(7, userLand);
                statement.setDate(8, new Date(01/01/1996));
                statement.setInt(9, Id);


                statement.executeUpdate();
        } catch (Exception e) {
            {
                resultaat = false;
                e.printStackTrace();
            }
        }
        return resultaat;
    }

    
    
    public ArrayList<Persoon> getPersonenGegevens() {
        ArrayList<Persoon> Personen = new ArrayList<>();

        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * from persoon ORDER BY id");) {
            while (resultSet.next()) {
                Persoon persoon = new Persoon();
                persoon.setId(resultSet.getInt("id"));
                persoon.setVoornaam(resultSet.getString("voornaam"));
                persoon.setFamilienaam(resultSet.getString("familienaam"));
                persoon.setStraat(resultSet.getString("straat"));
                persoon.setHuisnummer(resultSet.getString("huisnr"));
                persoon.setPostcode(resultSet.getString("postcode"));
                persoon.setWoonplaats(resultSet.getString("woonplaats"));
                persoon.setLand(resultSet.getString("land"));
                persoon.setGeboortedatum(resultSet.getDate("geboortedatum"));
                persoon.setLogin(resultSet.getString("login"));
                persoon.setPaswoord(resultSet.getString("paswoord"));
                //fout
                //persoon.setSoort(resultSet.getNCharacterStream("soort"));
                
                Personen.add(persoon);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Personen;
    }
    
    
}
