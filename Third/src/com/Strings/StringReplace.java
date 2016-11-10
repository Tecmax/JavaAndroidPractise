package com.Strings;

public class StringReplace {
public static void main(String[] args) {
	String str="Hello world, Hello man";
	System.out.println(str.replace('H', 'W'));
	System.out.println(str.replaceAll("o","p"));
	System.out.println(str.replaceFirst("He", "ha"));
	System.out.println(str.replace("He","Ha"));
	
	
	String st="Hello dude , how are you?";
	System.out.println(st.toUpperCase());
	System.out.println(st.toLowerCase());
	
}
}
