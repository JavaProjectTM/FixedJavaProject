<%-- 
    Document   : addAirline
    Created on : 29-mei-2019, 14:24:19
    Author     : c1044217
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../includes/head.jsp" %>
    </head>
    <body>
        <%@include file="../includes/navbar.jsp" %>
            <div class="bookingbox box">
                <div class="mx-auto text-center loginfield">
                     <form action="AdminServlet">
                         
                         <p>
                    <label for="luchthavennaam">luchthaven naam:</label>
                    <input type ="text" id="luchthavennaam" value="" name="luchthavennaam"/>
                    
                    <label for="stad">stad :</label>
                    <input type ="text" id="stad" value="" name="stad"/>
                    
                    <label for="landid">land_id:</label>
                    <input type ="text" id="landid" value="" name="landid"/>

                    

                </p> 
                         
                            <div class="form-group loginbutton-m-bot w-25 logininputs">
                                <input class="loginbuttoncolors" type="submit" value="Save Changes" name="airportSaveAddKnop"/>
                            </div>
                            <div class="form-group cancelbutton-m-bot w-25 logininputs">
                                <input class="loginbuttoncolors" type="submit" value="Cancel" name="airportCancelKnop"/>
                            </div>
                     </form>
                </div>
            </div>
    </body>
</html>
