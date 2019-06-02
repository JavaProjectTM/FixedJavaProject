<%-- 
    Document   : forgotpass
    Created on : 14-mei-2019, 10:00:37
    Author     : c1044217
--%>

<%@page import="hbo5.it.www.beans.Functie"%>
<%@page import="hbo5.it.www.beans.Persoon"%>
<%@page import="hbo5.it.www.beans.Luchtvaartmaatschappij"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../includes/head.jsp" %>
    </head>
    <body>
        <%ArrayList<Luchtvaartmaatschappij> luchtvaartmaatschappijen = (ArrayList<Luchtvaartmaatschappij>) request.getAttribute("luchtvaartmaatschappijen");%>
        <%ArrayList<Persoon> personen = (ArrayList<Persoon>) request.getAttribute("personen");%>
        <%ArrayList<Functie> functies = (ArrayList<Functie>) request.getAttribute("functies");%>
        <%@include file="../includes/navbar.jsp" %>


        <div class="bookingbox box">
            <div class="mx-auto text-center loginfield">
                <form action="AdminServlet">

                    <p>
                        


                        <label for="luchtvaartmaatschappijId">luchtvaartmaatschappij:</label>
                        <select name="luchtvaartmaatschappijId">
                            <% for (Luchtvaartmaatschappij landluchtvaartmaatschappij : luchtvaartmaatschappijen) {%>

                            <option value="<%=landluchtvaartmaatschappij.getId()%>" id ="luchtvaartmaatschappijIdoption" name="landidoption"><%=landluchtvaartmaatschappij.getLuchtvaartNaam()%></option>

                            <%}%>
                        </select>
                        
                        <label for="persoonId">persoon: </label>
                        <select name="persoonId">
                            <% for (Persoon persoon : personen) {%>

                            <option value="<%=persoon.getId()%>" id ="landidoption" name="persoonIdoption"><%=persoon.getVoornaam()%></option>

                            <%}%>
                        </select>
                        
                        <label for="functieId">functie: </label>
                        <select name="functieId">
                            <% for (Functie functie : functies) {%>
                            <option value="<%=functie.getId()%>" id ="landidoption" name="functieIdoption"><%=functie.getOmschrijving()%></option>
                            <%}%>
                        </select>


                    </p> 

                    <div class="form-group loginbutton-m-bot w-25 logininputs">
                        <input class="loginbuttoncolors" type="submit" value="Save Changes" name="crewSaveAddKnop"/>
                    </div>
                    <div class="form-group cancelbutton-m-bot w-25 logininputs">
                        <input class="loginbuttoncolors" type="submit" value="Cancel" name="airportCancelKnop"/>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
