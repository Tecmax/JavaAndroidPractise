package com.Strings;

public class Reverse3 {
public static void main(String[] args) {
	String i="Be in present";
	char[] temp=i.toCharArray();
	int l,r=0;
	r=temp.length-1;
	for(l=0;l<r;l++,r--){
		char t=temp[l];
		temp[l]=temp[r];
		temp[r]=t;
	}
	for(char c:temp)
		System.out.print(c);
	System.out.println();
}
}
