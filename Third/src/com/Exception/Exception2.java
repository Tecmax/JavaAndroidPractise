package com.Exception;

import java.io.FileInputStream;
import java.io.IOException;

public class Exception2 {
	public static void main(String args[]) throws IOException
	   {
	      FileInputStream fis = null;
	      fis = new FileInputStream("D:/2.txt.txt"); 
	      int k; 

	      while(( k = fis.read() ) != -1) 
	      { 
		   System.out.print((char)k); 
	      } 
	      fis.close(); 	
	   }
}
