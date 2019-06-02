/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www;

import hbo5.it.www.beans.Passagier;
import hbo5.it.www.beans.Persoon;
import hbo5.it.www.beans.Vlucht;
import hbo5.it.www.beans.VluchtBemanning;
import hbo5.it.www.dataaccess.DAPassagier;
import hbo5.it.www.dataaccess.DAVlucht;
import hbo5.it.www.dataaccess.DAVluchtBemanning;
import java.io.IOException;
import java.util.ArrayList;
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
@WebServlet(name = "ManageServlet", urlPatterns = {"/ManageServlet"}, initParams = {
    @WebInitParam(name = "url", value = "jdbc:oracle:thin:@itf-oracledb01.thomasmore.be:1521:XE")
    , @WebInitParam(name = "login", value = "C1044217")
    , @WebInitParam(name = "password", value = "1234")
    , @WebInitParam(name = "driver", value = "oracle.jdbc.driver.OracleDriver")})
public class ManageServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private DAVlucht davlucht = null;
    
    private String usernameTry = null;
    private Persoon persoon = null;
    private DAVluchtBemanning davluchtbemanning = null;
    private DAPassagier daPassagier;
    private DAVlucht daVlucht;
    
    public void init() throws ServletException{
        try{
            String url = getInitParameter("url");
            String login = getInitParameter("login");
            String password = getInitParameter("password");
            String driver = getInitParameter("driver");
            if (davlucht == null) {
                davlucht = new DAVlucht(url,login,password,driver);
            }
            if (davluchtbemanning == null) {
                davluchtbemanning = new DAVluchtBemanning(url,login,password,driver);
            }
                         if (daPassagier == null) {
                daPassagier = new DAPassagier(url,login,password,driver);
            }
             if (daVlucht == null){
                 daVlucht = new DAVlucht(url,login,password,driver);
             }
        }
        catch(ClassNotFoundException e){
            throw new ServletException(e);
            
        }
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = null;
        HttpSession session = request.getSession();
        
        if (request.getParameter("loginpageKnop") != null) {
            rd = request.getRequestDispatcher("login.jsp");
        }
        if (request.getParameter("indexKnop") != null) {
            rd = request.getRequestDispatcher("index.jsp");
        }
        if (request.getParameter("aboutKnop") != null) {
            rd = request.getRequestDispatcher("about.jsp");
            ArrayList<Vlucht> vluchten = davlucht.getVluchtGegevens();
            request.setAttribute("vluchten", vluchten);
        }
        if (request.getParameter("profilepageKnop") != null) {
            rd = request.getRequestDispatcher("profile.jsp");
        }
        if (request.getParameter("crewKnop") != null) {
             rd = request.getRequestDispatcher("agendaCrew.jsp");
              ArrayList<VluchtBemanning> agenda = davluchtbemanning.getAgenda();
              request.setAttribute("agenda", agenda);
           
        }
        
        if (request.getParameter("logoutKnop") != null) {
            request.setAttribute("logoutKnop", request.getParameter("logoutKnop") );
            rd = request.getRequestDispatcher("InlogServlet");
        }  
        if (request.getParameter("vluchtid") != null) {
             int vluchtid = Integer.parseInt(request.getParameter("vluchtid")); 
             //ArrayList<Vlucht> vluchten = davlucht.getVluchtGegevens(vluchtid);
             Vlucht VluchtGegevens = davlucht.getVluchtGegevens(vluchtid);
             //methode aanpassen en vlucht object van maken
             request.setAttribute("VluchtGegevens", VluchtGegevens);
             rd = request.getRequestDispatcher("FlyDetails.jsp");
        }
        if (request.getParameter("passagiersVlucht")!=null){       
        rd = request.getRequestDispatcher("passagierLijst.jsp");
        ArrayList<Passagier> passagiers = daPassagier.getPassagiers();
        request.setAttribute("passagiers", passagiers);
         int vluchtid = Integer.parseInt(request.getParameter("passagiersVlucht"));             
         Vlucht vlucht = davlucht.getVluchtGegevens(vluchtid);
         request.setAttribute("vlucht", vlucht);
         rd.forward(request, response);
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
