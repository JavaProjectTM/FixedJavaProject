<%-- 
    Document   : FlyDetails
    Created on : May 29, 2019, 9:57:24 AM
    Author     : Sven
--%>
<%@page import="hbo5.it.www.beans.VliegtuigType"%>
<%@page import="hbo5.it.www.beans.Luchthaven"%>
<%@page import="hbo5.it.www.beans.Vlucht"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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


            <h1 class="BaseCss">Vlucht details</h1>
            <%Vlucht vluchtGegevens = (Vlucht) request.getAttribute("VluchtGegevens");%>

            <%VliegtuigType VT = vluchtGegevens.getVliegtuigType();%>
            <% Luchthaven VL = vluchtGegevens.getVertrekLuchthaven();%>
            <%Luchthaven AL = vluchtGegevens.getAankomstLuchthaven();%>


            <h2><%=vluchtGegevens.getId()%></h2>
            <h2><%=vluchtGegevens.getCode()%></h2>
            <h2><%=vluchtGegevens.getVertrekTijd()%></h2>
            <h2><%=vluchtGegevens.getAankomstTijd()%></h2>
            <h2><%=VT.getTypenaam()%></h2>
            <h2><%=vluchtGegevens.getAankomstLuchthaven()%></h2>

            
            <h2><%=VL.getLuchthavennaam()%></h2>
            <h2><%=AL.getLuchthavennaam()%></h2>
            <h2><%=vluchtGegevens.getVertrekTijd()%></h2>
            <h2><%=vluchtGegevens.getVertrekTijd()%></h2>





        </form>

    </body>
</html>
