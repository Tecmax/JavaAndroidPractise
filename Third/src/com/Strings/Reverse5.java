package com.Strings;

public class Reverse5 {
	 public static void main(String[] args) {
		  String input = "Be in present";			//s=string as byte array!!
		  byte [] s = input.getBytes();
		  byte [] result = new byte [s.length];
		   
		  for(int i = 0; i<s.length; i++){
		  result[i] = s[s.length-i-1];
		  }
		  System.out.println( new String(result));
	 }
}
