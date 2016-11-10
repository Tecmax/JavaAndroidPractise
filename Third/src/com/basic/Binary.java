
package com.basic;

import java.util.*;

public class Binary {
	public static void main(String args[]) {
		Scanner venu = new Scanner(System.in);
		int l = 0;
		int h = 0;
		int m = 0;
		int n = 0;
		int key = 0;
		int i = 0;
		System.out.print("enter key");
		key = venu.nextInt();
		System.out.println("Enter the nor of elements");
		n = venu.nextInt();
		int a[] = new int[n];
		System.out.println("enetr the no!");
		for (i = 0; i<n; i++){ 
			a[i] = venu.nextInt();}
		h = n - 1;
		while (l <= h) {
			m = (l + h) / 2;
			if (a[m] == key) {
				break;
			} else if (key < m) {
				h = m - 1;
			} else {
				l = m + 1;
			}
		}
		System.out.println("The nor id in the position" + (m+1));
		venu.close();
	}
}
