package com.vishwa.corejava;

public class Methods {
	public static void main(String[] args) {
		Methods.sub(99, 55);
		Methods obj = new Methods();
		obj.add(12, 56);
		double div = obj.div(12.96, 5.656);
		float mul = multi(23f, 54.44f);
		System.out.println(mul);
	}

	private double div(double d, double e) {
		return d / e;
	}

	public static float multi(float f, float g) {
		return f * g;
	}

	public void add(int x, int y) {
		System.out.println(x + y);
	}

	public static void sub(int x, int y) {
		System.out.println(x - y);
	}

	private void multiply() {

	}
}
