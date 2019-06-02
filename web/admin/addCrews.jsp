<%-- 
    Document   : forgotpass
    Created on : 14-mei-2019, 10:00:37
    Author     : c1044217
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="includes/head.jsp" %>
    </head>
    <body>
        <%ArrayList<Luchtvaartmaatschappij> luchtvaartmaatschappijen = (ArrayList<Luchtvaartmaatschappij>) request.getAttribute("luchtvaartmaatschappijen");%>
        <%ArrayList<Persoon> personen = (ArrayList<Persoon>) request.getAttribute("personen");%>
        <%ArrayList<Functie> functies = (ArrayList<Functie>) request.getAttribute("functies");%>
        <%@include file="includes/navbar.jsp" %>


        <div class="bookingbox box">
            <div class="mx-auto text-center loginfield">
                <form action="AdminServlet">

                    <p>
                        <label for="crewname">bemanningslid naam:</label>
                        <input type ="text" id="crewname" value="" name="crewname"/>



                        <label for="luchtvaartmaatschappijId">luchtvaartmaatschappij:</label>
                        <select name="luchtvaartmaatschappijId">
                            <% for (Luchtvaartmaatschappij landluchtvaartmaatschappij : luchtvaartmaatschappijen) {%>

                            <option value="<%=landluchtvaartmaatschappij.getId()%>" id ="luchtvaartmaatschappijIdoption" name="landidoption"><%=landluchtvaartmaatschappij.()%></option>

                            <%}%>
                        </select>
                        
                        <label for="persoonId">persoon: </label>
                        <select name="persoonId">
                            <% for (Persoon persoon : personen) {%>

                            <option value="<%=persoon.getId()%>" id ="landidoption" name="persoonIdoption"><%=persoon.getLandnaam()%></option>

                            <%}%>
                        </select>
                        
                        <label for="functieId">functie: </label>
                        <select name="functieId">
                            <% for (Functie functie : functies) {%>
                            <option value="<%=functie.getId()%>" id ="landidoption" name="functieIdoption"><%=functie.getLandnaam()%></option>
                            <%}%>
                        </select>


                    </p> 

                    <div class="form-group loginbutton-m-bot w-25 logininputs">
                        <input class="loginbuttoncolors" type="submit" value="Save Changes" name="airportSaveAddKnop"/>
                    </div>
                    <div class="form-group cancelbutton-m-bot w-25 logininputs">
                        <input class="loginbuttoncolors" type="submit" value="Cancel" name="airportCancelKnop"/>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
