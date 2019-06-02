<%-- 
    Document   : index
    Created on : 30-apr-2019, 12:53:54
    Author     : c1044217
--%>

<%@page import="hbo5.it.www.beans.Persoon"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="includes/head.jsp" %>
        
    </head>
    <body>
        <%@include file="includes/navbar.jsp" %>
        <form action="AdminServlet">
        <%Persoon persoon = (Persoon) session.getAttribute("profilePersoon");
        if (persoon != null) {
        if( persoon.getSoort()=='A')  {%>     
            <div class="managebox box">
                <div class="mx-auto text-center loginfield">
                    <h3 class="login-m-bot">Management</h3>
                    <div class="form-group loginbutton-m-bot w-25 logininputs">
                        <input class="loginbuttoncolors" type="submit" value="Airports" name="airportManageKnop"/>
                    </div>
                    <div class="form-group loginbutton-m-bot w-25 logininputs">
                        <input class="loginbuttoncolors" type="submit" value="Airlines" name="airlineManageKnop"/>
                    </div>
                    <div class="form-group loginbutton-m-bot w-25 logininputs">
                        <input class="loginbuttoncolors" type="submit" value="Planes" name="planesManageKnop"/>
                    </div>
                    <div class="form-group loginbutton-m-bot w-25 logininputs">
                        <input class="loginbuttoncolors" type="submit" value="Hangars" name="hangarManageKnop"/>
                    </div>
                    <div class="form-group loginbutton-m-bot w-25 logininputs">
                        <input class="loginbuttoncolors" type="submit" value="Crews" name="crewManageKnop"/>
                    </div>
                    <div class="form-group loginbutton-m-bot w-25 logininputs">
                        <input class="loginbuttoncolors" type="submit" value="Flight Crews" name="flightCrewManageKnop"/>
                    </div>
                    <div class="form-group loginbutton-m-bot w-25 logininputs">
                        <input class="loginbuttoncolors" type="submit" value="Planes in Hangars" name="PlanesInHaManageKnop"/>
                    </div>
                </div>
            </div>
        <%}
        if( persoon.getSoort()=='P'){%>
            <div class="managebox box">
                <div class="mx-auto text-center loginfield">
                    <h3 class="login-m-bot">Management</h3>
                    <div class="form-group loginbutton-m-bot w-25 logininputs">
                        <input class="loginbuttoncolors" type="submit" value="Airlines" name="airlineManageKnop"/>
                    </div>
                </div>
            </div>
        <%}
        if( persoon.getSoort()=='B'){%>
            <div class="managebox box">
                <div class="mx-auto text-center loginfield">
                    <h3 class="login-m-bot">Management</h3>
                    <div class="form-group loginbutton-m-bot w-25 logininputs">
                        <input class="loginbuttoncolors" type="submit" value="Flight Schedule" name="reisSchemaKnop"/>
                    </div>
                </div>
            </div>
        <%}
        }%>
        </form>
        <!-- session teller-->
            <p align="center"><font color="white">U hebt deze site
             <strong> <%=session.getAttribute("aantal")%> maal </strong>bezocht.</p>
            <p align="center">Uw sessie-id is  <strong> <%=session.getId()%> </strong> </font></p>

             <div align="center"><a href="ManageServlet">Home</a></div>
    </body>
</html>
