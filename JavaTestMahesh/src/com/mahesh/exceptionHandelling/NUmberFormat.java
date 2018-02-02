package com.mahesh.exceptionHandelling;

public class NUmberFormat {
	public static void main(String args[]) {
		try {
			int num = Integer.parseInt("12.3");
			System.out.println(num);
			String a = null;
			float num1 = Float.parseFloat(a);
			System.out.println(num1);
			double num2 = Double.parseDouble("12.3");
			System.out.println(num2);
		} catch (NumberFormatException e) {
			System.out.println("Number format exception occurred");
		} catch (NullPointerException e) {
			System.out.println("N format exception occurred");
		}
	}
}
