<%-- 
    Document   : searchOverview
    Created on : 14-mei-2019, 13:09:47
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
        <form action="ZoekServlet">
        <div class="bookingbox box">
        <div class="container">            
            <input class="logintextcolors" type="submit" value="Details" name="searchOverviewDetailsKnop"/>
        </div>
        </div>
        </form>
    </body>
</html>
