<%-- 
    Document   : register
    Created on : 14-mei-2019, 9:54:15
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
                <div class="loginbox box">
                <div class="mx-auto text-center loginfield">
                    <h3 class="login-m-bot">Register New Account</h3>
                    <form  action="InlogServlet">
                        <%String usernameError = (String)session.getAttribute("usernameError");
                        if(usernameError==null)  {%>            
                            <div class="form-group w-75 logininputs">
                                <input type="text" class="form-control" placeholder="Your Username *" value="" name="username" />
                            </div>
                        <%} else {%>
                            <div class="form-group w-75 logininputs">
                                <input type="text" class="form-control" placeholder="Your Username *" value="" name="username" />
                                <label class="logginError"><%=usernameError%></label>
                            </div>
                        <%}%>
                        <div class="form-group w-75 logininputs">
                            <input type="password" class="form-control" placeholder="Your Password *" value="" name="password" />
                        </div>                        
                        <div class="form-group loginbutton-m-bot w-25 logininputs">
                            <input class="loginbuttoncolors" type="submit" value="Sign Up" name="signup"/>
                        </div>
                    </form>
                </div>
        </div>
    </body>
</html>
