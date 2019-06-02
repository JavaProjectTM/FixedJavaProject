/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www;

import hbo5.it.www.beans.Hangar;
import hbo5.it.www.beans.Land;
import hbo5.it.www.beans.Luchthaven;
import hbo5.it.www.beans.Luchtvaartmaatschappij;
import hbo5.it.www.beans.Passagier;
import hbo5.it.www.beans.Persoon;
import hbo5.it.www.beans.Vliegtuig;
import hbo5.it.www.beans.Vlucht;
import hbo5.it.www.beans.VluchtBemanning;
import hbo5.it.www.dataaccess.DAHangar;
import hbo5.it.www.dataaccess.DALand;
import hbo5.it.www.dataaccess.DALuchthaven;
import hbo5.it.www.dataaccess.DALuchtvaartmaatschappij;
import hbo5.it.www.dataaccess.DAPassagier;
import hbo5.it.www.dataaccess.DAPersoon;
import hbo5.it.www.dataaccess.DAVliegtuig;
import hbo5.it.www.dataaccess.DAVlucht;
import hbo5.it.www.dataaccess.DAVluchtBemanning;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author c1044217
 */
@WebServlet(name = "InlogServlet", urlPatterns = {"/InlogServlet"}, initParams = {
    @WebInitParam(name = "url", value = "jdbc:oracle:thin:@itf-oracledb01.thomasmore.be:1521:XE")
    , @WebInitParam(name = "login", value = "C1044217")
    , @WebInitParam(name = "password", value = "1234")
    , @WebInitParam(name = "driver", value = "oracle.jdbc.driver.OracleDriver")})

public class InlogServlet extends HttpServlet {

    private DAPersoon daPersoon = null;
    public DALuchthaven daLuchtHaven = null;
    public DALuchtvaartmaatschappij daLuchtvaartmaatschappij = null;
    public DALand daLand = null;
    public DAHangar daHangar = null;
    public DAVliegtuig daPlane = null;    
    public DAVluchtBemanning daVluchtbemanning = null;
    public String username = null;
    public String password = null;
    public String usernameError = null;
    public String passError = null;
    public String usernameTry = null;
    public boolean saveChangesValid = true;
    public String editing = null;

    //<editor-fold desc="profile">
    public Persoon profilePersoon = null;
    public String profileUsername;
    public String profileStraat;
    public String profileVoornaam;
    public String profileFamilienaam;
    public String profileHuisnr;
    public String profilePostcode;
    public String profileWoonplaats;
    public String profileLand;
    public String profileGeboortedatum;

    //</editor-fold>
    @Override
    public void init() throws ServletException {
        try {
            String url = getInitParameter("url");
            String password = getInitParameter("password");
            String login = getInitParameter("login");
            String driver = getInitParameter("driver");
            if (daPersoon == null) {
                daPersoon = new DAPersoon(url, login, password, driver);
            }
            if (daLuchtHaven == null) {
                daLuchtHaven = new DALuchthaven(url, login, password, driver);
            }
            if (daLand == null) {
                daLand = new DALand(url, login, password, driver);
            }
            if (daHangar == null) {
                daHangar = new DAHangar(url, login, password, driver);
            }
            if (daPlane == null) {
                daPlane = new DAVliegtuig(url, login, password, driver);
            }
            if (daVluchtbemanning == null) {
                daVluchtbemanning = new DAVluchtBemanning(url, login, password, driver);
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

        session.setAttribute("editing", editing);
        session.setAttribute("profilePersoon", profilePersoon);

        //<editor-fold desc="buttonForwards">
        if (request.getParameter("forgotpassKnop") != null) {
            rd = request.getRequestDispatcher("forgotpass.jsp");
        }
        if (request.getParameter("registerKnop") != null) {
            password = request.getParameter("password");
            usernameError = null;
            passError = null;
            session.setAttribute("usernameError", usernameError);
            session.setAttribute("passError", passError);
            rd = request.getRequestDispatcher("register.jsp");
        }
        if (request.getParameter("editingKnop") != null) {
            editing = "editing";
            session.setAttribute("editing", editing);
            rd = request.getRequestDispatcher("profile.jsp");
        }
        if (request.getParameter("cancelKnop") != null) {
            editing = null;
            session.setAttribute("editing", editing);
            rd = request.getRequestDispatcher("profile.jsp");
        }
        if (request.getAttribute("logoutKnop") != null) {
            profilePersoon = null;
            editing = null;
            usernameTry = null;
            session.setAttribute("editing", editing);
            session.setAttribute("profilePersoon", profilePersoon);
            session.setAttribute("usernametry", usernameTry);
            rd = request.getRequestDispatcher("index.jsp");
        }
        
        if (request.getParameter("crewKnop") != null) {
              ArrayList<VluchtBemanning> agenda = daVluchtbemanning.getAgenda();
              request.setAttribute("agenda", agenda);
              rd = request.getRequestDispatcher("agendaCrew.jsp");
        }

        if (request.getAttribute("reisSchemaKnop") != null) {
            rd = request.getRequestDispatcher("agendaCrew.jsp");
        }
        //</editor-fold>

        //<editor-fold desc="login">
        if (request.getParameter("userloginKnop") != null) {
            if (request.getParameter("username") != null && !request.getParameter("username").isEmpty()) {
                username = request.getParameter("username");
                password = request.getParameter("password");
                usernameError = null;
                passError = null;
                session.setAttribute("usernameError", usernameError);
                session.setAttribute("passError", passError);
                Persoon persoon = daPersoon.getPersoonByName(username);
                if (persoon != null) {
                    if (persoon.getPaswoord().equals(password)) {
                        session.setAttribute("usernametry", username);
                        usernameTry = username;
                        profilePersoon = persoon;
                        session.setAttribute("profilePersoon", profilePersoon);
                        rd = request.getRequestDispatcher("index.jsp");
                        usernameError = null;
                        passError = null;
                        session.setAttribute("usernameError", usernameError);
                        session.setAttribute("passError", passError);
                    } else {
                        passError = "Wrong Password!";
                        if (request.getParameter("password").isEmpty()) {
                            passError = "No password given!";
                        }
                        session.setAttribute("passError", passError);
                        rd = request.getRequestDispatcher("login.jsp");
                    }
                } else {
                    usernameError = "Doesn't exist";
                    session.setAttribute("usernameError", usernameError);
                    rd = request.getRequestDispatcher("login.jsp");
                }
            } else {
                if (request.getParameter("password").isEmpty()) {
                    passError = "No password given!";
                }

                usernameError = "No username given";
                session.setAttribute("usernameError", usernameError);
                session.setAttribute("passError", passError);
                rd = request.getRequestDispatcher("login.jsp");
            }
        }

        //</editor-fold>
        //<editor-fold desc="register">
        if (request.getParameter("signup") != null) {
            if (request.getParameter("username") != null && !request.getParameter("username").isEmpty()) {
                username = request.getParameter("username");
                password = request.getParameter("password");
                usernameError = null;
                session.setAttribute("usernameError", usernameError);
                Persoon persoon = daPersoon.getPersoonByName(username);
                if (persoon == null) {
                    session.setAttribute("usernametry", username);
                    daPersoon.insertPersoon(username, password);
                    profilePersoon = daPersoon.getPersoonByName(username);
                    session.setAttribute("profilePersoon", profilePersoon);
                    rd = request.getRequestDispatcher("index.jsp");
                    usernameError = null;
                    session.setAttribute("usernameError", usernameError);
                } else {
                    usernameError = "Username already exists";
                    session.setAttribute("usernameError", usernameError);
                    rd = request.getRequestDispatcher("login.jsp");
                }
            } else {
                usernameError = "No username given";
                session.setAttribute("usernameError", usernameError);
                rd = request.getRequestDispatcher("login.jsp");
            }
        }

        //</editor-fold>
        //<editor-fold desc="profileSave">
        if (request.getParameter("saveprofileKnop") != null) {
            if (request.getParameter("profileVoornaam").isEmpty()) {
                saveChangesValid = false;
            }
            if (request.getParameter("profileFamilienaam").isEmpty()) {
                saveChangesValid = false;
            }
            if (request.getParameter("profileLand").isEmpty()) {
                saveChangesValid = false;
            }
            if (request.getParameter("profilePostcode").isEmpty()) {
                saveChangesValid = false;
            }
            if (request.getParameter("profileStraat").isEmpty()) {
                saveChangesValid = false;
            }
            if (request.getParameter("profileHuisnummer").isEmpty()) {
                saveChangesValid = false;
            }
            if (request.getParameter("profileWoonplaats").isEmpty()) {
                saveChangesValid = false;
            }
            if (saveChangesValid) {
                profileVoornaam = request.getParameter("profileVoornaam");
                profileFamilienaam = request.getParameter("profileFamilienaam");
                profileHuisnr = request.getParameter("profileHuisnummer");
                profileStraat = request.getParameter("profileStraat");
                profilePostcode = request.getParameter("profilePostcode");
                profileWoonplaats = request.getParameter("profileWoonplaats");
                profileLand = request.getParameter("profileLand");
                profileGeboortedatum = request.getParameter("profileGeboortedatum");
                int persoonId = profilePersoon.getId();
                daPersoon.updatePersoon(persoonId, profileVoornaam, profileFamilienaam, profileStraat, profileHuisnr, profilePostcode, profileWoonplaats, profileLand, profileGeboortedatum);
                profilePersoon = daPersoon.getPersoonByName(username);
                session.setAttribute("profilePersoon", profilePersoon);
                editing = null;
                rd = request.getRequestDispatcher("profile.jsp");
            } else {
                editing = null;
                session.setAttribute("editing", editing);
                rd = request.getRequestDispatcher("profile.jsp");
            }
        }

        //</editor-fold>
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