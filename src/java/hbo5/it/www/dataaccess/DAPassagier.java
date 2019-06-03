/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataaccess;

import hbo5.it.www.beans.Hangar;
import hbo5.it.www.beans.Luchthaven;
import hbo5.it.www.beans.Passagier;
import hbo5.it.www.beans.Persoon;
import hbo5.it.www.beans.Vliegtuig;
import hbo5.it.www.beans.VliegtuigType;
import hbo5.it.www.beans.Vlucht;
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
public class DAPassagier {

    private final String url, login, password;

    public DAPassagier(String url, String login, String password, String driver) throws ClassNotFoundException {
        Class.forName(driver);
        this.url = url;
        this.login = login;
        this.password = password;
    }

    public Passagier getPassagier() {
        Passagier passagier = null;

        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM sportcentrum where id = 1");) {
            if (resultSet.next()) {
                passagier = new Passagier();
                passagier.setId(resultSet.getInt("id"));
                passagier.setIngeschreven(resultSet.getInt("ingeschreven"));
                passagier.setIngecheckt(resultSet.getInt("ingecheckt"));
                passagier.setKlasse_id(resultSet.getInt("klasse_id"));
                passagier.setPersoon_id(resultSet.getInt("persoon_id"));
                passagier.setVlucht_id(resultSet.getInt("vlucht_id"));
                passagier.setPlaats(resultSet.getString("plaats"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return passagier;
    }

    public ArrayList<Passagier> getPassagiers() {
        ArrayList<Passagier> Passagiers = new ArrayList<>();

        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM  passagier"
                        + " inner join persoon on passagier.persoon_id = persoon.id"
                );) {
            while (resultSet.next()) {
                Passagier passagier = new Passagier();
                passagier.setId(resultSet.getInt("id"));
                passagier.setIngeschreven(resultSet.getInt("ingeschreven"));
                passagier.setIngecheckt(resultSet.getInt("ingecheckt"));
                passagier.setKlasse_id(resultSet.getInt("klasse_id"));
                passagier.setPersoon_id(resultSet.getInt("persoon_id"));
                passagier.setVlucht_id(resultSet.getInt("vlucht_id"));
                passagier.setPlaats(resultSet.getString("plaats"));

                Persoon persoon = new Persoon();
                persoon.setVoornaam(resultSet.getString("voornaam"));
                persoon.setFamilienaam(resultSet.getString("familienaam"));
                passagier.setPersoon(persoon);
                Passagiers.add(passagier);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Passagiers;
    }

//        public int passagierCountOfVluchtById(int vluchtId){
//            ArrayList<Passagier> Passagiers = new ArrayList<>();
//            try (
//             Connection connection = DriverManager.getConnection(url, login, password);
//             PreparedStatement statement = connection.prepareStatement("SELECT * FROM PASSAGIER "
//                     + "WHERE VLUCHT_ID = ?");){
//                statement.setInt(1, vluchtId);
//                ResultSet resultSet = statement.executeQuery();
//                
//            while (resultSet.next()) {
//                 Passagier passagier = new Passagier();
//                 passagier.setId(resultSet.getInt("id"));
//                 passagier.setIngeschreven(resultSet.getInt("ingeschreven"));
//                 passagier.setIngecheckt(resultSet.getInt("ingecheckt"));
//	 passagier.setKlasse_id(resultSet.getInt("klasse_id"));
//	 passagier.setPersoon_id(resultSet.getInt("persoon_id"));
//	 passagier.setVlucht_id(resultSet.getInt("vlucht_id"));
//	 passagier.setPlaats(resultSet.getString("plaats"));
//                 
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return Passagiers.size();
//        }
    public int passagierCountOfVluchtById(int id) {
        ArrayList<Passagier> Passagiers = new ArrayList<>();

        try (
                Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement statement = connection.prepareStatement("SELECT * from passagier where vlucht_id = ?");) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Passagier passagier = new Passagier();
                passagier.setId(resultSet.getInt("id"));
                passagier.setIngeschreven(resultSet.getInt("ingeschreven"));
                passagier.setIngecheckt(resultSet.getInt("ingecheckt"));
                passagier.setKlasse_id(resultSet.getInt("klasse_id"));
                passagier.setPlaats(resultSet.getString("plaats"));
                passagier.setPersoon_id(resultSet.getInt("persoon_id"));
                passagier.setVlucht_id(resultSet.getInt("vlucht_id"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Passagiers.size();
    }

}
