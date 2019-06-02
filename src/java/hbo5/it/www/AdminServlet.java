/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www;

import hbo5.it.www.beans.Bemanningslid;
import hbo5.it.www.beans.Functie;
import hbo5.it.www.beans.Hangar;
import hbo5.it.www.beans.Land;
import hbo5.it.www.beans.Luchthaven;
import hbo5.it.www.beans.Luchtvaartmaatschappij;
import hbo5.it.www.beans.Persoon;
import hbo5.it.www.beans.Vliegtuig;
import hbo5.it.www.dataaccess.DABemanningslid;
import hbo5.it.www.dataaccess.DAFunctie;
import hbo5.it.www.dataaccess.DAHangar;
import hbo5.it.www.dataaccess.DALand;
import hbo5.it.www.dataaccess.DALuchthaven;
import hbo5.it.www.dataaccess.DALuchtvaartmaatschappij;
import hbo5.it.www.dataaccess.DAPersoon;
import hbo5.it.www.dataaccess.DAVliegtuig;
import hbo5.it.www.dataaccess.DAVluchtBemanning;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sven
 */
@WebServlet(name = "AdminServlet", urlPatterns = {"/AdminServlet"}, initParams = {
    @WebInitParam(name = "url", value = "jdbc:oracle:thin:@itf-oracledb01.thomasmore.be:1521:XE")
    , @WebInitParam(name = "login", value = "C1044217")
    , @WebInitParam(name = "password", value = "1234")
    , @WebInitParam(name = "driver", value = "oracle.jdbc.driver.OracleDriver")})

public class AdminServlet extends HttpServlet {

    public DALuchthaven daLuchtHaven = null;
    public DALuchtvaartmaatschappij daLuchtvaartmaatschappij = null;
    public DALand daLand = null;
    public DAHangar daHangar = null;
    public DAVliegtuig daPlane = null;
    public DAVluchtBemanning daFlightCrew = null;
    public DABemanningslid daCrew = null;
    public DAPersoon daPersoon = null;
    public DAFunctie daFunctie = null;
    

    @Override
    public void init() throws ServletException {
        try {
            String url = getInitParameter("url");
            String password = getInitParameter("password");
            String login = getInitParameter("login");
            String driver = getInitParameter("driver");
            if (daLuchtHaven == null) {
                daLuchtHaven = new DALuchthaven(url, login, password, driver);
            }
            if (daLand == null) {
                daLand = new DALand(url, login, password, driver);
            }
            if (daHangar == null) {
                daHangar = new DAHangar(url, login, password, driver);
            }
            if (daFlightCrew == null) {
                daFlightCrew = new DAVluchtBemanning(url, login, password, driver);
            }
            if (daCrew == null) {
                daCrew = new DABemanningslid(url, login, password, driver);
            }
            if (daLuchtvaartmaatschappij == null) {
                daLuchtvaartmaatschappij = new DALuchtvaartmaatschappij(url, login, password, driver);
            }
            if (daPersoon == null) {
                daPersoon = new DAPersoon(url, login, password, driver);
            }
            if (daFunctie == null) {
                daFunctie = new DAFunctie(url, login, password, driver);
            }
            

        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        }
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = null;
        HttpSession session = request.getSession();

        if (request.getParameter("airportManageKnop") != null) {
            ArrayList<Luchthaven> luchthavens = daLuchtHaven.getLuchtHavenGegevens();
            request.setAttribute("luchthavens", luchthavens);
            request.setAttribute("daLand", daLand);
            rd = request.getRequestDispatcher("admin/manageAirports.jsp");
        }

        if (request.getParameter("airportAddKnop") != null) {
            ArrayList<Land> landen = daLand.getLandenGegevens();
            request.setAttribute("landen", landen);
            rd = request.getRequestDispatcher("admin/addAirport.jsp");
        }
        
        if (request.getParameter("crewAddKnop") != null) {
            ArrayList<Luchtvaartmaatschappij> luchtvaartmaatschappijen = daLuchtvaartmaatschappij.getLuchtvaartmaatschappijGegevens();
            request.setAttribute("luchtvaartmaatschappijen", luchtvaartmaatschappijen);
            ArrayList<Persoon> personen = daPersoon.getPersonenGegevens();
            request.setAttribute("personen", personen);
            ArrayList<Functie> functies = daFunctie.getFunctieGegevens();
            request.setAttribute("functies", functies);
            
            rd = request.getRequestDispatcher("admin/addCrews.jsp");
        }
        
        if (request.getParameter("crewAddKnop") != null) {
            ArrayList<Land> landen = daLand.getLandenGegevens();
            request.setAttribute("landen", landen);
            rd = request.getRequestDispatcher("admin/addCrews.jsp");
        }
        
        if (request.getParameter("airlineAddKnop") != null) {
            rd = request.getRequestDispatcher("admin/addAirline.jsp");
        }

        if (request.getParameter("airportSaveAddKnop") != null) {
            String luchthavenNaam = request.getParameter("luchthavennaam");
            String stad = request.getParameter("stad");
            int landId = Integer.parseInt(request.getParameter("landid"));
            int id = 0;
            if (daLuchtHaven.insertLuchthaven(id, luchthavenNaam, stad, landId)) {
                ArrayList<Luchthaven> luchthavens = daLuchtHaven.getLuchtHavenGegevens();
                request.setAttribute("luchthavens", luchthavens);
                request.setAttribute("daLand", daLand);
                rd = request.getRequestDispatcher("admin/manageAirports.jsp");
            } else {
                request.setAttribute("fout", "toevoegen luchthaven niet gelukt!");
                rd = request.getRequestDispatcher("admin/error.jsp");
            }
        }
        
        if (request.getParameter("crewSaveAddKnop") != null) {
            int luchtvaartmaatschappijId = Integer.parseInt(request.getParameter("luchtvaartmaatschappijId"));
            int persoonId = Integer.parseInt(request.getParameter("persoonId"));
            int functieId = Integer.parseInt(request.getParameter("functieId"));
            int id = 0;
            if (daCrew.insertBemanningslid(id,functieId, luchtvaartmaatschappijId, persoonId)) {
                ArrayList<Bemanningslid> bemanningsleden = daCrew.getBemanningsLeden();
            request.setAttribute("bemanningsleden", bemanningsleden);
            rd = request.getRequestDispatcher("admin/manageCrews.jsp");
            } else {
                request.setAttribute("fout", "toevoegen crewmember niet gelukt!");
                rd = request.getRequestDispatcher("admin/error.jsp");
            }
        }
        
        
        if (request.getParameter("airlineSaveAddKnop") != null) {
            String luchthavenNaam = request.getParameter("luchtvaartnaam");
            
            int id = 0;
            if (daLuchtvaartmaatschappij.insertLuchthavenMaatschappij(id, luchthavenNaam)) {
                ArrayList<Luchtvaartmaatschappij> luchtvaartmaatschappijen = daLuchtvaartmaatschappij.getLuchtvaartmaatschappijGegevens();
            request.setAttribute("luchtvaartmaatschappijen", luchtvaartmaatschappijen);
            rd = request.getRequestDispatcher("admin/manageAirlines.jsp");
            } else {
                request.setAttribute("fout", "toevoegen luchthaven niet gelukt!");
                rd = request.getRequestDispatcher("admin/error.jsp");
            }
        }
        
         if (request.getParameter("hangarSaveAddKnop") != null) {
            String hangarnaam = request.getParameter("hangarnaam");
            
            int id = 0;
            if (daHangar.insertHangar(id, hangarnaam)) {
                ArrayList<Hangar> hangaren = daHangar.getHangarGegevens();
            request.setAttribute("hangars", hangaren);
            rd = request.getRequestDispatcher("admin/manageHangars.jsp");
            } else {
                request.setAttribute("fout", "toevoegen luchthaven niet gelukt!");
                rd = request.getRequestDispatcher("admin/error.jsp");
            }
        }

        //moet verplaatst worden naar admin zoals alle andere dingen die alleen door admin mogen geopend worden.
        if (request.getParameter("luchtvaartDelete") != null) {
            int luchthavenId = Integer.parseInt(request.getParameter("luchtvaartDelete"));
            boolean t = daLuchtHaven.deleteLuchthaven(luchthavenId);
            if (daLuchtHaven.deleteLuchthaven(luchthavenId)) {
                ArrayList<Luchthaven> luchthavens = daLuchtHaven.getLuchtHavenGegevens();
                request.setAttribute("luchthavens", luchthavens);
                request.setAttribute("daLand", daLand);
                rd = request.getRequestDispatcher("admin/manageAirports.jsp");
            } else {
                request.setAttribute("fout", "Verwijderen luchthaven is niet gelukt!");
                rd = request.getRequestDispatcher("admin/error.jsp");
            }
        }
        
        if (request.getParameter("crewDelete") != null) {
            int crewId = Integer.parseInt(request.getParameter("crewDelete"));
            boolean t = daCrew.deleteBemanningslid(crewId);
            if (t) {
                ArrayList<Bemanningslid> bemanningsleden = daCrew.getBemanningsLeden();
            request.setAttribute("bemanningsleden", bemanningsleden);
            rd = request.getRequestDispatcher("admin/manageCrews.jsp");
            } else {
                request.setAttribute("fout", "Verwijderen bemanningslid is niet gelukt!");
                rd = request.getRequestDispatcher("admin/error.jsp");
            }
        }
        
        if (request.getParameter("hangarDelete") != null) {
            int hangerID = Integer.parseInt(request.getParameter("hangarDelete"));
            boolean t = daHangar.deleteHangar(hangerID);
            if (t) {
                ArrayList<Hangar> hangars = daHangar.getHangarGegevens();
                request.setAttribute("hangars", hangars);
                rd = request.getRequestDispatcher("admin/manageHangars.jsp");
            } else {
                request.setAttribute("fout", "Verwijderen luchthaven is niet gelukt!");
                rd = request.getRequestDispatcher("admin/error.jsp");
            }
        }
        
        
         if (request.getParameter("AirlineDelete") != null) {
            int luchthavenId = Integer.parseInt(request.getParameter("AirlineDelete"));
            boolean t = daLuchtvaartmaatschappij.deleteLuchthavenmaatschappij(luchthavenId);
            if (t) {
                ArrayList<Luchtvaartmaatschappij> luchtvaartmaatschappijen = daLuchtvaartmaatschappij.getLuchtvaartmaatschappijGegevens();
            request.setAttribute("luchtvaartmaatschappijen", luchtvaartmaatschappijen);
            rd = request.getRequestDispatcher("admin/manageAirlines.jsp");
            } else {
                request.setAttribute("fout", "Verwijderen luchthaven is niet gelukt!");
                rd = request.getRequestDispatcher("admin/error.jsp");
            }
        }

        if (request.getParameter("luchtvaartEdit") != null) {
            int luchthavenid2 = Integer.parseInt(request.getParameter("luchtvaartEdit"));
            Luchthaven luchthaven2 = daLuchtHaven.getLuchtHavenGegevensById(luchthavenid2);
            request.setAttribute("luchthaven", luchthaven2);
            rd = request.getRequestDispatcher("admin/editLuchthaven.jsp");
        }

        if (request.getParameter("AirlineEdit") != null) {
            int luchthavenid2 = Integer.parseInt(request.getParameter("AirlineEdit"));
            Luchtvaartmaatschappij luchthaven2 = daLuchtvaartmaatschappij.getLuchtHavenGegevensById(luchthavenid2);
            request.setAttribute("luchtvaartmaatschappij", luchthaven2);
            rd = request.getRequestDispatcher("admin/editAirline.jsp");
        }
        
        

        if (request.getParameter("wijzigLuchthaven") != null) {
            String luchthavenNaam = request.getParameter("luchthavennaam");
            int id = Integer.parseInt(request.getParameter("id"));
            String stad = request.getParameter("stad");
            int landId = Integer.parseInt(request.getParameter("landid"));
            if (daLuchtHaven.updateLuchthaven(id, luchthavenNaam, stad, landId)) {
                ArrayList<Luchthaven> luchthavens = daLuchtHaven.getLuchtHavenGegevens();
                request.setAttribute("luchthavens", luchthavens);
                request.setAttribute("daLand", daLand);
                rd = request.getRequestDispatcher("admin/manageAirports.jsp");

            } else {
                request.setAttribute("fout", "wijzigen niet gelukt");
                rd = request.getRequestDispatcher("admin/error.jsp");
            }

        }

        if (request.getParameter("airlineSaveEditKnop") != null) {
            String luchtvaartnaam = request.getParameter("luchtvaartnaam");
            int id = Integer.parseInt(request.getParameter("id"));
            if (daLuchtvaartmaatschappij.updateLuchthavenMaatschappij(id, luchtvaartnaam)) {
                ArrayList<Luchtvaartmaatschappij> luchtvaartmaatschappijen = daLuchtvaartmaatschappij.getLuchtvaartmaatschappijGegevens();
                request.setAttribute("luchtvaartmaatschappijen", luchtvaartmaatschappijen);
                rd = request.getRequestDispatcher("admin/manageAirlines.jsp");
            } else {
                request.setAttribute("fout", "wijzigen niet gelukt");
                rd = request.getRequestDispatcher("admin/error.jsp");
            }
        }

        if (request.getParameter("airlineManageKnop") != null) {
            ArrayList<Luchtvaartmaatschappij> luchtvaartmaatschappijen = daLuchtvaartmaatschappij.getLuchtvaartmaatschappijGegevens();
            request.setAttribute("luchtvaartmaatschappijen", luchtvaartmaatschappijen);
            rd = request.getRequestDispatcher("admin/manageAirlines.jsp");
        }

        if (request.getParameter("planesManageKnop") != null) {
            ArrayList<Vliegtuig> vliegtuigen = daPlane.getVliegtuigGegevens();
            request.setAttribute("vliegtuigen", vliegtuigen);
            rd = request.getRequestDispatcher("admin/managePlanes.jsp");
        }
        if (request.getParameter("hangarManageKnop") != null) {
            ArrayList<Hangar> hangars = daHangar.getHangarGegevens();
            request.setAttribute("hangars", hangars);
            rd = request.getRequestDispatcher("admin/manageHangars.jsp");
        }
        if (request.getParameter("crewManageKnop") != null) {
            ArrayList<Bemanningslid> bemanningsleden = daCrew.getBemanningsLeden();
            request.setAttribute("bemanningsleden", bemanningsleden);
            rd = request.getRequestDispatcher("admin/manageCrews.jsp");
        }
        if (request.getParameter("flightCrewManageKnop") != null) {
            rd = request.getRequestDispatcher("admin/manageFlightCrews.jsp");
        }
        if (request.getParameter("PlanesInHaManageKnop") != null) {
            rd = request.getRequestDispatcher("admin/managePlanesInHangars.jsp");
        }

        //add + save
        if (request.getParameter("airlineSaveAddKnop") != null) {
            rd = request.getRequestDispatcher("admin/manageAirlines.jsp");
        }
        if (request.getParameter("hangarAddKnop") != null) {
            rd = request.getRequestDispatcher("admin/addHangar.jsp");
        }
        if (request.getParameter("planesSaveAddKnop") != null) {
            rd = request.getRequestDispatcher("admin/managePlanes.jsp");
        }
        if (request.getParameter("crewsSaveAddKnop") != null) {
            rd = request.getRequestDispatcher("admin/manageCrews.jsp");
        }
        if (request.getParameter("flightCrewsSaveAddKnop") != null) {
            rd = request.getRequestDispatcher("admin/manageFlightCrews.jsp");
        }
        if (request.getParameter("hangarSaveAddKnop") != null) {
            rd = request.getRequestDispatcher("admin/manageHangars.jsp");
        }
        if (request.getParameter("planesInHanSaveAddKnop") != null) {
            rd = request.getRequestDispatcher("admin/managePlanesInHangars.jsp");
        }

        //cancel
        if (request.getParameter("planesInHanCancelKnop") != null) {
            rd = request.getRequestDispatcher("admin/managePlanesInHangars.jsp");
        }
        if (request.getParameter("airlineCancelKnop") != null) {
            rd = request.getRequestDispatcher("admin/manageAirlines.jsp");
        }
        if (request.getParameter("crewsCancelKnop") != null) {
            rd = request.getRequestDispatcher("admin/manageCrews.jsp");
        }
        if (request.getParameter("planesCancelKnop") != null) {
            rd = request.getRequestDispatcher("admin/managePlanes.jsp");
        }
        if (request.getParameter("hangarCancelKnop") != null) {
            rd = request.getRequestDispatcher("admin/manageHangars.jsp");
        }
        if (request.getParameter("flightCrewsCancelKnop") != null) {
            rd = request.getRequestDispatcher("admin/manageFlightCrews.jsp");
        }

        rd.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
