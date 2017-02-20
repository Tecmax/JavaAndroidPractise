package com.mahesh.methods;

import java.util.Scanner;

public class ClassTestSoft {
	public static void main(String[] args) {
		System.out.println("Hi");
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Your Name");
		String ss = scan.next();
		System.out.println("Enter the Id");
		int ii = scan.nextInt();
		System.out.println("Name Is " + ss + " And Id is " + ii);
		scan.close();
	}
}
