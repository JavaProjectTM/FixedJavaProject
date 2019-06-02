<%-- 
    Document   : booking
    Created on : 1-juni-2019, 15:48:36
    Author     : Kevin
--%>

<%@page import="hbo5.it.www.beans.Boeking"%>
<%@page import="hbo5.it.www.beans.Land"%>
<%@page import="hbo5.it.www.beans.Passagier"%>
<%@page import="hbo5.it.www.beans.Persoon"%>
<%@page import="java.util.ArrayList"%>
<%@page import="hbo5.it.www.beans.Luchthaven"%>
<%@page import="hbo5.it.www.beans.VliegtuigType"%>
<%@page import="hbo5.it.www.beans.Vlucht"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="includes/navbar.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Overzicht</title>
        <%@include file="includes/head.jsp" %>       
    </head>
    <body>
        <form action="ManageServlet">
            <%Boeking boeking = (Boeking) request.getAttribute("boeking");%>
            <h1 class="BaseCss">Boek een vlucht</h1>

            <table  id="#VluchtTable" class="table VluchtTable">
                <tr>
                    <th scope ="row" ><b>id</b></th>
                    <th><b>Aantal volwassenen</b></th>
                    <th><b>Aantal kinderen</b></th>
                    <th><b>Bagage</b></th>
                    <th><b>Handbagage</b></th>
                    <th><b>Aankomst</b></th>
                    <th><b>Datum</b></th>
                    <th><b>Prijs</b></th>
                </tr>
                <tr>
                    <td>
                       <%=boeking.getAantalVolwassenen()%>
                    </td>
                    <td>
                        <%=boeking.getAantalKinderen()%>
                    </td>
                    <td>
                        <%=boeking.getBagage()%>
                    </td>
                    <td>
                        <%=boeking.getHandbagage()%>
                    </td>
                    <td>
                      <%=boeking.getAankomst()%>
                    </td>
                    <td>
                        <%=boeking.getDatum()%>
                    </td>
                    <td>
                        <%=boeking.getPrice()%>
                    </td>
                    <td>
                      <button><input type="submit" value="boek uw vlucht!"></button>
                    </td>
                    <td>
                    </td>

                </tr>             
            </table>
        </form>