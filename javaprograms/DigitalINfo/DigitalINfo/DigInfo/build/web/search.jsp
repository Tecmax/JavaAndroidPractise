

<%@include  file="inc/head.jsp" %>
<body id="page5">
    
    <%@include file="inc/menuforcompany.jsp"  %>
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

        <h2>Search Results</h2>
        
        <h2>Eductional Data</h2>
        <table border="1"><tr><th>Email ID</th>
            <th>Qualification</th>
            <th>Year OF Passed out</th>
                    <th>Organization  Name </th>
                                     <th>Organization  Name </th>
           </tr>
        <%
        String search=request.getParameter("search");
        %>
        You have searched :<font color="blue" size="4"><%=search%></font>
        <hr>
           
           
           <%
//String cid=session.getAttribute("cmail").toString();
java.sql.Connection con=DB.DBBean.DBConnection();

String q="select * from educationdata where stemail like '%"+search+"%'";
java.sql.Statement st=con.createStatement();
java.sql.ResultSet rs=st.executeQuery(q);
while(rs.next())
       {
    %>
            <tr><td><%=rs.getString(9) %></td>
    <td><%=rs.getString(2) %></td>
    <td><%=rs.getString(4) %></td>
      <td><%=rs.getString(3) %></td>
         <td><img width='100' height='100'  src="<%=rs.getString(8) %>"></img></td>
 </tr>
            
            
            <%
}







%>
        
        </table>
        


<h2>Card Data</h2>
        <table border="1"><tr><th>card type</th>
            <th>Name</th>
            <th>Card</th>
            <th>Reference Number</th>
           </tr>
        <%
      
        %>
        You have searched :<font color="blue" size="4"><%=search%></font>
        <hr>
           
           
           <%
//String cid=session.getAttribute("cmail").toString();
q="select * from carddetails where name like '%"+search+"%'";
java.sql.Statement s1t=con.createStatement();
java.sql.ResultSet rs11=st1.executeQuery(q);
while(rs11.next())
       {
    %>
            <tr><td><%=rs11.getString(1) %></td>
    <td><%=rs11.getString(3) %></td>
    <td><img width='100' height='100'  src="<%=rs11.getString(6) %>"></img></td>
    <td><%=rs11.getString(7) %></td>
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





















