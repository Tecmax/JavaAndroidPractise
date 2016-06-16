import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DisplayPhotoServlet", urlPatterns = {"/displayphoto"})
public class DisplayPhotoServlet extends HttpServlet {

    @Override 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try 
        {
        	//PrintWriter out=response.getWriter();
            
            String cardnumber = request.getParameter("cardnumber");
            String acardnumber=cardnumber+".jpg";
           // System.out.println("appende halltin"+htno);
           
            //System.out.println("hallticket number"+htno);
            
            File f=new File("D://azimnew");
            File[] listOfFiles=f.listFiles();
            
           for (int i = 0; i < listOfFiles.length; i++)
           {
             if (listOfFiles[i].isFile())
             {
           	 //out.println("<tr>");
           	 //out.println("<td>");
            	 String path=listOfFiles[i].getPath();
            	 System.out.println("file path is"+path);
                  System.out.println("list of file"+listOfFiles[i].getName());
                     System.out.println("a card number"+acardnumber);
                 if(listOfFiles[i].getName().equals(acardnumber))
                 {
                    
                	 String path1=listOfFiles[i].getPath();
                	 FileInputStream fis=new FileInputStream(path1);
                	 int size=fis.available();
                         System.out.println("size of the image"+size);
                	 byte b[]=new byte[size];
                	 fis.read(b);
                	 
                	OutputStream os = response.getOutputStream();
                	 os.write(b);
                    os.close();
                	 
                     //out.println("match ===="+listOfFiles[i].getName());

                    // out.print("<img src='"+listOfFiles[i]+"' width='242' height='242' />");
                 }
                 else
                 {
                     System.out.println("file not found");
                 }
             }
           }

            	 
              //String path=listOfFiles[i].getPath();
              //System.out.println("path is"+path);
              //if(path.endsWith("new.jpg"))
             // {
               // String rfname=fname+"or"
                  // out.print("<img src='"+path+"' width='70' height='70' />");
                  // out.println("</td>");
             //  out.println("</tr>");
              // }
              // else
              // {
             //      System.out.println("file not found");
               
           //}
           
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
    }
        }


          // %>
            
            