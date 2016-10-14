package com.objexample.encapsulation;
import java.util.Scanner;

public class UserInput {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("enter your total bill");
		int bill=sc.nextInt();
		System.out.println("enter your discount");
		double Discount=sc.nextDouble();
		System.out.println("your discount is" + Discount); 
		//double vat= discount*(5.5/100);
		//System.out.println("your vat is" + vat);
		//double Vat=sc.nextDouble();
		double Newbill= bill*(10/100);
		System.out.println("your new bill is" + Newbill); 
		sc.close();
		
	}

}
