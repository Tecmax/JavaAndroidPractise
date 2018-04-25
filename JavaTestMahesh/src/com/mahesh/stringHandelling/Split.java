package com.mahesh.stringHandelling;

public class Split {
	public static void main(String[] args) {
		String m = new String("i am sandep");
		String[] count = m.split(" ");
		System.out.println(m.length());
		System.out.println(count.length);
		for (int i = 0; i < count.length; i++) {
			System.out.println(count[i]);
		}
		for (int i = 0; i < m.length(); i++) {
			System.out.println(m.charAt(i));
		}
		// String.valueOf(m.charAt(2)).equalsIgnoreCase(String.valueOf(m.charAt(2)));
		// for (int i = count.length - 1; i >= 0; i--) {
		// System.out.print(count[i].toString() + " ");
		// }
	}
}