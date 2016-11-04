package com.Amnahjava.overriding;

public class Anagram {

	public static char[] charArray;
	public static void main(String args[]) {
		new Anagram("amna");

	}

	public Anagram(String word) {
		charArray = word.toCharArray();
		doAnagram(charArray.length);
	}

	public void doAnagram(int newsize) {
		if (newsize == 1) {
//			System.out.println("It is not a word" + newsize);
			return;
		}
		for (int i = 0; i < newsize; i++) {
			doAnagram(newsize - 1);
			if (newsize == 2) {
				display();
			}
			changeOrder(newsize);
		}
	}

	public void changeOrder(int newsize) {
		int j;
		int pointAt = charArray.length - newsize;
		char temp = charArray[pointAt];

		for (j = pointAt + 1; j < charArray.length; j++) {
			charArray[j - 1] = charArray[j];
		}

		charArray[j - 1] = temp;

	}

	public void display() {
		for (int i = 0; i < charArray.length; i++) {
			System.out.print(charArray[i]);
		}
		System.out.println();
	}
}

