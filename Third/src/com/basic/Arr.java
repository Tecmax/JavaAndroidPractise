package com.basic;
import java.util.Scanner;

public class Arr {
	
	   //-----------------------------------------------------------------
	   //  Reads a list of char from user and prints in reverse.
	   //-----------------------------------------------------------------
	   public static void main (String[] args)
	   {
	      Scanner scan = new Scanner (System.in);

	      char[] letters = new char[10];

	      System.out.println ("The size of the array: " + letters.length);
	      for (int i = 0; i < letters.length; i++)
	      {
	         //System.out.print ("Enter number " + (i+1) + ": ");
	         letters[i] = scan.next().charAt(0); //doesnt like this line
	      }

	      System.out.println ("The numbers in reverse order:");

	      for (int i = letters.length-1; i >= 0; i--)
	         System.out.print (letters[i] + "  ");
	      scan.close();
	   }
}
