package com.basic;

abstract class Sag {

	public void disp() {
		System.out.println("Hello");
	}

	public abstract void add();

}

abstract class I extends Sag {

	public abstract void add();
	public void add1() {
		System.out.println("The sum of 2 nors 3 and 5 is: 8");
	}

}

public class Dd extends I{
	public static void main(String[] args) {
		
		Dd ob=new Dd();
		ob.sub();
		ob.add();
		ob.disp();
		ob.add1();

	}
	public void add(){
		System.out.println("Overrided method");
	}
	public void sub(){
		System.out.println("The sum of 6 and 3 is: 3");
	}
}