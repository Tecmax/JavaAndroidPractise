
<%
if(session.getAttribute("head")!=null)
       {


%>
<%@include file="inc/head.jsp"  %>
	<div id="page" align="center">
		<div id="toppage" align="center">
			<div id="date">
				<div class="smalltext" style="padding:13px;"><strong></strong></div>
			</div>
			<div id="topbar">
				<div align="right" style="padding:12px;" class="smallwhitetext"><a href="#">Home</a> | <a href="#">Sitemap</a> | <a href="#">Contact Us</a></div>
			</div>
		</div>
		<div id="header" align="center">
			<div class="titletext" id="logo">
				<div class="logotext" style="margin:5px"><span class="orangelogotext">SFRCS</span>
          
                                </div> 
            
			</div>
                    
			<div id="pagetitle">
                            
				<div id="title" class="titletext" align="right">Student Faculty Researcher Communication System</div>
			
                        </div>
                    
      
                    
		</div>
              <% String orga=session.getAttribute("head").toString();%>
             <font color="purple"><h3> Hi, <%= orga%></h3></font> 
		<div id="content" align="center">
                    
                    <%@include file="inc/orgsidebar.jsp"  %>
                    
		<div id="contenttext">
			<div class="bodytext" style="padding:12px;" align="justify">
			
                        
                        </div>
                    
		
    
             
                    
                    
		</div>
              <%@include file="inc/footer.jsp"  %>
	</div>
        </div>
        
  <%
  
}
else
     {
    response.sendRedirect("index.jsp");
}
%>
