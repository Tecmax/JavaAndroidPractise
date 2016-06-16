<div class="body1">
    
  <div class="main">
    <!-- header -->
    <header>
        
      <div class="wrapper">
          
        <nav>
          <ul id="menu">
   
              <li> <a href="studenthome.jsp"><font color="yellow"><b>Digital Information</b></font></a></li>
            <li><a href="studenthome.jsp">Home</a></li>
            <li><a href="addedu.jsp">Add Education Details</a></li>
                 <li><a href="addcard.jsp">Add Card Details</a></li>
                   <li><a href="viewcard.jsp">View Card Details</a></li>
            <li><a href="viewedu.jsp">View</a></li>
            

            
            
            
          <li><a href="logout.jsp"><font color="orange"><b>Logout</b></font></a></li>
              <!--<li><a href="admissions.html">Admissions</a></li>
            <li class="end"><a href="contacts.html">Contacts</a></li>-->
             
              
                      <li><%
java.sql.Connection con1=DB.DBBean.DBConnection();
//String q="select * from studentdata where stemail='%"+search+"%' or like name='%"+search+"%' or like phone='%"+search+"%'";
String q1="select * from studentdata where stemail='"+session.getAttribute("stemail").toString() +"'";
java.sql.Statement st1=con1.createStatement();
java.sql.ResultSet rs1=st1.executeQuery(q1);
while(rs1.next())
       {    
%>
 <font color="yellow">Hi,<%=rs1.getString(4) %></font>
    <%
}
%></li>   
              
              
          </ul>
            
        </nav>
        
        
      </div>
   
    </header>
    

    <!-- / header -->
  </div>
</div>
    
    
 