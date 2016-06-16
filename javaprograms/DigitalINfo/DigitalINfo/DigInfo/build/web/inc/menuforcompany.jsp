<div class="body1">
  <div class="main">
    <!-- header -->
    <header>
        
      <div class="wrapper">
          
        <nav>
          <ul id="menu">
              <li> <a href="companyhome.jsp"><font color="yellow"><b>Digital Information</b></font></a></li>
            <li><a href="companyhome.jsp">Home</a></li>
            <li><a href="searchstu.jsp">Search Students</a></li>
           
          <li><a href="logout.jsp">Logout</a></li>
          
          
                                <li><%
java.sql.Connection con1=DB.DBBean.DBConnection();
//String q="select * from studentdata where stemail='%"+search+"%' or like name='%"+search+"%' or like phone='%"+search+"%'";
String q1="select * from companydata where cmail='"+session.getAttribute("cmail").toString() +"'";
java.sql.Statement st1=con1.createStatement();
java.sql.ResultSet rs1=st1.executeQuery(q1);
while(rs1.next())
       {    
%>
 <font color="yellow">Hi,<%=rs1.getString(2) %></font>
    <%
}
%></li>   
              <!--<li><a href="admissions.html">Admissions</a></li>
            <li class="end"><a href="contacts.html">Contacts</a></li>-->
             
          </ul>
            
        </nav>
        
        
      </div>
   
    </header>
    <!-- / header -->
  </div>
</div>
    
    
 