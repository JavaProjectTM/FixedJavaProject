<%-- 
    Document   : navbar
    Created on : 8-mei-2019, 9:37:01
    Author     : c1044217
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <nav class="text navbar navbar-expand-lg navbar-light">
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#keepitplane" aria-controls="keepitplane" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
            <div class="collapse navbar-collapse justify-content-center navtext" id="keepitplane">
                <img src="./images/favicon.jpg" alt="placeholder">
              <a class="nav-align text-white navbar-brand navtext" href="index.jsp">Keep It Plane</a>
              <form action="ManageServlet">
                <ul class=" navbar-nav mt-2 mt-lg-0">
                  
                  <li class="nav-align nav-item">
                    <input type="submit"  class="link-hover text-white nav-link" action="submit" value="About" name="aboutKnop"></input>
                  </li>
                  <li class="nav-align nav-item">
                      <a href="./booking.jsp" value > </a>
                  </li>
                  <li class="nav-align nav-item">
                    <input type="submit"  class="link-hover text-white nav-link" action="submit" value="Vluchten" name="vluchtKnop"></input>
                  </li>
                   <li class="nav-align nav-item">
                    <input type="submit"  class="link-hover text-white nav-link" action="submit" value="Agenda" name="crewKnop"></input>
                  </li>
                  <%String usernametry = (String)session.getAttribute("usernametry");
                  if(usernametry==null)  {%>   
                  <li class="nav-align nav-item login">
                    <input type="submit" class="link-hover text-white nav-link" action="submit" value="Login" name="loginpageKnop"></input>
                  </li>
                    <%} else {%>
                  <li class="nav-align nav-item login">
                    <input type="submit" class="link-hover text-white nav-link" action="submit" value="<%=usernametry%>" name="profilepageKnop"></input>
                  </li>                        
                  <li class="nav-align nav-item">
                    <input type="submit" class="link-hover text-white nav-link" action="submit" value="Logout" name="logoutKnop"></input>
                  </li>
                  <%}%>
                </ul>
               </form>
            </div>
        </nav>
    </body>
</html>
