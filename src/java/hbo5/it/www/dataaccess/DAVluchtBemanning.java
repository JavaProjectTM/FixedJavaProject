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
import hbo5.it.www.beans.VluchtBemanning;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Kevin
 */
public class DAVluchtBemanning {
    
    private final String url, login, password;

    public DAVluchtBemanning(String url, String login, String password, String driver) throws ClassNotFoundException {
        Class.forName(driver);
        this.url = url;
        this.login = login;
        this.password = password;
    }

    
    public ArrayList<VluchtBemanning> getAgenda() {
     ArrayList<VluchtBemanning> Agenda = new ArrayList<>();
  
         try (
             Connection connection = DriverManager.getConnection(url, login, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT vluchtbemanning.id, vluchtbemanning.taak, vluchtbemanning.bemanningslid_id, vluchtbemanning.vlucht_id, vlucht.id, vlucht.code, vlucht.vertrekTijd, vlucht.aankomstTijd, vlucht.vliegtuig_id, vlucht.vertrekluchthaven_id, vlucht.aankomstluchthaven_id, vliegtuig.id, vliegtuig.vliegtuigtype_id, vliegtuig.luchtvaartmaatschappij_id,"
                     + " vliegtuigType.id, vliegtuigType.typenaam, VL.id, VL.luchthavennaam, VL.stad, VL.land_id, AL.id, AL.luchthavennaam, AL.stad, AL.land_id "
                     + " FROM  vluchtbemanning "
                     + " inner join vlucht on vluchtbemanning.vlucht_id = vlucht.id "
                     + " inner join vliegtuig on vlucht.vliegtuig_id = vliegtuig.id "
                     + " inner join vliegtuigtype on vliegtuig.vliegtuigtype_id = vliegtuigtype.id "
                     + " inner join luchthaven VL on vlucht.vertrekluchthaven_id = VL.id "
                     + " inner join luchthaven AL on vlucht.aankomstluchthaven_id = AL.id");) 
            {
            while (resultSet.next()) {
                VluchtBemanning agendaItem = new VluchtBemanning();
                agendaItem.setId(resultSet.getInt("id"));
                agendaItem.setTaak(resultSet.getString("taak"));
                agendaItem.setBemanningslid_id(resultSet.getInt("bemanningslid_id"));
                agendaItem.setVlucht_id(resultSet.getInt("vlucht_id"));  
                 Vlucht vlucht = new Vlucht();
                 vlucht.setId(resultSet.getInt(5));
                 vlucht.setCode(resultSet.getString("code"));
                 vlucht.setVertrekTijd(resultSet.getDate("vertrekTijd"));
                 vlucht.setAankomstTijd(resultSet.getDate("aankomstTijd"));
                 vlucht.setVliegtuig_id(resultSet.getInt("vliegtuig_id"));
                 vlucht.setVertrekluchthaven_id(resultSet.getInt("vertrekluchthaven_id"));
                 vlucht.setAankomstluchthaven_id(resultSet.getInt("aankomstluchthaven_id"));
                 Vliegtuig vliegtuig = new Vliegtuig();
                 vliegtuig.setId(resultSet.getInt(12));
                 vliegtuig.setVliegtuigType_id(resultSet.getInt("vliegtuigtype_id"));
                 vliegtuig.setLuchtvaartMaatschappij_id(resultSet.getInt("luchtvaartMaatschappij_id"));
                 vlucht.setVliegtuig(vliegtuig);
         
                 VliegtuigType vliegtuigType = new VliegtuigType();
                 vliegtuigType.setId(resultSet.getInt(15));
                 vliegtuigType.setTypenaam(resultSet.getString("typenaam"));
                
                 vlucht.setVliegtuigType(vliegtuigType);
                
                 Luchthaven vertrekLuchthaven = new Luchthaven();
                 vertrekLuchthaven.setId(resultSet.getInt(17));
                 vertrekLuchthaven.setLuchthavennaam(resultSet.getString(18));
                 vertrekLuchthaven.setStad(resultSet.getString(19));
                 vertrekLuchthaven.setLand_id(resultSet.getInt(20));
                
                 vlucht.setVertrekLuchthaven(vertrekLuchthaven);
                
                 Luchthaven aankomstLuchthaven = new Luchthaven();
                 aankomstLuchthaven.setId(resultSet.getInt(21));
                 aankomstLuchthaven.setLuchthavennaam(resultSet.getString(22));
                 aankomstLuchthaven.setStad(resultSet.getString(23));
                 aankomstLuchthaven.setLand_id(resultSet.getInt(24));               
                 vlucht.setAankomstLuchthaven(aankomstLuchthaven);
                 agendaItem.setVlucht(vlucht);
                 Agenda.add(agendaItem);
        
               
                            }
        } catch (Exception e) {
            e.printStackTrace();
        }
         return Agenda;
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
    public VluchtBemanning getVluchtBemanning() {
        VluchtBemanning vluchtbemanning = null;
        
         try (
             Connection connection = DriverManager.getConnection(url, login, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM sportcentrum where id = 1");) 
            {
            if (resultSet.next()) {
                vluchtbemanning = new VluchtBemanning();
                vluchtbemanning.setId(resultSet.getInt("id"));
                vluchtbemanning.setTaak(resultSet.getString("taak"));
                vluchtbemanning.setBemanningslid_id(resultSet.getInt("bemanningslid_id"));
                vluchtbemanning.setVlucht_id(resultSet.getInt("vlucht_id"));
                            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vluchtbemanning;
    }
}
   

