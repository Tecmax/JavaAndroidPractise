package com.basic;
import java.util.*;

public class Pyramid {
public static void main(String[] args) {
	Scanner in=new Scanner(System.in);
	int n=0;
	System.out.println("Enter the max nor:");
	n=in.nextInt();
	for(int i=1;i<n;i++){
		for(int j=0;j<i;++j){
			System.out.print("*");
		}
		System.out.println();
	}
	for(int i=n;i>=0;--i){
		for(int j=0;j<i;++j){
			System.out.print("*");
		}
		System.out.println();
	}
	in.close();
}
}
