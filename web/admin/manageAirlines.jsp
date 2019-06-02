<%-- 
    Document   : manageAirlines
    Created on : 29-mei-2019, 9:23:31
    Author     : c1044217
--%>

<%@page import="hbo5.it.www.beans.Luchtvaartmaatschappij"%>
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
                        <%ArrayList<Luchtvaartmaatschappij> luchtvaartmaatschappijen = (ArrayList<Luchtvaartmaatschappij>) request.getAttribute("luchtvaartmaatschappijen");%>
                            <h1 class="caption">All Airlines</h1>
                            <table  id="#VluchtTable" class="table VluchtTable">
                                <tr >
                                    <th><b>Name</b></th>    
                                </tr>
                                <% for (Luchtvaartmaatschappij luchtvaartmaatschappij : luchtvaartmaatschappijen) {%>
                                <tr>
                                    <td><%=luchtvaartmaatschappij.getLuchtvaartNaam()%> </td>
                                <div class="form-group logininputs">
                                    <td><a class="loginbutton-m-bot-c" href="AdminServlet?luchtvaartEdit=<%=luchtvaartmaatschappij.getId()%>" class="button">Edit</a></td>
                                </div>
                                <div class="form-group logininputs">
                                    <td><a class="cancelbutton-m-bot-c" href="AdminServlet?luchtvaartDelete=<%=luchtvaartmaatschappij.getId()%>" class="button">Delete</a></td>
                                </div>
                                </tr>
                                <%}%>
                            </table>
                            <div class="form-group loginbutton-m-bot w-25 logininputs">
                                <input class="loginbuttoncolors" type="submit" value="Add" name="airlineAddKnop"/>
                                
                            </div>
                        </form>
                </div>
            </div>
    </body>
</html>