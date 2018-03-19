package com.mahesh.abstraction;

import java.util.Arrays;
import java.util.Comparator;

public class Tesg {
	public static void main(String[] args) {
		String S = "No one could disentangle correctly";
//       String W[] = S.split(" ");
//        Arrays.sort(W, new StringLengthComparator());
//        String a="";
//        for(String str: W)
//        	a+= str + " ";
//        System.out.println(a); 
	}
	
	// int fibonacci(int n) {
	// switch(n) {
	// default:
	// return fibonacci(n-1)+fibonacci(n-2);
	// case1:
	// case2:
	// }
	// return 1;
	// }
}

class StringLengthComparator implements Comparator<String>{ 
    @Override
        public int compare(String str1, String str2) {
            return str1.length() - str2.length();
        }
 }
