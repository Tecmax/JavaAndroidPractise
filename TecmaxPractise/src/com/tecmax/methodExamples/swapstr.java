package com.tecmax.methodExamples;

public class swapstr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a="java";
		String b="programming";
		
	    a.concat(b);
	    b=a.substring(0, (a.length()-b.length()));
	    a=a.substring(b.length());
	    System.out.println("value of a: "+a);
	    System.out.println("value of b: "+b);


	}

}
