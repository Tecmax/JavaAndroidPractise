<%-- 
    Document   : delman
    Created on : May 11, 2011, 3:48:27 AM
    Author     : SattvaQ Pvt Ltd
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
       try
       {     
           String mgid= request.getParameter("id");

            org.hibernate.SessionFactory sf = new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
            org.hibernate.Session s = sf.openSession();
            org.hibernate.Transaction tr = s.beginTransaction();
            
            org.hibernate.Query q=s.createQuery("delete from Industry where managerid='"+mgid+"'");
            int d=q.executeUpdate();
tr.commit();
                                         if(d>0){
                String msg="ok";
             response.sendRedirect("viewdetofmanager.jsp?msg="+msg);                    
            }else
            {
            String msg="notok";
             response.sendRedirect("viewdetofmanager.jsp?msg="+msg);                    
            
            }

       }
       catch(Exception ee)
       {
           out.print(ee);
       }
        %>
    </body>
</html>
