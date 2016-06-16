/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SattvaQ14
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.fileupload.FileItem;
public class CardInsertDao
{
   public int  saveCard(String typeOfCard,String email,String name,String number,String location,FileItem fileItem)
   {
      
       int i=0;
       try {
           System.out.println("dao card"+typeOfCard);
           System.out.println("dao email"+email);
           System.out.println("dao name"+name);
           System.out.println("dao number"+number);
           System.out.println("dao loaction"+location);
           
                  
           
           System.out.println("type of card"+typeOfCard);
          // System.out.println("email"+email);
           java.sql.Connection con = DB.DBBean.DBConnection();
           PreparedStatement ps=con.prepareStatement("insert into carddetails values(?,?,?,?,?)");
           ps.setString(1,typeOfCard);
          ps.setString(2,email);
           ps.setString(3,name);
           ps.setString(4,number);
           ps.setString(5,location);
           
           i=ps.executeUpdate();
          // System.out.println("email insertd"+email);
           
           int size=(int)fileItem.getSize();
           byte b[]=new byte[size];
           InputStream is=fileItem.getInputStream();
           is.read(b);
           FileOutputStream fos=new FileOutputStream("d://azimnew/"+number+".jpg");
           fos.write(b);
           
        
           
           
           
           
           
       } catch (Exception ex) {
           Logger.getLogger(CardInsertDao.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       
       
       
       
       
       return i;
   }
}