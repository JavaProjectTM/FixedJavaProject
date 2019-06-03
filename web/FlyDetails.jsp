<%-- 
    Document   : FlyDetails
    Created on : May 29, 2019, 9:57:24 AM
    Author     : Sven
--%>
<%@page import="hbo5.it.www.beans.Luchtvaartmaatschappij"%>
<%@page import="hbo5.it.www.beans.Vliegtuig"%>
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
        <%@include file="includes/navbar.jsp" %>
        <div class="bookingbox box">
            <form action="ManageServlet">



                <div class="mx-auto text-center loginfield">
                    <h1 class="caption">Vlucht details (kunnen met testen aangepast zijn)</h1>
                    <%Vlucht vluchtGegevens = (Vlucht) request.getAttribute("VluchtGegevens");%>
                    <%Vliegtuig vliegtuigGegevens = (Vliegtuig) request.getAttribute("VliegtuigGegevens");%>
                    <%Luchthaven aankomstluchthavenGegevens = (Luchthaven) request.getAttribute("AankomstLuchthavenGegevens");%>
                    <%Luchthaven vertrekluchthavenGegevens = (Luchthaven) request.getAttribute("VertrekLuchthavenGegevens");%>
                    <%VliegtuigType vliegtuigTypeGegegevens = (VliegtuigType) request.getAttribute("vliegtuigTypeGegevens");%>
                    <%Luchtvaartmaatschappij luchtvaartmaatschappijGegegevens = (Luchtvaartmaatschappij) request.getAttribute("luchtvaartmaatschappijGegegevens");%>
                    <%int passagierCount=(Integer)request.getAttribute("personenCount");%>



                    
                    <h2>aantal passagiers: <%=passagierCount%></h2>
                    <h2>Code: <%=vluchtGegevens.getCode()%></h2>
                    <hr>
                    <h2>Vertrektijd: <%=vluchtGegevens.getVertrekTijd()%></h2>
                    <h2>aankomsttijd: <%=vluchtGegevens.getAankomstTijd()%></h2>
                    <hr>
                    <h2>Luchtvaartmaatschappij: <%=luchtvaartmaatschappijGegegevens.getLuchtvaartNaam()%></h2>
                    <h2>Vliegtuigtype: <%=vliegtuigTypeGegegevens.getTypenaam()%></h2>
                    <hr>
                    <h2>Vertrekluchthaven:  <%=vertrekluchthavenGegevens.getLuchthavennaam()%></h2>
                    <h2>Stad vertrekluchthaven:  <%=vertrekluchthavenGegevens.getStad()%></h2>
                    <hr>
                    <h2>Aankomstluchthaven:  <%=aankomstluchthavenGegevens.getLuchthavennaam()%></h2>
                    <h2>Stad aankomstluchthaven:  <%=aankomstluchthavenGegevens.getStad()%></h2>







            </form>
        </div>

    </div>

</body>
</html>
