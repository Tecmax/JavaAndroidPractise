package com.basic;

public class Anagram3 {

	public static char[] charArray;

	public Anagram3(String word) {
		charArray = word.toCharArray();
		doAnagram(charArray.length);
	}

	public void cO(int ns) {
		int i;
		int p = charArray.length - ns;
		char temp = charArray[p];
		for (i = 0; i < ns; i++) {
			charArray[i] = charArray[i + 1];
		}
		charArray[i] = temp;
	}

	public void doAnagram(int ns) {
		if (ns == 1) {
			return;
		}

	}

	void display() {
		for (int i = 0; i < charArray.length; i++) {
			System.out.print(charArray[i]);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		new Anagram3("Lo");
	}
}
