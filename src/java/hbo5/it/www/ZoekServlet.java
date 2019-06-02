/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www;

import hbo5.it.www.beans.Vlucht;
import hbo5.it.www.dataaccess.DAVlucht;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author c1044217
 */
@WebServlet(name = "ZoekServlet", urlPatterns = {"/ZoekServlet"}, initParams = {
    @WebInitParam(name = "url", value = "jdbc:oracle:thin:@itf-oracledb01.thomasmore.be:1521:XE")
    , @WebInitParam(name = "login", value = "C1044217")
    , @WebInitParam(name = "password", value = "1234")
    , @WebInitParam(name = "driver", value = "oracle.jdbc.driver.OracleDriver")})
public class ZoekServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    public void init() throws ServletException{
        try{
            String url = getInitParameter("url");
            String login = getInitParameter("login");
            String password = getInitParameter("password");
            String driver = getInitParameter("driver");
            if (davlucht == null) {
                davlucht = new DAVlucht(url,login,password,driver);
            }
        }
        catch(ClassNotFoundException e){
            throw new ServletException(e);
            
        }
    }
    
    private DAVlucht davlucht = null;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = null;
        if (request.getParameter("loginpageKnop") != null) {
            rd = request.getRequestDispatcher("login.jsp");
        }
        if (request.getParameter("indexKnop") != null) {
            rd = request.getRequestDispatcher("index.jsp");
        }
        if (request.getParameter("bookingKnop") != null) {
            rd = request.getRequestDispatcher("search.jsp");
        }
        if (request.getParameter("searchOverviewKnop") != null) {
            rd = request.getRequestDispatcher("searchoverview.jsp");
        }
        if (request.getParameter("searchOverviewDetailsKnop") != null) {
            rd = request.getRequestDispatcher("searchOverviewDetails.jsp");
        }
        if (request.getParameter("allPlanesKnop") != null) {
            rd = request.getRequestDispatcher("vluchten.jsp");
            ArrayList<Vlucht> vluchten = davlucht.getVluchtGegevens();
            //Vlucht vlucht = davlucht.getVlucht();
            request.setAttribute("vluchten", vluchten);
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
