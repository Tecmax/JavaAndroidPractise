package com.Strings;

import java.util.Scanner;

public class StringReverse {
public static void main(String[] args) {
	String str="abcde";
	String reverse=new StringBuilder(str).reverse().toString();
	
	System.out.println("Original string is:"+str);
	System.out.println("The reversed string is:"+reverse);
	
	String s="Hello how are you";
	//char b=s.toCharArray();

	
	Scanner in=new Scanner(System.in);
	String[] a=new String[5];
	
	System.out.println("Enter the elements:");
	for(int i=0;i<5;++i){
		a[i]=in.nextLine();
	}
	System.out.println("original string: ");
	for(int i=0;i<5;i++){
		System.out.println(a[i]);
	}
	
	System.out.println("reversed: ");
	for(int i=5;i>0;i--){
		System.out.println(a[i]);
	}
	
	
	}
}
