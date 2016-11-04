package com.Amnahjava.overriding;

import java.util.Scanner;

public class Check {
	public static void main(String[] args) {
		String str1, str2;
		int i, j, len1, len2, len, F = 0, NF = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("enter first string");
		str1 = scan.nextLine();
		System.out.println("enter second string");
		str2 = scan.nextLine();
		len1 = str1.length();
		len2 = str2.length();
		if (len1 == len2) {
			len = len1;
			for (i = 0; i < len; i++) {
				F = 0;
				for (j = 0; j <  len; j++) {
					if (str1.charAt(i) == str2.charAt(j)) 
					{
						F = 1;
						break;
					}
				}

				if (F == 0) {
					NF = 1;
					break;
				}

			}
			if (NF == 1) {
				System.out.println("not an anagram");
			} else {
				System.out.println("anagram");
			}
		} //
		else {
			System.out.println("Both Strings Must have the same number of Character to be an Anagram");

		}
		scan.close();
	}

}
