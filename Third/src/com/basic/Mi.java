package com.basic;

interface Multiply3 {
	public abstract int multiplyTwo(int n1, int n2);

	int multiplyThree(int n1, int n2, int n3);
}

abstract class K {
	public abstract int multiplyTwo(int n1, int n2);

	int multiplyThree(int n1, int n2, int n3){
		System.out.println("Hai");
		return 0;
	}
}
 class Mi extends K implements Multiply3{
	public int multiplyTwo(int num1, int num2) {
		return num1 * num2;
	}

	public int multiplyThree(int num1, int num2, int num3) {
		
		System.out.println(super.multiplyThree(2,3,4));
		return num1 * num2 * num3;
	}
	

	public static void main(String args[]) {
		Mi obj = new Mi();
		System.out.println(obj.multiplyTwo(3, 7));
		System.out.println(obj.multiplyThree(1, 9, 0));
		
		System.out.println();
		
	}
}