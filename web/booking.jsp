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
                        <select name="aantalVol">
                            <% for (int i = 1; i <= 10; i++) {%>
                            <option value=<%=i%>><%=i%></option>
                            <%} %>
                        </select>
                    </td>
                    <td>
                        <select name="aantalKinderen">
                            <% for (int i = 1; i <= 10; i++) {%>
                            <option value=<%=i%>><%=i%></option>
                            <%} %>
                        </select>
                    </td>
                    <td>
                        <select name="Bagage">
                            <% for (int i = 1; i <= 10; i++) {%>
                            <option value="tot <%=5 + i * 10%> kg"<%=5 + i * 10%></option>
                            <%}%>
                        </select>
                    </td>
                    <td>
                        <select name="Handbagage">
                            <% for (int i = 1; i <= 10; i++) {%>
                            <option value="tot <%=5 + i * 3%> kg"<%=5 + i * 3%></option>
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
                            <% ArrayList<Vlucht> aankomende = new ArrayList(); %>
                            <% aankomende.add(aankomstL);%>
                            <% for (Vlucht checkV : aankomende) {%>
                            <% if (checkV.getVertrekTijd() == aankomstL.getVertrekTijd()) {%>
                            <%} else {%>
                            <option value="<%=aankomstL.getVertrekTijd()%>"><%=aankomstL.getVertrekTijd()%></option>
                            <%}%>
                            <%}%>
                            <%}%>
                        </select>
                    </td>
                    <td>
                        <button><input type="submit" value="bereken prijs"></button>
                        <% double prijs = (double) request.getAttribute("prijs");%>
                        <p><%=prijs%></p>
                        <!--stuur geselecteerde items door en bereken de prijs hiervan.-->
                    </td>
                    <td>
                      <!--  <button>boek</button> -->
                      <!-- maak een boeking object aan, knop pas tonen na prijs te berekenen -->
                    </td>
                    <td>
                    </td>

                </tr>             
            </table>
        </form>