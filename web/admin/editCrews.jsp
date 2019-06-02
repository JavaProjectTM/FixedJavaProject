<%-- 
    Document   : forgotpass
    Created on : 14-mei-2019, 10:00:37
    Author     : c1044217
--%>

<%@page import="hbo5.it.www.beans.Functie"%>
<%@page import="hbo5.it.www.beans.Persoon"%>
<%@page import="hbo5.it.www.beans.Luchtvaartmaatschappij"%>
<%@page import="java.util.ArrayList"%>
<%@page import="hbo5.it.www.beans.Bemanningslid"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../includes/head.jsp" %>
    </head>
    <body>
        <%@include file="../includes/navbar.jsp" %>
        <%Bemanningslid crewmember = (Bemanningslid) request.getAttribute("crewmember");%>
        
        <%ArrayList<Luchtvaartmaatschappij> luchtvaartmaatschappijen = (ArrayList<Luchtvaartmaatschappij>) request.getAttribute("luchtvaartmaatschappijen");%>
        <%ArrayList<Persoon> personen = (ArrayList<Persoon>) request.getAttribute("personen");%>
        <%ArrayList<Functie> functies = (ArrayList<Functie>) request.getAttribute("functies");%>
        
            <div class="bookingbox box">
            <div class="mx-auto text-center loginfield">
                <form action="AdminServlet">
                <p>
                    <label for="luchtvaartmaatschappijid">crew luchtvaarmaatschappij id: </label>
                    <input type ="text" id="luchtvaartmaatschappijid" value="<%=crewmember.getLuchtvaartMaatschappij_id()%>" name="luchtvaartmaatschappijid"/>
                    
                    <label for="persoonid">persoon id :</label>
                    <input type ="text" id="persoonid" value="<%=crewmember.getPersoon_id()%>" name="persoonid"/>
                    
                    <label for="functieid">functie id: </label>

                    <input type ="text" id="functieid" value="<%=crewmember.getFunctie_id()%>" name="functieid"/>

                    <input type="hidden" value="<%=crewmember.getId()%>" name="id"/>

                </p>    
                            
                <div class="mx-auto text-center loginfield">
                            <div class="form-group loginbutton-m-bot w-25 logininputs">
                                <input class="loginbuttoncolors" type="submit" value="Save Changes" name="wijzigCrew"/>
                            </div>
                            <div class="form-group cancelbutton-m-bot w-25 logininputs">
                                <input class="loginbuttoncolors" type="submit" value="Cancel" name="cancelAirportKnop"/>
                            </div>
                </div>
                

            </form>
            </div>
        </div>
    </body>
</html>
