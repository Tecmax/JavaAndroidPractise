package com.Amnahjava.overriding;

public class StringConcept {
	public static void main(String[] args) {

		String str = "2345";
		int str2 = Integer.parseInt(str);
		double str3= Double.parseDouble(str);
		System.out.println(str2);
		System.out.println(str3);
		// append
		StringBuffer am = new StringBuffer("amna");
		am.append("is good");
		System.out.println(am);
		// reverse
		StringBuffer buffer = new StringBuffer("hello how are you");
		buffer.reverse();
		System.out.println(buffer);
		// delete
		StringBuffer d = new StringBuffer("hello world");
		d.delete(6, 7);
		System.out.println(d);
		// insert
		// public StringBuffer insert(int offset, String str)
		StringBuffer in = new StringBuffer("hello world");
		in.insert(9, "yo");
		System.out.println(in);
		// replace
		StringBuffer r = new StringBuffer("hello world");
		r.replace(0, 5, "hey");
		System.out.println(r);
		// stringbuilder
		StringBuilder sr = new StringBuilder("hello how are you");
		sr.reverse();
		System.out.println(sr);
	}
}