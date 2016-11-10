package com.basic;

public class C extends B {

	public void display() {

		System.out.println("C class display method");

	}

	public static void main(String[] args) {

		C obj = new C();

		obj.print();
		obj.show();
		obj.display();

	}

}
