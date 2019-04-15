package com.polymorphism;

interface Multiply {
	public abstract int multiplyTwo(int n1, int n2);

	int multiplyThree(int n1, int n2, int n3);
}

interface Multiply2 extends Multiply {
	public abstract int multiplyTwo(int n1, int n2);

	int multiplyThree(int n1, int n2, int n3);
}

abstract class G extends D implements Multiply, Multiply2 {
	public abstract int multiplyTwo(int n1, int n2);

	public abstract int multiplyThree(int n1, int n2, int n3);
	
	public abstract int main(int i);

	public void add() {
		System.out.println("hai");
	}

	public void show() {
		System.out.println("How");
	}

	public void add(int i) {
		System.out.println("hello");
	}
}

abstract class D {
	abstract void show();

	public void ex() {
		System.out.println("wow1");
	}
	int Multiply(int n1,int n2){
		return 0;
	}
}

class F extends D implements Multiply2{
	public void ex() {
		System.out.println("wow");
	}
	
	void show(){
		System.out.println(" ");
	}
	
	public int multiplyTwo(int n1, int n2){
		return 0;
	}
	public int multiplyThree(int n1, int n2, int n3){
		return 0;
	}

}

/*
 * class H implements Multiply{ public void add(){ System.out.println("hai"); }
 * public void add(int i){ System.out.println("hello"); } }
 */
class Abstractt extends G implements Multiply, Multiply2 {
	public int multiplyTwo(int num1, int num2) {
		return num1 * num2;
	}

	public void show() {
		System.out.println("bro");
	}

	public int multiplyThree(int num1, int num2, int num3) {
		return num1 * num2 * num3;
	}

	public static void main(String args[]) {
		Abstractt obj = new Abstractt();
		System.out.println(obj.multiplyTwo(3, 7));
		System.out.println(obj.multiplyThree(1, 9, 0));
	}
	public int main(int i) {
		return 0;
	}
	public void main(){
		
	}
}