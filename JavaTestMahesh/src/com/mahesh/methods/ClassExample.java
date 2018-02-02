package com.mahesh.methods;

import java.util.Scanner;

public class ClassExample {

	public static void main(String[] args) {
		 System.out.println("HEllo");
		 Scanner obj = new Scanner(System.in);
		 System.out.println("Enter Name");
		 String ac = obj.next();
		 System.out.println("Entered Name is "+ ac);
		 obj.close();
	}

	
}
