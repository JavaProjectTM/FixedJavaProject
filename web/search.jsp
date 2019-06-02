<%-- 
    Document   : zoekscherm
    Created on : 14-mei-2019, 12:49:42
    Author     : c1044217
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="includes/head.jsp" %>
    </head>
    <body>
        <%@include file="includes/navbar.jsp" %>
    </body>
    <form action="ZoekServlet">
    <div class="bookingbox box">
        <div class="container">
            <input class="logintextcolors" type="submit" value="allPlanesKnop" name="allPlanesKnop"/>
            
            
            <a class="row">Departing planes overview<a/>
            <a class="row">flight number
            <input id="name" style="border: 1px solid" name="flight number">
            </a>
            <a class="row">date
            <input style="border: 1px solid" type="text" id="name" name="date">
            </a>
            <a class="row">destination
            <input style="border: 1px solid" type="text" id="name" name="destination">
            </a>
            <a class="row">airline
            <input style="border: 1px solid" type="text" id="name" name="airline">
            </a>            
            <input class="logintextcolors" type="submit" value="Search Flights" name="searchOverviewKnop"/>
        </div>
    </div>
    </form>
</html>
