package com.Strings;

public class RemoveAChar {
public static void main(String[] args) {
	String str="This is java";
	System.out.println(removeCharAt(str,3));
	
	String s="Hello brother";
	System.out.println(s.substring(0, 8)+s.substring(7));
}
	
	public static String removeCharAt(String s, int pos){
		return s.substring(0,pos)+s.substring(pos+1);
	}
}
