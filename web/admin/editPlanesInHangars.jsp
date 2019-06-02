<%-- 
    Document   : forgotpass
    Created on : 14-mei-2019, 10:00:37
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
            <div class="bookingbox box">
                <div class="mx-auto text-center loginfield">
                     <form action="AdminServlet">
                            <div class="form-group loginbutton-m-bot w-25 logininputs">
                                <input class="loginbuttoncolors" type="submit" value="Save Changes" name="planesInHanSaveEditKnop"/>
                            </div>
                            <div class="form-group cancelbutton-m-bot w-25 logininputs">
                                <input class="loginbuttoncolors" type="submit" value="Cancel" name="planesInHanCancelKnop"/>
                            </div>
                     </form>
                </div>
            </div>
    </body>
</html>
