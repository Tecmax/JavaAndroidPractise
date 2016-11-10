package com.polymorphism;

 class A {											//DYNAMIC POLYMORPHISM MEANS OVERRIDING.

	void show(String s) {								

		System.out.println("super class method");

	}

}

public class Dynamicpoly extends A {

	void show(String s) {							//OVERRIDED METHOD SHOW()

		System.out.println("sub class method");

	}

	public static void main(String[] args) {
		Dynamicpoly obj = new Dynamicpoly();
		obj.show("overrided show()!!");
	}

}
