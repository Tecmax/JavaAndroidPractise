<%-- 
    Document   : contact
    Created on : Aug 1, 2013, 3:35:57 PM
    Author     : SattvaQ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
      <section id="content">
      <div class="box1">
        <div class="wrapper">
          <article class="col1">
            <div class="pad_left1">
              <h2>Contact Form</h2>
              <form id="ContactForm" action="#">
                <div>
                  <div  class="wrapper"> <strong>Name:</strong>
                    <div class="bg">
                      <input type="text" class="input" >
                    </div>
                  </div>
                  <div  class="wrapper"> <strong>Email:</strong>
                    <div class="bg">
                      <input type="text" class="input" >
                    </div>
                  </div>
                  <div  class="textarea_box"> <strong>Message:</strong>
                    <div class="bg">
                      <textarea name="textarea" cols="1" rows="1"></textarea>
                    </div>
                  </div>
                  <a href="#" class="button"><span><span>Send</span></span></a> <a href="#" class="button"><span><span>Clear</span></span></a> </div>
              </form>
            </div>
          </article>
          <article class="col2 pad_left2">
            <div class="pad_left1">
              <h2>Miscellaneous <span>Info</span></h2>
              <p>Quia voluptas sit aspernatur aut odit aut fugit, seduia consequuntur magni dolores eos qui ratione. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non.<br>
                numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur.</p>
            </div>
          </article>
        </div>
      </div>
    </section>
    </body>
</html>
