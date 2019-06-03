<%-- 
    Document   : forgotpass
    Created on : 14-mei-2019, 10:00:37
    Author     : c1044217
--%>

<%@page import="hbo5.it.www.beans.Hangar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../includes/head.jsp" %>
    </head>
    <body>
        <%@include file="../includes/navbar.jsp" %>
            <div class="bookingbox box">
            <h1>Edit hangar</h1>
            <% Hangar hangar = (Hangar) request.getAttribute("hangar");%>

            <form action="AdminServlet">
                <p>
                    <label for="hangarnaam">hangar naam:</label>
                    <input type ="text" id="hangarnaam" value="<%=hangar.getHangarNaam()%>" name="hangarnaam"/>

                    <input type="hidden" value="<%=hangar.getId()%>" name="id"/>

                </p>    

                <div class="mx-auto text-center loginfield">
                    <form action="AdminServlet">
                        <div class="form-group loginbutton-m-bot w-25 logininputs">
                            <input class="loginbuttoncolors" type="submit" value="Save Changes" name="hangarSaveEditKnop"/>
                        </div>
                        <div class="form-group cancelbutton-m-bot w-25 logininputs">
                            <input class="loginbuttoncolors" type="submit" value="Cancel" name="hangarCancelKnop"/>
                        </div>
                    </form>
                </div>
            </form>

        </div>
    </body>
</html>
