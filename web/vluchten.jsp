<%-- 
    Document   : vluchten
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
        
    </head>
    <body>
                <form action="ManageServlet">
         <%@include file="includes/navbar.jsp" %>
        
                    
        <%ArrayList<Vlucht> vluchten = (ArrayList<Vlucht>) request.getAttribute("vluchten");%>
        
        
        <h1>Alle vluchten</h1>
        <table style="width:100%">
<tr >
    <th><b>id</b></th>
    <th><b>Code</b></th>
    <th><b>Vertrektijd</b></th>
    <th><b>Aankomsttijd</b></th>
    <th><b>Vliegtuigtype</b></th>
    <th><b>vertrekluchthaven</b></th>
    <th><b>AankomstLuchthaven</b></th>
</tr>
        
        
            <% for (Vlucht vlucht : vluchten){%>
            
            <tr >
            <td><%=vlucht.getId()%> </td>
            <td>    <%=vlucht.getVertrekTijd()%></td>
            <td>   <%=vlucht.getAankomstTijd()%></td>
                <%VliegtuigType VT = vlucht.getVliegtuigType();%>
            <td>   <%=VT.getTypenaam()%></td>
                <% Luchthaven VL = vlucht.getVertrekLuchthaven();%>
            <td>  <%=VL.getLuchthavennaam()%></td>
                <%Luchthaven AL = vlucht.getAankomstLuchthaven();%>
            <td>      <%=AL.getLuchthavennaam()%></td>
                
                </tr>
            </div
            <%}%>
            
            
            
        </table>
        </form>
        
    </body>

    
</html>
