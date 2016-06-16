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
import javax.servlet.http.HttpSession;

/**
 *
 * @author SattvaQ
 */
@WebServlet(name = "loginaction", urlPatterns = {"/loginaction"})
public class loginaction extends HttpServlet {

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
          String uid,psw,typeofuser;
          uid=request.getParameter("uid");
          psw=request.getParameter("psw");
          typeofuser=request.getParameter("typeofuser");
          java.sql.Connection con=DB.DBBean.DBConnection();
          if(typeofuser.equals("Admin"))
          {
             String q="select * from admindata where adminid='"+uid+"'";
             java.sql.Statement stmt=con.createStatement();
             java.sql.ResultSet rs=stmt.executeQuery(q);
             if(rs.next())
             {
                 if(psw.equals(rs.getString(2)))
                 {
                      HttpSession session=request.getSession();
                     session.setAttribute("sa", uid);
                     response.sendRedirect("adminhome.jsp");
                 }
                 else
                 {
                     response.sendRedirect("login.jsp?msg=Wrong Password");
                 }
             }
               else
                 {
                     response.sendRedirect("login.jsp?msg=Wrong User ID");
                 }
          }
          
          else if(typeofuser.equals("User")) 
             {
                 
                 String q="select * from studentdata where stemail='"+uid+"'";
             java.sql.Statement stmt=con.createStatement();
             java.sql.ResultSet rs=stmt.executeQuery(q);
             if(rs.next())
             {
                 if(psw.equals(rs.getString(3)))
                 {
                     
                     
                     
                     HttpSession session=request.getSession();
                     session.setAttribute("stemail", uid);
                     
                     int otp=mail.DigInfo.otp();
                     
                     session.setAttribute("otp", otp);
                       String subj = "DigInfo OTP ";
           
            String content = "<h1> OTP : "+otp+" </h1>";
            mail.SendMail.sendMail(uid, subj, content);
                     System.out.println("setting into session"+uid);
                     response.sendRedirect("otp.jsp");
                 }
                 else
                 {
                     response.sendRedirect("login.jsp?msg=Wrong Password");
                 }
             }
               else
                 {
                     response.sendRedirect("login.jsp?msg=Wrong User ID");
                 }   
                 
                      
           }
          else if(typeofuser.equals("Company"))
          {
             
              
                  
                 String q="select * from companydata where cmail='"+uid+"'";
             java.sql.Statement stmt=con.createStatement();
             java.sql.ResultSet rs=stmt.executeQuery(q);
             if(rs.next())
             {
                 if(psw.equals(rs.getString(4)))
                 {
                    HttpSession session=request.getSession();
                     session.setAttribute("cmail", uid);
                     response.sendRedirect("companyhome.jsp");
                 }
                 else
                 {
                     response.sendRedirect("login.jsp?msg=Wrong Password");
                 }
             }
               else
                 {
                     response.sendRedirect("login.jsp?msg=Wrong User ID");
                 } 
              
              
              
              
              
          }
          
          
          
          
        }
        
        catch(Exception e)
        {
            out.println(e);
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
