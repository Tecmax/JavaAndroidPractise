package com.Strings;

public class SearchLastString {
public static void main(String[] args) {
	String str="Hello world,Hello reader";
	int lastIndex=str.lastIndexOf("Hello");
	if(lastIndex==-1){
		System.out.println("Last index not found");
	}
	else
		System.out.println("Last index of Hello found at position"+lastIndex);
}
}
