
<%@page import="java.io.File"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<html>
    <%@ page language="java" import="javazoom.upload.*,java.util.*" %>

    <%
        String urlpath = request.getContextPath();
        urlpath = urlpath + "/certificates";
    %>
    <jsp:useBean id="upBean" scope="page" class="javazoom.upload.UploadBean" >
        <jsp:setProperty name="upBean" property="folderstore" value="F:/Laxman/Dig/DigInfo/web/certificates"/>
        <jsp:setProperty name="upBean" property="parser" value="<%= MultipartFormDataRequest.CFUPARSER%>"/>
        <jsp:setProperty name="upBean" property="parsertmpdir" value="c:/temp"/>
        <jsp:setProperty name="upBean" property="overwritepolicy" value="nametimestamp" />
    </jsp:useBean>

    <ul class="style1">
        <%

            UploadFile file = null;
            //UploadFile file1 = null;
          // UploadFile file2 = null;
            //Class.forName("com.mysql.jdbc.Driver");
            //     Connection mycon=DriverManager.getConnection("jdbc:mysql://localhost:3306/gowrishankar","myuser2","123");
            String Uid = null, Password = null, Fname = null, Lname = null, Gender = null, Country = null, City = null, Sequrityq = null, Dob = null, Sequritya = null, Imgurl = null,Imgur2=null, Blockuser = null;
            String sno = null, fname = null, mid = null;

            if (MultipartFormDataRequest.isMultipartFormData(request)) {
                // Uses MultipartFormDataRequest to parse the HTTP request.
                MultipartFormDataRequest mrequest = new MultipartFormDataRequest(request);
                String todo = null;
                if (mrequest != null) {
                    todo = mrequest.getParameter("todo");
                }
                if ((todo != null) && (todo.equalsIgnoreCase("upload"))) {
                    Hashtable files = mrequest.getFiles();
                    if ((files != null) && (!files.isEmpty())) {
                        file = (UploadFile) files.get("uploadfile");
                        //file1 = (UploadFile) files.get("uploadfile1");
                        //file2 = (UploadFile) files.get("uploadfile2");
                        if (file != null) {
                            out.println("<li>Form fields : uploadfile" + "<BR> Uploaded file : " + file.getFileName() + " (" + file.getFileSize() + " bytes)" + "<BR> Content Type : " + file.getContentType());
                        }
                        // Uses the bean now to store specified by jsp:setProperty at the top.
                        upBean.store(mrequest, "uploadfile");
                         upBean.store(mrequest, "image");
                    } else {
                        out.println("<li>No uploaded files");
                    }
                    if (mrequest != null) {
                      //  out.println("<BR> mytextfield=" + mrequest.getParameter("mytextfield"));
                       // out.println("<BR> myselect=" + mrequest.getParameter("myselect"));
                        String[] vals = mrequest.getParameterValues("multipleselect");
                        if (vals != null) {
                            for (int j = 0; j < vals.length; j++) {
                              //  out.println("<BR> multipleselect=" + vals[j]);
                            }
                        }
                      //  out.println("<BR> mycheckbox=" + mrequest.getParameter("mycheckbox"));
                       // out.println("<BR> myradiobutton=" + mrequest.getParameter("myradiobutton"));
                       // out.println("<BR> mytextarea=" + mrequest.getParameter("mytextarea"));
                    }
                } else {
                    out.println("<BR> todo=" + todo);
                }

    String  data,orgname,year,htno,loc;
          data=mrequest.getParameter("data");
          orgname=mrequest.getParameter("orgname");
          year=mrequest.getParameter("year");
          htno=mrequest.getParameter("htno");
          loc=mrequest.getParameter("loc");
          String id=mrequest.getParameter("id");
         float per=Float.parseFloat(mrequest.getParameter("per"));
          //HttpSession se = request.getSession();
            //String uid = session.getAttribute("suid").toString();
            
            
            
            /*
Date d = new java.util.Date();
            Calendar cal = Calendar.getInstance();

            cal.setTime(d);

            int m = cal.get(Calendar.MONTH);
            String month = "";
            if (m == 1) {
                month = "JAN";
            } else if (m == 2) {
                month = "FEB";
            } else if (m == 3) {
                month = "MAR";
            } else if (m == 4) {
                month = "APRL";
            } else if (m == 5) {
                month = "MAY";
            } else if (m == 6) {
                month = "JUNE";
            } else if (m == 7) {
                month = "JULY";
            } else if (m == 8) {
                month = "AUG";
            } else if (m == 9) {
                month = "SEPT";
            } else if (m == 10) {
                month = "OCT";
            } else if (m == 11) {
                month = "NUV";
            } else if (m == 12) {
                month = "DEC";
            }

            int dd = cal.get(Calendar.DATE);

            String day = "";

            if (dd == 1 || dd == 21 || dd == 31) {
                day = dd + "st";
            } else if (dd == 2 || dd == 22) {
                day = dd + "nd";
            } else if (dd == 3 || dd == 23) {
                day = dd + "rd";
            } else {
                day = dd + "th";
            }

            int y = cal.get(Calendar.YEAR);

            String datea=y+"-"+m+"-"+dd;
            
            
            
           
               
                //   Statement stmt=mycon.createStatement();
             */

   try{ 
       Imgurl = "certificates/" + file.getFileName();
      // Imgur2 = "certificates/" + file.getFileName();
        // String Imgur3 = "certificates/" + file2.getFileName();
         //String cert=Imgurl+"/"+Imgur2+"/"+Imgur3;
        //Imgur3 = "certificates/" + file.getFileName();
       // File mas=new File("C:/Users/Manisha.K/Documents/NetBeansProjects/steganography/web/images/"+ file1.getFileName());
        //File o=new File("C:/Users/Manisha.K/Documents/NetBeansProjects/steganography/web/images/"+ file1.getFileName());
      // File sf=new File("C:/Users/Manisha.K/Documents/NetBeansProjects/steganography/web/images/"+ file.getFileName());
       //boolean b1= p1.EmbedFile.embedFile(mas, o, sf , 1,pin_no);
   String suid = session.getAttribute("stemail").toString();
                      java.sql.Connection mycon = DB.DBBean.DBConnection();
String q = "update educationdata set typeofdata='" + data + "', orgname='" + orgname + "', yearofpassedout='" + year + "', htno='"+htno+"', location='"+loc+"', percentage='"+per+"', certificateurl='"+"certificates/"+file.getFileName()+"' where stemail='"+suid+"' and dataid='"+id+"'";
            java.sql.Statement st = mycon.createStatement();
            int i = st.executeUpdate(q);
if(i>0){
    javax.servlet.RequestDispatcher rd=request.getRequestDispatcher("viewedu.jsp");
                       request.setAttribute("remsg", " Updated Successfully !");
                      rd.forward(request, response);
}else{
    out.print("try again");
}

 
                //int i=stmt.executeUpdate(q);
                //  if(i>0)
            
            } catch (Exception ee) { 
                out.print(ee);
                
            }
          
            }


        %>
    </ul>