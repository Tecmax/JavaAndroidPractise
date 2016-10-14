package com.java.basics;

/* Name of the class has to be "Main" only if the class is public. */
public class objExample {
	int i=9;
	public static void main(String[] args) {
		objExample obj = new objExample();
		obj.add(276, 3);
		int sub = sub(276, 3);
		double div = div(25, 5);
		float mult= obj.mult(5, 5);
		System.out.println(sub);
		System.out.println(mult);
		System.out.println(div);
		
		if(obj.compare(6,8))
		{
			System.out.println("b is greater than a");
		}
		else
		{
			System.out.println("a is greater than b");
		}
		obj.compare(8, 6);
	}

	private void add(int i, int j) {
		System.out.println(i + j);

	}

	private static int sub(int i, int j)
	{
		return i - j;
	}

	private static double div(int i, int j) {
		return i / j;
	}

	private float mult(float i, float j)
	{
		return i * j;
	}

	private boolean compare(int i, int j)
	{
		if (i > j) {
			return true;
		} else
			return false;
	}
}
