<%-- 
    Document   : managePlanes
    Created on : 29-mei-2019, 9:23:55
    Author     : c1044217
--%>

<%@page import="hbo5.it.www.dataaccess.DALuchtvaartmaatschappij"%>
<%@page import="hbo5.it.www.dataaccess.DAVliegtuigType"%>
<%@page import="hbo5.it.www.dataaccess.DAVliegtuig"%>
<%@page import="hbo5.it.www.beans.Vliegtuig"%>
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
                        <%ArrayList<Vliegtuig> vliegtuigen = (ArrayList<Vliegtuig>) request.getAttribute("vliegtuigen");%>
                            <h1 class="caption">All Planes</h1>
                            <table  id="#VluchtTable" class="table VluchtTable">
                                <tr >
                                    <th><b>Type</b></th>   
                                    <th><b>Airline</b></th>  
                                </tr>
                                <% for (Vliegtuig vliegtuig : vliegtuigen) {%>
                                <tr>
                                    <td><%int vliegtuigId =vliegtuig.getVliegtuigType_id();
                                        DAVliegtuigType davliegtuigtype = (DAVliegtuigType) request.getAttribute("daVliegtuigtype");
                                        String vliegtuigtype = davliegtuigtype.getVliegtuigTypeById(vliegtuigId);
                                        %>
                                        <%=vliegtuigtype%>
                                    </td>
                                    <td><%int luchtvaartId =vliegtuig.getLuchtvaartMaatschappij_id();
                                        DALuchtvaartmaatschappij daLuchtvaart = (DALuchtvaartmaatschappij) request.getAttribute("daLuchtvaartmaatschappij");
                                        String luchtvaart = daLuchtvaart.getLuchtvaartById(luchtvaartId);
                                        %>
                                        <%=luchtvaart%>
                                    <div class="form-group logininputs">
                                        <td><a class="loginbutton-m-bot-c" href="AdminServlet?luchtvaartEdit=<%=vliegtuig.getId()%>" class="button">Edit</a></td>
                                    </div>
                                    <div class="form-group logininputs">
                                        <td><a class="cancelbutton-m-bot-c" href="AdminServlet?luchtvaartDelete=<%=vliegtuig.getId()%>" class="button">Delete</a></td>
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