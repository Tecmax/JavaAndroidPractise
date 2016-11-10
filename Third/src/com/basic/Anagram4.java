package com.basic;

public class Anagram4 {

	public static void main(String[] args) {
		String str1 = "aefdz";
		String str2 = "afgez";
		System.out.println("Anagram?? :" + isAnagram(str1, str2));
	}

	private static boolean isAnagram(String a, String b) {

		// if both string is null, then considering it as anagram.
		if (a == b) {
			return true;
		}

		// if any one string is null, then they are not anagram.
		if (a == null || b == null)
			return false;

		// If length of both strings are not same then obviously they are not
		// anagrams.
		if (a.length() != b.length())
			return false;

		char[] aArr = a.toLowerCase().toCharArray();
		char[] bArr = b.toLowerCase().toCharArray();

		// An array to hold the number of occurrences of each character
		int[] counts = new int[30];

		for (int i = 0; i < aArr.length; i++) {
			counts[aArr[i] - 93]++; // Increment the count of the character at
									// respective position
			counts[bArr[i] - 93]--; // Decrement the count of the character at
									// respective position
		}

		// If the strings are anagrams, then counts array will be full of zeros
		// not otherwise
		for (int i = 0; i < 30; i++) {
			if (counts[i] != 0)
				return false;
		}

		return true;
	}
}
