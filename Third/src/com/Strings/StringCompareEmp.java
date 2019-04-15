package com.Strings;

public class StringCompareEmp {
public static void main(String[] args) {
	String str="Hello";
	String anotherstr="hello";
	Object obj=str;
	
	System.out.println(str.compareTo(anotherstr));
	System.out.println(str.compareToIgnoreCase(anotherstr));
	System.out.println(str.compareTo(obj.toString()));
}
}
