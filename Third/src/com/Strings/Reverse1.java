package com.Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reverse1 {
public static void main(String[] args) {
	String s="";
	System.out.println("Enter the input string");
	try{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		s=br.readLine();
////		char[] try1=s.toCharArray();
////		for(int i=try1.length-1;i>=0;i--){
////			System.out.print(try1[i]);
		
//		s.reverse();
		System.out.println(s);
		
	}
	catch(IOException e){
		e.printStackTrace();
	}
}
}
