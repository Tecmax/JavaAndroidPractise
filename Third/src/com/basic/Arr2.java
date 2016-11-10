package com.basic;

import java.util.Scanner;

public class Arr2 {
	    public static void main (String[] args)
	    {
	      Scanner scan = new Scanner (System.in);

	      char[] letters = new char[10];

	      System.out.println ("The size of the array: " + letters.length);
	      for (int index = 0; index < letters.length; index++)
	      {
	         System.out.print ("Enter number " + (index+1) + ": ");
	         letters[index] = scan.next().charAt(0);

	      }

	      System.out.println ("The numbers in reverse order:");

	      for (int index = letters.length-1; index >= 0; index--)
	         System.out.print (letters[index] + "  ");
	      scan.close();
	    }
}
