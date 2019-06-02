<%-- 
    Document   : manageCrews
    Created on : 29-mei-2019, 9:23:42
    Author     : c1044217
--%>

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
                                </tr>
                                <%}%>
                            </table>
                        </form>
                </div>
            </div>
    </body>
</html>