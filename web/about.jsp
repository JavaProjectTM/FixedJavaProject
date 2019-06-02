<%-- 
    Document   : about
    Created on : 14-mei-2019, 11:13:28
    Author     : c1044217
--%>

<%@page import="hbo5.it.www.beans.VliegtuigType"%>
<%@page import="hbo5.it.www.beans.Luchthaven"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="hbo5.it.www.beans.Vlucht"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<!DOCTYPE html>
<html>
    <head>
        <%@include file="includes/head.jsp" %>
        <link rel="stylesheet" type="text/css" href="css/Styles.css"/>
        <script rel="SearchJs" src="js/SearchFunction.js"></script>
    </head>
    <body>
        <form action="ManageServlet">
            <%@include file="includes/navbar.jsp" %>

           <h1 class="BaseCss" align="center">About us</h1>
            
             <div class="bookingbox box">
            <p></p>
            <p></p>
            <p></p>
            <p></p>
            <p> 
                Welkom op onze website. Keep-It-Plane is een website bedacht door 4 HBO-5 studenten. Op onze website/app kan u verschillende vluchten boeken naar verschillende landen.</br>
                Hier kan u ook altijd de goedkoopste tickets vinden voor al uw reizen. U kan vluchten opzoeken en natuurlijk ook boeken op onze website. </p>
            
            <p> Op onze website kan u verschillende vluchten boeken naar verschillende landen.
                Wij werken samen met Tui, Lufthanza, KLM, Brussels Airlines en nog veel meer luchtvaarmaatschappijen. Zo kunnen we ervoor zorgen dat u de beste deals kan krijgen!</p> 
            <p> Op onze website kan u een account aanmaken om zo aan te melden en uw vluchten te boeken.</br>
                Voor vragen kan u ons altijd mailen op keepitplane@gmail.com, of u kan ons ook altijd telefonisch bereiken op het nummer 0032 123 456 605.</p>

             </div>
</body>


</html>
