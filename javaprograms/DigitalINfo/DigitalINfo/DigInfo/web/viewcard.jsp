
<%@page import="java.io.File"%>
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
               <h2>View Card Details</h2>
        <table border="1" bordercolor="blue"><tr><th>Card Type</th>
            <th>Name OF The Card Holder</th>
            <th>Card Number</th>
            <th>Location</th>
            <th>Card</th>
            </tr>
            
            
            
            
            
            
            
        <%


        
String stid=session.getAttribute("stemail").toString();
java.sql.Connection con=DB.DBBean.DBConnection();
String q="select * from carddetails where email='"+stid+"'";
java.sql.Statement st=con.createStatement();
java.sql.ResultSet rs=st.executeQuery(q);

while(rs.next())
       {
           out.println("<tr>");
         
           String cardtype=rs.getString(1);
           out.println("<td>"+cardtype+"</td>");
           
           String cardName=rs.getString(3);
            out.println("<td>"+cardName+"</td>");
            
           String cardnumber=rs.getString(4);
            out.println("<td>"+cardnumber+"</td>");
            
           String location=rs.getString(5);
            out.println("<td>"+location+"</td>");
            String cardpath=rs.getString(6);
            out.print("<td><img width='100' height='100'  src="+cardpath+"></img></td>");     
  




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














