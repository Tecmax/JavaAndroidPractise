/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SattvaQ
 */
@WebServlet(name = "regaction", urlPatterns = {"/regaction"})
public class regaction extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
           
            String na,email,psw,phno,typeofuser;
           na=request.getParameter("na");            
           email=request.getParameter("email"); 
           psw=request.getParameter("psw"); 
           phno=request.getParameter("phno"); 
           typeofuser=request.getParameter("type"); 
           
           java.sql.Connection con=DB.DBBean.DBConnection();
           if(typeofuser.equals("Company"))
           {
               String q="insert into companydata values('"+email+"','"+na+"','"+phno+"','"+psw+"')";
                java.sql.Statement stmt=con.createStatement();
               int i=stmt.executeUpdate(q);
               if(i>0)
               {
                   response.sendRedirect("reg.jsp?msg=Registered Successfully");
               }else
               {
                   response.sendRedirect("reg.jsp?msg=Not Registered");
               }
           }else if(typeofuser.equals("Student"))
           {
               
               String diginfo=mail.DigInfo.generateDiginfo();
                 String q="insert into studentdata values('"+email+"','"+phno+"','"+psw+"','"+na+"','"+diginfo+"')";
                java.sql.Statement stmt=con.createStatement();
               int i=stmt.executeUpdate(q);
               if(i>0)
               {
                   
                   String subj = "DigInfo Registration Confirmation";
           
            String content = "You have registered with Diginfo successfull<h1>Your Diginfo Number is:"+diginfo+"</h1>";
            mail.SendMail.sendMail(email, subj, content);
                   response.sendRedirect("reg.jsp?msg=Registered Successfully");
               }else
               {
                   response.sendRedirect("reg.jsp?msg=Not Registered");
               }
           }
           
            
        }
        catch(Exception e)
        {
            out.print(e);
        }
        
        
        finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
