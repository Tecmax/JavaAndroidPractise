package com.basic;

public class Static1 {

	static int a=10;
	static int b=20;
	 
	 public static void main(String [] args){
	 
		 b=30;
		 final int b=50;
	   System.out.println("a="+a);
	   System.out.println("a="+b);
	   show();

	 }
	 
	public static void show(){
		final int b=34;
	   System.out.println("a="+(a+5));
	   System.out.println("a="+(b+60));
	}
}
