package com.basic;

public class Newfor {
	public static void main(String[] args) {
		int k=0;
		int i=0;
		int j=0;
		int s=4;
		for (i = 0; i <=4; ++i) {
			for(k=0;k<=s-1;k++)
			System.out.print(" ");
			
			s--;										//imp
														//
			for (j = 0; j <=(2*i); j++) 				//
				System.out.print("*");					//
			
			System.out.println();
		}
		  s = 4;										//important
			
		  //System.out.print(" ");
		  for (k = 0; k <= 5 - 1; k++)
		  {
		    for (i = 0; i <= k; i++)					//important steps
		      System.out.print(" ");					//imp	    											//imp										//imp
		 
		    for (j = 0 ; j <= 2*s-2; j++)
		      System.out.print("*");
		    
		    s--;
		 
		    System.out.println();
		  }
	}
}
