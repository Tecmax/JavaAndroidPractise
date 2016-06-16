

<%@include  file="inc/head.jsp" %>
<body id="page5">
    
    <%@include file="inc/menuforadmin.jsp"  %>
<div class="body2">
  <div class="main">
      
    <!-- content -->
    <section id="content">

        
                        <%
        
if(request.getParameter("msg")!=null)
       {
    %>
    <font color="green" size="6"><%=request.getParameter("msg")%></font>
        
        <%
}


%>
     <div class="box1">
        <div class="wrapper">
          <article class="col1">
            <div class="pad_left1">
               <h2>Student Details</h2>
               <table border="1" bordercolor="blue"><tr><th>SNO</th>
            <th>Student Name</th>
            <th>Email id</th>
            <th>Phone Number</th>
           </tr>
        <%
        
//String stid=session.getAttribute("stemail").toString();
java.sql.Connection con=DB.DBBean.DBConnection();
String q="select * from studentdata ";
java.sql.Statement st=con.createStatement();
java.sql.ResultSet rs=st.executeQuery(q);
int i=0;
while(rs.next())
       {
    %>
     <tr><td><%=i=i+1 %></td><td><%=rs.getString(4) %></td>
    <td><%=rs.getString(1) %></td>
    <td><%=rs.getString(2) %></td>
    <td><a href="delstu.jsp?email=<%=rs.getString(1)%>"><b>Delete</b></a></td>
   </tr>
            
            
            <%
}

%>
        
        </table>
      </div>
          </article>
        
        </div>
      </div>
   



        
        
    </section>
    <!-- content -->
    <!-- footer -->
    <%@include file="inc/footer.jsp"  %>
    <!-- / footer -->
  </div>
</div>

</body>
</html>














