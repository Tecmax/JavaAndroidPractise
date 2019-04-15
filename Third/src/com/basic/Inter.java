package com.basic;

interface Multiply {
	public abstract int multiplyTwo(int n1, int n2);

	int multiplyThree(int n1, int n2, int n3);
}

interface Multiply2 extends Multiply {
	public abstract int multiplyTwo(int n1, int n2);

	int multiplyThree(int n1, int n2, int n3);
}

abstract class G {
	public abstract int multiplyTwo(int n1, int n2);

	abstract int multiplyThree(int n1, int n2, int n3);

	public void add() {
		System.out.println("hai");
	}

	public void add(int i) {
		System.out.println("hello");
	}
}

/*
 * class H implements Multiply{ public void add(){ System.out.println("hai"); }
 * public void add(int i){ System.out.println("hello"); } }
 */
class Inter extends G implements Multiply,Multiply2{
	public int multiplyTwo(int num1, int num2) {
		return num1 * num2;
	}

	public int multiplyThree(int num1, int num2, int num3) {
		return num1 * num2 * num3;
	}

	public static void main(String args[]) {
		Inter obj = new Inter();
		System.out.println(obj.multiplyTwo(3, 7));
		System.out.println(obj.multiplyThree(1, 9, 0));
	}
}