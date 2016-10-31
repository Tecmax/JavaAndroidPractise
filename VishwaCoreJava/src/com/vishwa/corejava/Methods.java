package com.vishwa.corejava;

public class Methods {
	public static void main(String[] args) {
		Methods.sub(99, 55);
		Methods obj = new Methods();
		obj.add(12, 56);
	}

	public void add(int x, int y) {
		System.out.println(x + y);
	}

	public static void sub(int x, int y) {
		System.out.println(x - y);
	}
}
