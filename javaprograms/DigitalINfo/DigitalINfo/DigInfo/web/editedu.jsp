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
               <h2>Updating Education Details</h2>
                <form  method="POST" action="ppp_1.jsp" enctype="multipart/form-data">
        <table border="1" bordercolor="blue">
          
        <%
      String id=request.getParameter("id");  
String stid=session.getAttribute("stemail").toString();
java.sql.Connection con=DB.DBBean.DBConnection();
String q="select * from educationdata where stemail='"+stid+"' and dataid='"+id+"'";
java.sql.Statement st=con.createStatement();
java.sql.ResultSet rs=st.executeQuery(q);
while(rs.next())
       {
    %>
    <tr><td><input type="hidden" name="id" value="<%=request.getParameter("id") %>" /></td></tr>
            <tr><td>Data</td><td><input type="text" name="data" value="<%=rs.getString(2) %>" /></td></tr>
            <tr><td>Organization Name</td><td><input type="text" name="orgname" value="<%=rs.getString(3) %>" /></td></tr>
            <tr><td>Passed Year</td> <td><input type="text" name="year" value="<%=rs.getString(4) %>" /></td></tr>
            <tr><td>Hall Ticket Number</td> <td><input type="text" name="htno" value="<%=rs.getString(5) %>" /></td></tr>
            <tr><td>Location</td> <td><input type="text" name="loc" value="<%=rs.getString(6) %>" /></td></tr>
            <tr><td>Percentage</td> <td><input type="text" name="per" value="<%=rs.getString(7) %>" /></td></tr>
             <tr><td>Certificate</td> <td>
             <input type="file" name="uploadfile" >
               <input type="hidden" name="todo" value="upload">  
            
        </td></tr>
            
            
            
            <%
}

%>
        
        </table>
<input type="submit" value="Update" />
        
            </form>    
              
              
              
              
              
              
              
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














