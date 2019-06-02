<%-- 
    Document   : login
    Created on : 8-mei-2019, 8:57:31
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
                    <h3 class="login-m-bot">Log In to Your Account</h3>
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
                        <%String passError = (String)session.getAttribute("passError");
                        if(passError==null)  {%>            
                            <div class="form-group w-75 logininputs">
                                <input type="password" class="form-control" placeholder="Your Password *" value="" name="password" />
                            </div>
                        <%} else {%>
                            <div class="form-group w-75 logininputs">
                                <input type="password" class="form-control" placeholder="Your Password *" value="" name="password" />
                                <label class="logginError"><%=passError%></label>
                            </div>
                        <%}%>
                        <div class="form-group loginbutton-m-bot w-25 logininputs">
                            <input class="loginbuttoncolors" type="submit" value="Login" name="userloginKnop"/>
                        </div>
                        <div class="form-group">
                            <input class="logintextcolors" type="submit" value="Forgot Password?" name="forgotpassKnop"/>
                        </div>
                        <div class="form-group">
                            <a>Need an Account?  </a>
                            <input class="logintextcolors" type="submit" value="Sign Up" name="registerKnop"/>
                        </div>
                    </form>
                </div>
        </div>
    </body>
</html>
