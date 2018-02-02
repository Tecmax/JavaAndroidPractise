package com.vinith.javabasic;

import java.util.Scanner;

public class scannner {
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		System.out.println("enter id");
		int id= s.nextInt();
		System.out.println("enter name");
		String name=s.next();
		System.out.println("enter exp");
		int exp=s.nextInt();
		System.out.println("enter branch");
		String branch=s.next();
		System.out.println("enter salary");
		int salary=s.nextInt();
		System.out.println("enter address");
		String address=s.next();
		s.close();
	}

}
