package com.Amnahjava.overriding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reverse {
	public static void main(String[] args) {

		String str = "hello how are you";
		
		
		String rev = new StringBuffer(str).reverse().toString();
		System.out.println(rev);
		StringBuilder sr = new StringBuilder("hello how are you");
		sr.reverse();
		System.out.println(sr);

		char[] str2 = str.toCharArray();

		for (int i = str.length() - 1; i >= 0; i--)
			System.out.print(str2[i]);
		System.out.println("");

		char temp;
		char[] arr = str.toCharArray();
		int len = arr.length;
		for (int i = 0; i < (str.length()) / 2; i++,len--)
		{// why/2
			temp = arr[i];
			arr[i] = arr[len - 1];
			arr[len - 1] = temp;
		}

		System.out.println("Reverse String :" + String.valueOf(arr));// to
																		// convert
																		// any
																		// type
																		// to
																		// string
																		// type

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter string: ");
		String s = null;
		try {
			s = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String reverse = "";
		int length = s.length();
		{

			for (int i = length - 1; i >= 0; i--)
				reverse = reverse + s.charAt(i);
			System.out.println("Result:" + reverse);

			String str1[] = "Hello how are you".split(" ");
			String finalStr = "";
			for (int i = str1.length - 1; i >= 0; i--) {
				finalStr += str1[i] + " ";
			}
			System.out.println(finalStr);
		}
	}
}
