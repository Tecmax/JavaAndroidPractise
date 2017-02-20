package com.mahesh.Examples;

public class Hello {
	public static void main(String[] args) {
		Hello obj = new Hello();
		obj.add(10, 20);
		sub(35, 55);
	}

	void add(int a, int b) {
		System.out.println("add");
	}

	static int sub(int a, int b) {
		System.out.println(a - b);
		return a - b;	
	}
}
