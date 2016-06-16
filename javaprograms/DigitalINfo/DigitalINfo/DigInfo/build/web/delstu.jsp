<%-- 
    Document   : delstu
    Created on : Aug 2, 2013, 11:19:14 AM
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
       
String email=request.getParameter("email");
java.sql.Connection con=DB.DBBean.DBConnection();
String q="delete from studentdata where stemail='"+email+"'";
java.sql.Statement st=con.createStatement();
int i=st.executeUpdate(q);
if(i>0)
       {
    response.sendRedirect("viewstu.jsp?msg=Deleted Successfully");
}
else
       {
    response.sendRedirect("viewstu.jsp?msg=Try again");
}

%>
    </body>
</html>
