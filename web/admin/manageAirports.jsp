<%-- 
    Document   : manageAirports
    Created on : 29-mei-2019, 9:23:12
    Author     : c1044217
--%>

<%@page import="hbo5.it.www.dataaccess.DALand"%>
<%@page import="java.util.ArrayList"%>
<%@page import="hbo5.it.www.beans.Luchthaven"%>
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
                        <%ArrayList<Luchthaven> luchthavens = (ArrayList<Luchthaven>) request.getAttribute("luchthavens");%>
                            <h1 class="caption">All Airports</h1>
                            <table  id="#VluchtTable" class="table VluchtTable">
                                <tr >
                                    <th><b>Name</b></th>    
                                    <th><b>City</b></th>
                                    <th><b>Country</b></th>
                                </tr>
                                <% for (Luchthaven luchthaven : luchthavens) {%>
                                <tr>
                                    
                                    <td><%=luchthaven.getLuchthavennaam()%> </td>
                                    <td><%=luchthaven.getStad()%></td>
                                    <td><%int landId = luchthaven.getLand_id();
                                        DALand land = (DALand) request.getAttribute("daLand");
                                        String landNaam = land.getLandById(landId);
                                        %>
                                        <%=landNaam%>
                                <div class="form-group logininputs">
                                    <td><a class="loginbutton-m-bot-c" href="AdminServlet?luchtvaartEdit=<%=luchthaven.getId()%>" class="button">Edit</a></td>
                                </div>
                                <div class="form-group logininputs">
                                    <td><a class="cancelbutton-m-bot-c" href="AdminServlet?luchtvaartDelete=<%=luchthaven.getId()%>" class="button">Delete</a></td>
                                </div>
                                </tr>
                                <%}%>
                            </table>
                            <div class="form-group loginbutton-m-bot w-25 logininputs">
                                <input class="loginbuttoncolors" type="submit" value="Add" name="airlineAddKnop"/>
                            </div>
                </div>
            </div>
    </body>
</html>
