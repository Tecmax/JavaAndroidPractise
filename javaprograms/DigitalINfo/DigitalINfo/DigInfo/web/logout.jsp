<%-- 
    Document   : logout
    Created on : Aug 1, 2013, 1:12:28 PM
    Author     : SattvaQ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <%
    
session.invalidate();
response.sendRedirect("index.jsp");


%>
    </body>
</html>
