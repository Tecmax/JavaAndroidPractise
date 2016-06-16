/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.util.*;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.DefaultFileItemFactory;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;

/**
 *
 * @author SattvaQ14
 */
@WebServlet(name="CardInsertServlet",urlPatterns = {"/cardinsert"})
public class CardInsertServlet extends HttpServlet 
{
     public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
     {
         System.out.println("enter into servlet");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            
            List items=null;
            DiskFileItemFactory dis=new DiskFileItemFactory();
            FileUpload upload=new FileUpload(dis);
            try {
                
                
                
                
                items=upload.parseRequest(request);
                FileItem cardItem=(FileItem)items.get(0);
                String typeOfCard=cardItem.getString();
                System.out.println("type of card"+typeOfCard);
                
                 items=upload.parseRequest(request);
                FileItem emailItem=(FileItem)items.get(1);
                String email=emailItem.getString();
                System.out.println("email id is"+email);
                        
               
                FileItem nameItem=(FileItem)items.get(2);
                String name=nameItem.getString();
                System.out.println("card holder name"+name);
                
                
                  FileItem numberItem=(FileItem)items.get(3);
                  String number=numberItem.getString();
                  System.out.println("card hoder number"+number);
                  
                  
                    FileItem locationItem=(FileItem)items.get(4);
                    
                    String location=locationItem.getString();
                    
                    
                      FileItem fileItem=(FileItem)items.get(5);
                
                CardInsertDao cardInsertDao=new CardInsertDao();
                int i=cardInsertDao.saveCard
(typeOfCard,email,name,number,location,fileItem);
                if(i>0)
                {                          request.setAttribute
("message","inserted successfully");
                                           RequestDispatcher 
rd=request.getRequestDispatcher("addcard.jsp");
                          rd.forward(request,response);
   
                    
                }
                
                
                
                
                
                
            } catch (FileUploadException ex) {
                Logger.getLogger(CardInsertServlet.class.getName()).log
(Level.SEVERE, null, ex);
            }
            
            
            
           
        } finally {
            out.close();
        }
    }
    
    
    
    
    
    
    
    
    
    
    

}

    
    