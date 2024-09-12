package com.raki.classex;

 abstract class abster {

	public void method1() {
		System.out.println("am in method1");
	}

	public void method2() {

		System.out.println("am in method1");
	}
}

public class Concerte extends abster {
	public static void main(String[] args) {

		Concerte obj = new Concerte();
		obj.method1();
		obj.method2();

	}
}
