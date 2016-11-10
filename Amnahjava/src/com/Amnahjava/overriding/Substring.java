package com.Amnahjava.overriding;

public class Substring {
	public static void main(String[] args) {// alt+shift+z for try catch
		String a = " hello how are you";
		System.out.println(a.substring(0));// taking from 1 index
		System.out.println(a.substring(10, 12));
		System.out.println(a.trim());// only starting and end spaces will be
										// trimmed
		Double d = new Double(1.23);
		Integer in= new Integer(6);
		Float F= new Float(9.56432);
		Double l= in.doubleValue();
		int i = d.intValue();
		float j= d.floatValue();
		long b= d.longValue();
		float k= in.floatValue();
		float m= F.intValue();
		System.out.println(i);
		System.out.println(j);
		System.out.println(b);
		System.out.println(k);
		System.out.println(l);
		System.out.println(m);// throws can only be applied to a method
	}
}
