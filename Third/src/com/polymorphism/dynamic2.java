package com.polymorphism;

class Super {														//HOW STATIC METHODS WORK!!
	int a, b;

	static void add() {
		System.out.println("super class add() method");
	}
}
/* class Sub extends Super {
	void add() { // ERROR:This instance method cannot override the static method
		System.out.println("this is sub class add() method");
	}

	public static void main(String[] args) {

		Sub obj = new Sub();
	}
}*/													
public class dynamic2 extends Super {								// Static methods are class level so we need 
																	//-to access by using class name.
	static void add() {// works fine
		System.out.println("this is sub class add() method");
	}

	public static void main(String[] args) {

		Super.add();
		dynamic2.add();

	}

}
