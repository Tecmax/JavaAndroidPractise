package Interfaces;

interface One {
	public void A();
	int i = 2;
}

interface Two {
	public void A();
	int i = 4;
}

public class Interf implements One, Two {

	public void A() {

	}
	public static void main(String[] args) {
		// Interf obj = new Interf();
		One o = new Interf();
		o.A();
		Two t = new Interf();
		t.A();
		System.out.println(One.i);
		System.out.println(Two.i);
	}
}
