<%-- 
    Document   : booking
    Created on : 1-juni-2019, 15:48:36
    Author     : Kevin
--%>

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
        <title>Boek een vlucht</title>
        <%@include file="includes/head.jsp" %>       
    </head>
    <body>
        <form action="ManageServlet">
            <%ArrayList<Vlucht> vluchten = (ArrayList<Vlucht>) request.getAttribute("vluchten");%>
            <h1 class="BaseCss">Boek een vlucht</h1>

            <table  id="#VluchtTable" class="table VluchtTable">
                <tr>
                    <th><b>Aantal volwassenen</b></th>
                    <th><b>Aantal kinderen</b></th>
                    <th><b>Bagage</b></th>
                    <th><b>Handbagage</b></th>
                    <th><b>Aankomst</b></th>
                    <th><b>Datum</b></th>
                </tr>
                <tr>
                    <td>
                        <select name="aantalVol">
                            <% for (int i = 1; i <= 10; i++) {%>
                            <option value=<%=i%>><%=i%></option>
                            <%} %>
                        </select>
                    </td>
                    <td>
                        <select name="aantalKinderen">
                            <% for (int j = 1; j <= 10; j++) {%>
                            <option value=<%=j%>><%=j%></option>
                            <%} %>
                        </select>
                    </td>
                    <td>
                        <select name="Bagage">
                            <% for (int k = 1; k <= 10; k++) {%>
                            <% int gewicht = 5+(k*10);%>
                            <option value="<%=gewicht%>">tot <%=gewicht%>kg</option>
                            <%}%>
                        </select>
                    </td>
                    <td>
                        <select name="Handbagage">
                            <% for (int l = 1; l <= 10; l++) {%>
                            <% int massa = 5 + (l*10);%>
                            <option value="tot <%=massa%>"> tot <%=massa%>kg</option>
                            <%}%>
                        </select>
                    </td>
                    <td>
                        <select name="Aankomst">
                            <% for (Vlucht aankomstVlucht : vluchten) {%>
                            <% Luchthaven aankomstL = aankomstVlucht.getAankomstLuchthaven();%>
                            <option value="<%=aankomstL.getLuchthavennaam()%>"><%=aankomstL.getLuchthavennaam()%></option>
                            <%}%>
                        </select>
                    </td>
                    <td>
                        <select name="Datum">
                            <% for (Vlucht aankomstVlucht : vluchten) {%>
                            <% Luchthaven aankomstL = aankomstVlucht.getAankomstLuchthaven();%>
                            <option value="<%=aankomstL.getVertrekTijd()%>"><%=aankomstL.getVertrekTijd()%></option>
                            <%}%>
                            
                        </select>
                    </td>
                    <td>
                        <button name="berekenKnop"><input type="submit" value="bereken prijs"></button>
                    </td>

                </tr>             
            </table>
        </form>