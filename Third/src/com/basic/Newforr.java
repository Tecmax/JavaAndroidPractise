package com.basic;
import java.util.*;
//import com.basic.Anagram2;

public class Newforr {
public static void main(String[] args) {
	Scanner in=new Scanner(System.in);
	int i;
	System.out.println("Enter the length");
	int n=in.nextInt();
	char a[]=new char[n];
	System.out.println("Enter the string");
	for(i=0;i<n;i++){
		a[i]=in.next().charAt(0);
	}
	
	for(int j=0;j<n;j++){
		System.out.print(a[j]);
	}
	System.out.println("In reverse order:");
	for(int j=n-1;j>=0;--j){
		System.out.println(a[j]);
	}
	
	System.out.println("Permutations of the entered string");
	
	
	
	in.close();
}
}
