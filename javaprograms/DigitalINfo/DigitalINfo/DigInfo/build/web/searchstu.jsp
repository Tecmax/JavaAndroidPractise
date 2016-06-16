

<%@include  file="inc/head.jsp" %>
<body id="page5">
    
    <%@include file="inc/menuforcompany.jsp"  %>
<div class="body2">
  <div class="main">
      
    <!-- content -->
    <section id="content">

                        <head>
	<meta http-equiv="content-type" content="text/html;charset=iso-8859-2" />
	<meta name="author" content="Luka Cvrk (www.solucija.com)" />
	
        
      
    <style>
      body {margin-bottom:100px}
      .code { display: none }
      .nod_msg { background: #f89406; display: inline-block; padding: 2px 5px; margin-left: 5px; border-radius: 5px; }
      .container {margin-top:20px}
      h2 {margin-top:1.4em}
      .nod_msg {
        font-weight: bold;
      }
      .input-append, .input-prepend { font-size: 14px; } /* bug in bootstrap? */
      
      /* prettify */
      .com { color: #93a1a1; }
      .lit { color: #195f91; }
      .pun, .opn, .clo { color: #93a1a1; }
      .fun { color: #dc322f; }
      .str, .atv { color: #D14; }
      .kwd, .prettyprint .tag { color: #1e347b; }
      .typ, .atn, .dec, .var { color: teal; }
      .pln { color: #48484c; }
      
      .prettyprint {
        padding: 8px;
        background-color: #f7f7f9;
        border: 1px solid #e1e1e8;
      }
      .prettyprint.linenums {
        -webkit-box-shadow: inset 40px 0 0 #fbfbfc, inset 41px 0 0 #ececf0;
           -moz-box-shadow: inset 40px 0 0 #fbfbfc, inset 41px 0 0 #ececf0;
                box-shadow: inset 40px 0 0 #fbfbfc, inset 41px 0 0 #ececf0;
      }
      /* Specify class=linenums on a pre to get line numbering */
      ol.linenums {
        margin: 0 0 0 33px; /* IE indents via margin-left */
      }
      ol.linenums li {
        padding-left: 12px;
        color: #bebec5;
        line-height: 20px;
        text-shadow: 0 1px 0 #fff;
      }
      
    </style>
      
          
                      
    <link href="lib/prettify.css">
    <script src="lib/jquery.min.js"></script>
    <script src="lib/bootstrap.min.js"></script>
    <script src="lib/prettify.js"></script>
    <script src="nod.min.js"></script> 
    
    
	
</head>
        
        
        
        
        
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
              <h2>Search Students Here</h2>
              <form id="ContactForm" action="search.jsp" >
                <div>
               
                  <div  class="wrapper"> <strong>Name:</strong>
                    <div class="bg">
                      <input type="text" name="search" class="input" >
                    </div>
                  </div>
              
              
                    
                    
                    
                 <input type="reset" class="button" value="Clear"><input type="submit" class="button" value="Search"> </div>
              </form>
            </div>
          </article>
        
        </div>
      </div>
   
                     
    <script>
            var metrics = [
  [ 'input', 'presence', 'Cannot be empty' ],
  [ '#integer', 'integer', 'Must be a whole number' ],
   [ '#inte', 'integer', 'Must 10 digits' ],
    [ '#email', 'email', 'Must be a valid email' ],
  [ '#ex3select1', 'presence', 'Pick something' ],
  
];
var options = {
  'groupClass' : 'warning'
};
$("#ContactForm").nod( metrics ,options);



        </script> 


        
        
    </section>
    <!-- content -->
    <!-- footer -->
    <%@include file="inc/footer.jsp"  %>
    <!-- / footer -->
  </div>
</div>

</body>
</html>



















