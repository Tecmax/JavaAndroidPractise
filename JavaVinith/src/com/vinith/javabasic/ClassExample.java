package com.vinith.javabasic;

public class ClassExample {
	public int sum(int a, int b) {
		int c;
		c = a + b;
		return c;
	}

	public int sub(int a, int b) {
		int c;
		c = a - b;
		return c;
	}

	public float mul(float a, float b) {
		float c;
		c = a * b;
		return c;
	}

	public double div(double a, double b) {
		double c;
		c = a / b;
		System.out.println("sdzfdsfd");
		return c;
	}

	public boolean gre(int a, int b) {
		if (a > b)
			return true;
		return false;
	}

	public static void main(String[] args) {
		ClassExample c = new ClassExample();
		System.out.println("sum is" + c.sum(1, 2));
		System.out.println("sub is" + c.sub(3, 2));
		System.out.println("mul is" + c.mul(1.12f, 2.32f));
		System.out.println("div is" + c.div(1, 2));
		System.out.println("ans is" + c.gre(3, 2));

	}
}
