<%-- 
    Document   : manageCrews
    Created on : 29-mei-2019, 9:23:42
    Author     : c1044217
--%>

<%@page import="hbo5.it.www.beans.Luchtvaartmaatschappij"%>
<%@page import="hbo5.it.www.beans.Bemanningslid"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../includes/head.jsp" %>
    </head>
    <body>
        <%@include file="../includes/navbar.jsp" %>
            <div class="bookingbox box">
                <div class="mx-auto text-center loginfield">
                        <form action="AdminServlet">
                            <%ArrayList<Bemanningslid> bemanningsleden = (ArrayList<Bemanningslid>) request.getAttribute("bemanningsleden");%>
                            
                            <h1 class="caption">All crewmembers</h1>
                            <table  id="#VluchtTable" class="table VluchtTable">
                                <tr >
                                    <th><b>luchtvaarmaatschappij ID </b></th>
                                    <th><b>persoon ID</b></th>
                                    <th><b>Functie ID</b></th>

                                    
                                </tr>
                                <% for (Bemanningslid bemanningslid : bemanningsleden) {%>
                                <tr>
                                    <td><%=bemanningslid.getLuchtvaartMaatschappij_id()%></td>
                                    <td><%=bemanningslid.getPersoon_id()%></td>
                                    <td><%=bemanningslid.getFunctie_id()%></td>

                                    

                                    <div class="form-group logininputs">
                                        <td><a class="loginbutton-m-bot-c" href="AdminServlet?crewEdit=<%=bemanningslid.getId()%>" class="button">Edit</a></td>
                                    </div>
                                    <div class="form-group logininputs">
                                        <td><a class="cancelbutton-m-bot-c" href="AdminServlet?crewDelete=<%=bemanningslid.getId()%>" class="button">Delete</a></td>
                                    </div>
                                </tr>
                                <%}%>
                            </table>
                            <div class="form-group loginbutton-m-bot w-25 logininputs">
                                <input class="loginbuttoncolors" type="submit" value="Add" name="crewAddKnop"/>
                            </div>
                        </form>
                </div>
            </div>
    </body>
</html>