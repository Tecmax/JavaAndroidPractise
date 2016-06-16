<%@include file="inc/head.jsp"  %>
<body>
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
                                <%
                String admin=session.getAttribute("suid").toString();        
             %>
                <font color="purple">Hi,<%=admin%></font>
                                </div> 
          
			</div>
			<div id="pagetitle">
				<div id="title" class="titletext" align="right">Student Faculty Researcher Communication System</div>
			</div>
		</div>
		<div id="content" align="center">
			<div id="menu" align="right">
				<div align="right" style="width:189px; height:8px;"><img src="images/mnu_topshadow.gif" width="189" height="8" alt="mnutopshadow" /></div>
				<div id="linksmenu" align="center">
					<a href="adminhome.jsp" title="Home">Home</a>
					<a href="manager.jsp" title="Manger Registration">Register Manager</a>
					<a href="orghead.jsp" title="Products">Register Head</a>
					<a href="viewdetofmanager.jsp" title="Register Head">View Manager</a>
					<a href="viewdetoforg.jsp" title="View Details Of Manager">View Organization</a>
                                        <a href="viewdetofemp.jsp" title="View Head ">View Employee </a>
                                        <a href="viewdetoffaclty.jsp" title="View Details Of Employee">View Faculty</a>
                                        <a href="viewdetofStudnt.jsp" title="View Details Of Faculty">View Student</a>
                                         <a href="logout.jsp" title="Logout Now">Logout</a>
				</div>
				<div align="right" style="width:189px; height:8px;"><img src="images/mnu_bottomshadow.gif" width="189" height="8" alt="mnubottomshadow" /></div>
			</div>
		<div id="contenttext">
			<div class="bodytext" style="padding:12px;" align="justify">
			
                        
                        </div>
		
 
                    
                    
                    
		</div>
                <%@include file="inc/footer.jsp"  %>
	</div>
