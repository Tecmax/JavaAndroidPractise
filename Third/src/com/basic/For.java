package com.basic;

abstract class Sum {
	public abstract int SumofTwo(int n1, int n2);

	public abstract int SumofThree(int n1, int n2, int n3);

	public void disp() {
		System.out.println("Method of class Sum");
	}
}

class For extends Sum {
	public int SumofTwo(int x1, int x2) {
		return x1 + x2;
	}

	public int SumofThree(int x1, int x2, int x3) {
		return x1 + x2 + x3;
	}
	
	public int SumofTwo(int x1) {
		return x1;
	}

	public static void main(String[] args) {
		For ob = new For();
		System.out.println(ob.SumofTwo(3, 7));
		System.out.println(ob.SumofThree(4, 3, 19));
		ob.disp();
	}
}
