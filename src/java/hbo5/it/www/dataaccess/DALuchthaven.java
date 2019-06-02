/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataaccess;

import hbo5.it.www.beans.Luchthaven;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Set;

/**
 *
 * @author Kevin
 */
public class DALuchthaven {

    private final String url, login, password;

    public DALuchthaven(String url, String login, String password, String driver) throws ClassNotFoundException {
        Class.forName(driver);
        this.url = url;
        this.login = login;
        this.password = password;
    }

    public Luchthaven getLand() {
        Luchthaven luchthaven = null;

        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM luchthaven");) {
            if (resultSet.next()) {
                luchthaven = new Luchthaven();
                luchthaven.setId(resultSet.getInt("id"));
                luchthaven.setLuchthavennaam(resultSet.getString("luchthavennaam"));
                luchthaven.setStad(resultSet.getString("stad"));
                luchthaven.setLand_id(resultSet.getInt("land_id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return luchthaven;
    }

    public ArrayList<Luchthaven> getLuchtHavenGegevens() {
        ArrayList<Luchthaven> LuchtHavenGegevens = new ArrayList<>();

        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * from luchthaven ORDER BY id");) {
            while (resultSet.next()) {
                Luchthaven luchthaven = new Luchthaven();
                luchthaven.setId(resultSet.getInt("id"));
                luchthaven.setLuchthavennaam(resultSet.getString("luchthavennaam"));
                luchthaven.setStad(resultSet.getString("stad"));
                luchthaven.setLand_id(resultSet.getInt("land_id"));
                LuchtHavenGegevens.add(luchthaven);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return LuchtHavenGegevens;
    }
    
    public Luchthaven getLuchtHavenGegevensById(int id) {
        Luchthaven LuchtHavenGegevens = new Luchthaven();

        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("SELECT * from luchthaven where id = ?");) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                LuchtHavenGegevens.setId(resultSet.getInt("id"));
                LuchtHavenGegevens.setLuchthavennaam(resultSet.getString("luchthavennaam"));
                LuchtHavenGegevens.setStad(resultSet.getString("stad"));
                LuchtHavenGegevens.setLand_id(resultSet.getInt("land_id"));
                    
                }
               
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return LuchtHavenGegevens;
    }

//    CRUD OPERATIES
    //delete -- werkt alleen op alles aangezien luchthaven gekoppeld is aan andere dingen
    public boolean deleteLuchthaven(int id) {
        boolean resultaat = true;
        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("delete from luchthaven "
                        + " where luchthaven.id = ?");) {
            statement.setInt(1, id);
            statement.execute();
        } catch (Exception e) {
            resultaat = false;
            e.printStackTrace();
        }
        return resultaat;
    }

    public boolean insertLuchthaven(String luchthavenNaam, String stad, int landId) {
        boolean resultaat = true;

        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("insert into luchthaven (luchthavennaam, stad, land_id) "
                        + "values (?,?,?)");) {
            statement.setString(1, luchthavenNaam);
            statement.setString(2, stad);
            statement.setInt(3, landId);
        } catch (Exception e) {
            resultaat = false;
            e.printStackTrace();

        }
        return resultaat;
    }
     // Update
    public boolean updateLuchthaven(int id, String luchthavenNaam, String stad, int landId) {
        boolean resultaat = true;

        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("update luchthaven set luchthavennaam=?, stad=?, land_id=? where id=?");) {
               statement.setString(1, luchthavenNaam);
               statement.setString(2,stad);
               statement.setInt(3,landId );
               statement.setInt(4, id);
               statement.execute();
               statement.executeUpdate();
        } catch (Exception e) {
            resultaat = false;
            e.printStackTrace();
        }

        return resultaat;
    }
}
