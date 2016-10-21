package com.objexample.encapsulation;

import java.util.Scanner;

public class UserInput {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter your total bill");
		int bill = sc.nextInt();
		System.out.println("enter your discount in %");
		double discount = sc.nextDouble();
		System.out.println("enter your Vat");
		double vat = sc.nextDouble();
		double discountc = bill * (discount / 100);
		double vatc = bill * (vat / 100);
		double netbill = bill - discountc;
		System.out.println("your Total bill is " + bill);
		System.out.println("your vat is " + vatc);
		System.out.println("your discount is " + discountc);
		System.out.println("your Net Amount is " + netbill);
		sc.close();

	}

}
