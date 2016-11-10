package com.Strings;

public class Reverse2 {
public static void main(String[] args) {
	String i="AliveIsAwesome";
	StringBuilder i1=new StringBuilder(i); 		//or StringBuilder i1=new StringBuilder(i);  i1.reverse();
	//i1.append(i);
	i1=i1.reverse();
//	for(int j=0;j<i1.length();j++){
//		System.out.print(i1.charAt(j));
//	}
//	System.out.println();
	System.out.println(i1);
	
	StringBuilder s=new StringBuilder(i).reverse();
	//s.reverse();
	System.out.println(s);
}
}
