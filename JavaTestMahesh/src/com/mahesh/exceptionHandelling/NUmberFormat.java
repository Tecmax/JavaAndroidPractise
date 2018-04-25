package com.mahesh.exceptionHandelling;

public class NUmberFormat {
	public static void main(String args[]) {
		try {
			int num = Integer.parseInt("12");
			System.out.println(num);
			String a = "55.55";
			float num1 = Float.parseFloat(a);
			System.out.println(num1);
			double num2 = Double.parseDouble("12.3");
			System.out.println(num2);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}
}
