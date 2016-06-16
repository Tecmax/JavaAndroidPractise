

<%@include  file="inc/head.jsp" %>
<body id="page5">
    
    <%@include file="inc/menuforstudent.jsp"  %>
<div class="body2">
  <div class="main">
      
    <!-- content -->
    <section id="content">

        
                        <%
        
if(request.getAttribute("remsg")!=null)
       {
    %>
    <font color="green" size="4"><%=request.getAttribute("remsg")%></font>
        
        <%
}


%>
     <div class="box1">
        <div class="wrapper">
          <article class="col1">
            <div class="pad_left1">
               <h2>Education Details</h2>
        <table border="1" bordercolor="blue"><tr><th>Data</th>
            <th>Organization Name</th>
            <th>Passed Year</th>
            <th>Hall Ticket Number</th>
            <th>Location</th>
            <th>Percentage</th>
            <th>Certificate</th>
            <th>Contact Number</th>
            </tr>
        <%
        
String stid=session.getAttribute("stemail").toString();
java.sql.Connection con=DB.DBBean.DBConnection();
String q="select * from educationdata where stemail='"+stid+"'";
java.sql.Statement st=con.createStatement();
java.sql.ResultSet rs=st.executeQuery(q);
while(rs.next())
       {
    %>
            <tr><td><%=rs.getString(2) %></td>
    <td><%=rs.getString(3) %></td>
    <td><%=rs.getString(4) %></td>
    <td><%=rs.getString(5) %></td>
    <td><%=rs.getString(6) %></td>
    <td><%=rs.getString(7) %></td>
    <td><img src="<%=rs.getString(8)%>" height="100" width="100"/></td>
    <td><%=rs.getString(10) %></td>
            <td><a href="editedu.jsp?id=<%=rs.getString(1)%>"><b>Edit</b></a></td></tr>
            
            
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














