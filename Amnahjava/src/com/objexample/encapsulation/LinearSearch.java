package com.objexample.encapsulation;

import java.util.Scanner;

class LinearSearch {
	public static void main(String[] args) {
		int counter, num, item, array[];
		Scanner inputValue = new Scanner(System.in);
		System.out.println("enter the elements");
		num = inputValue.nextInt();
		array = new int[num];
		System.out.println("enter" + num + "integers");
		for (counter = 0; counter < num; counter++)
			array[counter] = inputValue.nextInt();
		System.out.println("enter the search valur");
		item = inputValue.nextInt();
		inputValue.close();
		for (counter = 0; counter < num; counter++) {
			if (array[counter] == item) {
				System.out.println(item + " is present at location " + (counter + 1));
				break;
			}
		}
		if (counter == num)
			System.out.println(item + " doesn't exist in array.");
	}
}