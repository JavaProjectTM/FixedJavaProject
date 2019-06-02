<%-- 
    Document   : passagierlijst
    Created on : 29-mei-2019, 9:42:19
    Author     : Kevin
--%>

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
        <title>Passagierlijst</title>
        <%@include file="includes/head.jsp" %>
        
   
    </head>
    <body>
        <form action="ManageServlet">
          <%ArrayList<Passagier> passagiers = (ArrayList<Passagier>) request.getAttribute("passagiers");%>
         <%Vlucht vlucht = (Vlucht) request.getAttribute("vlucht");%>
         
         <h1 class="BaseCss"><%=vlucht.getCode()%></h1>
         
         <table  id="#VluchtTable" class="table VluchtTable">
                <tr>
                    <th scope ="row" ><b>id</b></th>
                    <th><b>Code</b></th>
                    <th><b>Vertrektijd</b></th>
                    <th><b>Aankomsttijd</b></th>
                    <th><b>Vliegtuigtype</b></th>
                    <th><b>vertrekluchthaven</b></th>
                    <th><b>AankomstLuchthaven</b></th>
                    <th><b>Meer info</b></th>
                </tr>
                <%VliegtuigType VT = vlucht.getVliegtuigType();%>
                <% Luchthaven VL = vlucht.getVertrekLuchthaven();%>
                <%Luchthaven AL = vlucht.getAankomstLuchthaven();%>
                <tr>
                    <td><%=vlucht.getId()%> </td>
                    <td><%=vlucht.getCode()%></td>
                    <td><%=vlucht.getVertrekTijd()%></td>
                    <td><%=vlucht.getAankomstTijd()%></td>
                    <td><%=VT.getTypenaam()%></td>
                    <td><%=VL.getLuchthavennaam()%></td>
                    <td><%=AL.getLuchthavennaam()%></td>
                    <td><a href="ManageServlet?vluchtid=<%=vlucht.getId()%>" class="button">Details</a></td>

                </tr>             
         </table>
         <table  id="#VluchtTable" class="table VluchtTable">
                <tr >
                    <th><b>id</b></th>
                    <th><b>Voornaam</b></th>
                    <th><b>Familienaam</b></th>

                </tr>
                
                 <% for (Passagier passagier : passagiers) {%>
                <%Persoon persoon = passagier.getPersoon();%>
                <tr>
                    <td><%=passagier.getId()%> </td>
                    <td><%=persoon.getVoornaam()%></td>
                    <td><%=persoon.getFamilienaam()%></td>

                </tr>
                <%}%>
            </table>
        </form>
    </body>
</html>
