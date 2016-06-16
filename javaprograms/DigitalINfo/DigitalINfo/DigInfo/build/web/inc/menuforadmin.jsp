<div class="body1">
  <div class="main">
    <!-- header -->
    <header>
        
      <div class="wrapper">
          
        <nav>
          <ul id="menu">
              <li> <a href="adminhome.jsp"><font color="yellow"><b>Digital Information</b></font></a></li>
            <li><a href="adminhome.jsp">Home</a></li>
            <li><a href="viewstu.jsp">View Student</a></li>
            
            <li><a href="viewcom.jsp">View Company</a></li>
             <li><a href="logout.jsp">Logout</a></li>
           <!-- <li><a href="viewcom.jsp">Add Education Details</a></li>
            <li><a href="viewedu.jsp">View</a></li>
         
              <li><a href="admissions.html">Admissions</a></li>
            <li class="end"><a href="contacts.html">Contacts</a></li>-->
                           
                      <li><%
String aid=session.getAttribute("sa").toString();
    %>    
 <font color="yellow">Hi,<%=aid %></font>
</li>   
          </ul>
            
        </nav>
        
        
      </div>
   
    </header>
    <!-- / header -->
  </div>
</div>
    
    
 