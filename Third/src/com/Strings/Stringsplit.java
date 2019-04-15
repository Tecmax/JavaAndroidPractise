package com.Strings;

public class Stringsplit {
	public static void main(String[] args) {
		String str = "Hai,hello,namaskara,vanakkam,namaste,vande maataram";
		String[] temp;
		String delimiter = "//,";
		temp = str.split(delimiter);
		for (int i = 0; i < temp.length; i++) {
			System.out.println(temp[i]);
			System.out.println();
			// // str = "ondu erdu mooru nalku aidu muchchu";
			 delimiter = "\\,";
			 temp = str.split(delimiter);
//			 System.out.println(temp[0]);
			// }
			// for (int i = 0; i < temp.length; i++) {
			// System.out.println("");
			// temp = str.split(delimiter, 2);
			// System.out.println(temp[i]);
			// for (int j = 0; j < temp.length; j++) {
			// System.out.println(temp[j]);
			// }
			// }
		}
	}
}
