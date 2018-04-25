package com.mahesh.stringHandelling;

public class StartsWith {
	public static void main(String[] args) {
		String str = "tecmax";
		System.out.println(str.startsWith("max",5));
		System.out.println(str.startsWith("tec"));
		
		System.out.println(str.endsWith("max"));
	}
}
