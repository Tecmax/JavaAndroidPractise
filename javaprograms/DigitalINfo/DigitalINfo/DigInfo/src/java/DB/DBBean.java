/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.DriverManager;

/**
 *
 * @author SattvaQ
 */
public class DBBean {
   public static java.sql.Connection DBConnection()throws Exception
   {
       Class.forName("com.mysql.jdbc.Driver");
       java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/diginfo","root","");
       return con;
   }
    
    
    
}
