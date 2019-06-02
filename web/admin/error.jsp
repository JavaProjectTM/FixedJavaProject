<%-- 
    Document   : error.jsp
    Created on : Jun 1, 2019, 2:45:28 PM
    Author     : Sven
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Er liep iets fout:</h1>
        <%=request.getAttribute("fout")%>
    </body>
</html>
