package com.objexample.encapsulation;

public class Overloading {
	public static void main(String[] args) 
	{
		Overloading obj=new Overloading();
		obj.sub(12);
		obj.sub(23.33f);
		obj.sub(43, 23.33f);
		obj.sub(322, 32, 23);
		obj.sub(12, 22.332);
		obj.sub(323.32, 21);
		
	}
		private void sub(double d, int d2)
		{
			System.out.println(d+d2);
		}
		private void sub(int i, double d)
		{
			System.out.println(i+d);
		
		}
		private void sub(int i, int j, int k) {
			System.out.println(i+j+k);
		}
		private void sub(int i, float f)
		{
			System.out.println(i+f);
		}
		private void sub(float f)
		{
			System.out.println(f);
		}
		private void sub(int i)
		{
			System.out.println(i);
		}
		
}
