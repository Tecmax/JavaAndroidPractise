package com.Strings;

public class StringOptimization {
public static void main(String[] args) {
	String variables[]=new String[500000];
	for(int i=0;i<500000;i++){
		variables[i]="s"+i;
	}
	long st=System.currentTimeMillis();
	for(int i=0;i<500000;++i){
		variables[i]="hello";
	}
	long et=System.currentTimeMillis();
	System.out.println("Creation time for string literals: "+(et-st)+" ms");
	long st1=System.currentTimeMillis();
	for(int i=0;i<500000;++i){
		variables[i]=new String("hello");
		variables[i]=new String("hello");
	}
	long et1=System.currentTimeMillis();
	System.out.println("Creation time for new keyword: "+(et1-st1)+" ms");
	long st2=System.currentTimeMillis();
	for(int i=0;i<500000;++i){
		//variables[i]=new String("hello");
		variables[i]=variables[i].intern();
	}
	long et2=System.currentTimeMillis();
	System.out.println("Creation time for intern: "+(et2-st2)+" ms");
	
}
}
