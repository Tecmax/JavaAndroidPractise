package com.mahesh.exceptionHandelling;

public class Finally {
	public static int myMethod() {
		try {
			// try block
			System.out.println("Inside Try block");
			String a=null;
			System.out.println(a.length());
			return 750;
		} catch (NullPointerException e) {
			System.out.println("Inside catch block");
			return 82;
		}finally {
			// finally
			System.out.println("Inside Finally block");
			return 30;
		}
	}

	public static void main(String args[]) {
		System.out.println(Finally.myMethod());
	}
}
