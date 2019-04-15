package com.Strings;

public class WordSearch {
public static void main(String[] args) {
	String str="Hello world, Hello bro..";
	int id=str.indexOf("Hello");
	int id1=str.indexOf("Hello", 4);
	
	if(id==-1 && id1==-1){
		System.out.println("Position of Hello could'nt be found");
	}
	else
		System.out.println("Hello found at position "+id+","+id1);
}
}
