/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataaccess;

import hbo5.it.www.beans.Luchthaven;
import hbo5.it.www.beans.Vliegtuig;
import hbo5.it.www.beans.VliegtuigType;
import hbo5.it.www.beans.Vlucht;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;

/**
 *
 * @author Kevin
 */
public class DAVlucht {
    
    private final String url, login, password;

    public DAVlucht(String url, String login, String password, String driver) throws ClassNotFoundException {
        Class.forName(driver);
        this.url = url;
        this.login = login;
        this.password = password;
    }

    public ArrayList<Vlucht> getVluchtGegevens() {
          ArrayList<Vlucht> vluchtGegevens = new ArrayList<>();
        
         try (
             Connection connection = DriverManager.getConnection(url, login, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT vlucht.id, vlucht.code, vlucht.vertrekTijd, vlucht.aankomstTijd, vlucht.vliegtuig_id, vlucht.vertrekluchthaven_id, vlucht.aankomstluchthaven_id, vliegtuig.id, vliegtuig.vliegtuigtype_id, vliegtuig.luchtvaartmaatschappij_id,"
                     + " vliegtuigType.id, vliegtuigType.typenaam, VL.id, VL.luchthavennaam, VL.stad, VL.land_id, AL.id, AL.luchthavennaam, AL.stad, AL.land_id FROM  vlucht "
                     + " inner join vliegtuig on vlucht.vliegtuig_id = vliegtuig.id "
                     + " inner join vliegtuigtype on vliegtuig.vliegtuigtype_id = vliegtuigtype.id "
                     + " inner join luchthaven VL on vlucht.vertrekluchthaven_id = VL.id "
                     + " inner join luchthaven AL on vlucht.aankomstluchthaven_id = AL.id  ORDER BY vlucht.vertrekTijd");) 
            {
            while (resultSet.next()) {
                 Vlucht vlucht = new Vlucht();
                 vlucht.setId(resultSet.getInt(1));
                 vlucht.setCode(resultSet.getString("code"));
                 vlucht.setVertrekTijd(resultSet.getDate("vertrekTijd"));
                 vlucht.setAankomstTijd(resultSet.getDate("aankomstTijd"));
                 vlucht.setVliegtuig_id(resultSet.getInt("vliegtuig_id"));
                 vlucht.setVertrekluchthaven_id(resultSet.getInt("vertrekluchthaven_id"));
                 vlucht.setAankomstluchthaven_id(resultSet.getInt("aankomstluchthaven_id"));
                 
                 Vliegtuig vliegtuig = new Vliegtuig();
                 vliegtuig.setId(resultSet.getInt(8));
                 vliegtuig.setVliegtuigType_id(resultSet.getInt("vliegtuigtype_id"));
                 vliegtuig.setLuchtvaartMaatschappij_id(resultSet.getInt("luchtvaartMaatschappij_id"));
                 vlucht.setVliegtuig(vliegtuig);
         
                 VliegtuigType vliegtuigType = new VliegtuigType();
                 vliegtuigType.setId(resultSet.getInt(11));
                 vliegtuigType.setTypenaam(resultSet.getString("typenaam"));
                
                 vlucht.setVliegtuigType(vliegtuigType);
                
                 Luchthaven vertrekLuchthaven = new Luchthaven();
                 vertrekLuchthaven.setId(resultSet.getInt(13));
                 vertrekLuchthaven.setLuchthavennaam(resultSet.getString(14));
                 vertrekLuchthaven.setStad(resultSet.getString(15));
                 vertrekLuchthaven.setLand_id(resultSet.getInt(16));
                
                 vlucht.setVertrekLuchthaven(vertrekLuchthaven);
                
                 Luchthaven aankomstLuchthaven = new Luchthaven();
                 aankomstLuchthaven.setId(resultSet.getInt(17));
                 aankomstLuchthaven.setLuchthavennaam(resultSet.getString(18));
                 aankomstLuchthaven.setStad(resultSet.getString(19));
                 aankomstLuchthaven.setLand_id(resultSet.getInt(20));
                
                 vlucht.setAankomstLuchthaven(aankomstLuchthaven);
                 vluchtGegevens.add(vlucht);
        
               
                            }
        } catch (Exception e) {
            e.printStackTrace();
        }
         return vluchtGegevens  ;
    }
    public Vlucht getVluchtGegevens(int vluchtId){
        Vlucht vluchtGegevens = new Vlucht();
         try (
             Connection connection = DriverManager.getConnection(url, login, password);
             PreparedStatement statement = connection.prepareStatement("SELECT vlucht.id, vlucht.code, vlucht.vertrekTijd, vlucht.aankomstTijd, vlucht.vliegtuig_id, vlucht.vertrekluchthaven_id, vlucht.aankomstluchthaven_id, vliegtuig.id, vliegtuig.vliegtuigtype_id, vliegtuig.luchtvaartmaatschappij_id,"
                     + " vliegtuigType.id, vliegtuigType.typenaam, VL.id, VL.luchthavennaam, VL.stad, VL.land_id, AL.id, AL.luchthavennaam, AL.stad, AL.land_id FROM  vlucht "
                     + " inner join vliegtuig on vlucht.vliegtuig_id = vliegtuig.id "
                     + " inner join vliegtuigtype on vliegtuig.vliegtuigtype_id = vliegtuigtype.id "
                     + " inner join luchthaven VL on vlucht.vertrekluchthaven_id = VL.id "
                     + " inner join luchthaven AL on vlucht.aankomstluchthaven_id = AL.id "
                     + " WHERE vlucht.id = ?");) 
            {
                statement.setInt(1, vluchtId);
                ResultSet resultSet = statement.executeQuery();
                
            while (resultSet.next()) {
                 
                 vluchtGegevens.setId(resultSet.getInt(1));
                 vluchtGegevens.setCode(resultSet.getString("code"));
                 vluchtGegevens.setVertrekTijd(resultSet.getDate("vertrekTijd"));
                 vluchtGegevens.setAankomstTijd(resultSet.getDate("aankomstTijd"));
                 vluchtGegevens.setVliegtuig_id(resultSet.getInt("vliegtuig_id"));
                 vluchtGegevens.setVertrekluchthaven_id(resultSet.getInt("vertrekluchthaven_id"));
                 vluchtGegevens.setAankomstluchthaven_id(resultSet.getInt("aankomstluchthaven_id"));
                 
                 Vliegtuig vliegtuig = new Vliegtuig();
                 vliegtuig.setId(resultSet.getInt(8));
                 vliegtuig.setVliegtuigType_id(resultSet.getInt("vliegtuigtype_id"));
                 vliegtuig.setLuchtvaartMaatschappij_id(resultSet.getInt("luchtvaartMaatschappij_id"));
                 vluchtGegevens.setVliegtuig(vliegtuig);
         
                 VliegtuigType vliegtuigType = new VliegtuigType();
                 vliegtuigType.setId(resultSet.getInt(11));
                 vliegtuigType.setTypenaam(resultSet.getString("typenaam"));
                
                 vluchtGegevens.setVliegtuigType(vliegtuigType);
                
                 Luchthaven vertrekLuchthaven = new Luchthaven();
                 vertrekLuchthaven.setId(resultSet.getInt(13));
                 vertrekLuchthaven.setLuchthavennaam(resultSet.getString(14));
                 vertrekLuchthaven.setStad(resultSet.getString(15));
                 vertrekLuchthaven.setLand_id(resultSet.getInt(16));
                
                 vluchtGegevens.setVertrekLuchthaven(vertrekLuchthaven);
                
                 Luchthaven aankomstLuchthaven = new Luchthaven();
                 aankomstLuchthaven.setId(resultSet.getInt(17));
                 aankomstLuchthaven.setLuchthavennaam(resultSet.getString(18));
                 aankomstLuchthaven.setStad(resultSet.getString(19));
                 aankomstLuchthaven.setLand_id(resultSet.getInt(20));
                
                 vluchtGegevens.setAankomstLuchthaven(aankomstLuchthaven);
                 
                            }
        } catch (Exception e) {
            e.printStackTrace();
        }
         return vluchtGegevens;
    }
    
        public ArrayList<Vlucht> getAankomendeVluchten() {
        ArrayList<Vlucht> vluchten = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, login, password);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("select * from vlucht order by vertrekluchthaven_id");) {

            while (resultSet.next()) {
                Vlucht vlucht = new Vlucht();
                 vlucht.setId(resultSet.getInt("id"));
                 vlucht.setCode(resultSet.getString("code"));
                 vlucht.setVertrekTijd(resultSet.getDate("vertrekTijd"));
                 vlucht.setAankomstTijd(resultSet.getDate("aankomstTijd"));
                 vlucht.setVliegtuig_id(resultSet.getInt("vliegtuig_id"));
	 vlucht.setVertrekluchthaven_id(resultSet.getInt("vertrekluchthaven_id"));
	 vlucht.setAankomstluchthaven_id(resultSet.getInt("aankomstluchthaven_id"));
                vluchten.add(vlucht);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vluchten;
    }

    public boolean insertVlucht(int id) {
        boolean resultaat = true;

        try (Connection connection = DriverManager.getConnection(url, login, password);
             PreparedStatement statement = connection.prepareStatement("insert into vlucht values (vlucht_seq.nextval,?)");) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            resultaat = false;
            e.printStackTrace();
        }
        return resultaat;
    }

    public boolean updateVlucht(int id, String code, Date vertrekTijd, Date aankomstTijd, int vliegtuig_id, int vertrekluchthaven_id, int aankomstluchthaven_id) {
        boolean resultaat = true;

        try (Connection connection = DriverManager.getConnection(url, login, password);
             PreparedStatement statement = connection.prepareStatement("update vlucht set code=? vertrektijd=? aankomsttijd=? vliegtuig_id=? vertrekluchthaven_id=? aankomstluchthaven=? where id=?");) {
            statement.setString(1, code);
            statement.setDate(2, vertrekTijd);
            statement.setDate(3, aankomstTijd);
            statement.setInt(4,vliegtuig_id);
            statement.setInt(5,vertrekluchthaven_id);
            statement.setInt(6, aankomstluchthaven_id);
            statement.setInt(7, id);
            statement.executeUpdate();
        } catch (Exception e) {
            resultaat = false;
            e.printStackTrace();
        }
        return resultaat;
    }

    public boolean deleteVlucht(int id) {
        boolean resultaat = true;

        try (Connection connection = DriverManager.getConnection(url, login, password);
             PreparedStatement statement = connection.prepareStatement("delete from vlucht where id = ?");) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            resultaat = false;
            e.printStackTrace();
        }
        return resultaat;
    }

    

    
    
    
}

