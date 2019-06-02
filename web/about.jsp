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

            <%ArrayList<Vlucht> vluchten = (ArrayList<Vlucht>) request.getAttribute("vluchten");%>


            <h1 class="BaseCss">Alle vluchten</h1>





            <table  id="#VluchtTable" class="table VluchtTable">

                <tr>
                    <th>

                    </th>
                    <th>
                        <input type ="text" id="myInput" onkeyup="SearchFunction()" placeholder="Zoek" title="Typ hier de vertrekhaven">
                    </th>
                    <th>
                        <input type ="text" id="myInputVertrekTijd" onkeyup="SearchFunctionVertrekTijd()" placeholder="Zoek" title="Typ hier de vertrektijd">

                    </th>
                    <th>
                        <input type ="text" id="myInputAankomstTijd" onkeyup="SearchFunctionAankomstTijd()" placeholder="Zoek" title="Typ hier de aakomsttijd">

                    </th>
                    <th>
                        <input type ="text" id="myInput1" onkeyup="SearchFunction1()" placeholder="Zoek" title="Typ hier de aankomsthaven">
                    </th>
                    <th>
                        <input type ="text" id="myInput2" onkeyup="SearchFunction2()" placeholder="Zoek" title="Typ hier de aankomsthaven">
                    </th>
                    <th>
                        <input type ="text" id="myInput3" onkeyup="SearchFunction3()" placeholder="Zoek" title="Typ hier de aankomsthaven">

                    </th>
                    <th></th>
                </tr>

                <tr >
                    <th scope ="row" ><b>id</b></th>
                    <th><b>Code</b></th>
                    <th><b>Vertrektijd</b></th>
                    <th><b>Aankomsttijd</b></th>
                    <th><b>Vliegtuigtype</b></th>
                    <th><b>vertrekluchthaven</b></th>
                    <th><b>AankomstLuchthaven</b></th>
                    <th><b>Meer info</b></th>
                </tr>
                <% for (Vlucht vlucht : vluchten) {%>
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
                <%}%>

            </table>
        </form>

    </script>

</body>


</html>
