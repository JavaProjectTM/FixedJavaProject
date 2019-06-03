<%-- 
    Document   : editLuchthaven.jsp
    Created on : Jun 1, 2019, 4:27:17 PM
    Author     : Sven
--%>

<%@page import="hbo5.it.www.beans.Luchthaven"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <%@include file="../includes/head.jsp" %>
    </head>
    <body>
        <%@include file="../includes/navbar.jsp" %>
        <div class="bookingbox box">
            <div class="mx-auto text-center loginfield">

                <h1>Edit Airport</h1>
                <% Luchthaven luchthaven = (Luchthaven) request.getAttribute("luchthaven");%>

                <form action="AdminServlet">
                    <p>
                        <label for="luchthavennaam">luchthaven naam:</label>
                        <input type ="text" id="luchthavennaam" value="<%=luchthaven.getLuchthavennaam()%>" name="luchthavennaam"/>

                        <label for="stad">stad :</label>
                        <input type ="text" id="stad" value="<%=luchthaven.getStad()%>" name="stad"/>

                        <label for="landid">land_id:</label>

                        <input type ="text" id="landid" value="<%=luchthaven.getLand_id()%>" name="landid"/>

                        <input type="hidden" value="<%=luchthaven.getId()%>" name="id"/>

                    </p>
                            <div class="form-group loginbutton-m-bot w-25 logininputs">
                                <input class="loginbuttoncolors" type="submit" value="Save Changes" name="wijzigLuchthaven"/>
                            </div>
                            <div class="form-group cancelbutton-m-bot w-25 logininputs">
                                <input class="loginbuttoncolors" type="submit" value="Cancel" name="cancelAirportKnop"/>
                            </div>
                        

                </form>
            </div>
        </div>


    </div>
</body>
</html>
