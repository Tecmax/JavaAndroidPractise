package com.Strings;

public class ComparePerformance {
public static void main(String[] args) {
	long startTime=System.currentTimeMillis();
	for(int i=0;i<50000;++i){
		String s1="hello";
		//System.out.println(s1);
		String s2="hello";
	}
	long endTime=System.currentTimeMillis();
	System.out.println("Time taken for creation of string literals: "+(endTime-startTime)+" millisecs");
	
	
	long startTime1=System.currentTimeMillis();
	for(int i=0;i<50000;++i){
		String s3=new String("hello");
//		String s1="hello";
		String s4=new String("hello");
//		String s2="hello";
	}
	long endTime1=System.currentTimeMillis();
	System.out.println("Time taken for creation of string objects: "+(endTime1-startTime1)+" millisecs");

	//System.out.println(s1);
}
}
