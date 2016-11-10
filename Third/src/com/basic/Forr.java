package com.basic;
import java.util.*;

public class Forr {
public static void main(String[] args) {
	Scanner in=new Scanner(System.in);
	  int n, c, k, space = 1;
	 
	  System.out.println("Enter number of rows\n");
	  n=in.nextInt();
	 
	  space = n - 1;
	 
	  for (k = 1; k <= n; k++)
	  {
	    for (c = 1; c <= space; c++)
	      System.out.print(" ");
	 
	    space--;
	 
	    for (c = 1; c <= 2*k-1; c++)
	      System.out.print("*");
	 
	    System.out.println();
	  }
	 
	  space = 1;
	 
	  for (k = 1; k <= n - 1; k++)
	  {
	    for (c = 1; c <= space; c++)
	      System.out.print(" ");
	 
	    space++;
	 
	    for (c = 1 ; c <= 2*(n-k)-1; c++)
	      System.out.print("*");
	 
	    System.out.println();
	  }
	  in.close();
	}
}

