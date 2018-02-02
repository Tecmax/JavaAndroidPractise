package com.mahesh.stringHandelling;

public class CopyValueOfExample {
	public static void main(String args[]) {
		char[] data = { '1', '2', 'c', 'd', 'e', 'f', '5', 'h', 'i', 'j', 'k' };
		String str1 = "Text";
		String str2 = "String";
		// Variation 1:String copyValueOf(char[] data)
		str1 = str1.copyValueOf(data);
		System.out.println("str1 after copy: " + str1);

		// Variation 2:String copyValueOf(char[] data,int offset,int count)
		str2 = str2.copyValueOf(data, 5,4);
		System.out.println("str2 after copy: " + str2);
	}
}
