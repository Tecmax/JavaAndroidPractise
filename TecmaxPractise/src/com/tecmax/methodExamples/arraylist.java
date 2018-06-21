package com.tecmax.methodExamples;

import java.util.ArrayList;

public class arraylist {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> a=new ArrayList<String>();
		a.add("swetha");
		a.add("theja");
		a.add("joshna");
		a.add("priyanka");
		System.out.println(a);
		a.add(0,"nandini");
		System.out.println(a);
		int pos=a.indexOf("madhuri");
		String str=a.get(12);
		int numberofitems=a.size();
		System.out.println("current arraylist position stringvalue size is:"+"\n"+ numberofitems);
		a.remove("dileep");
		System.out.println(a);
		
	}


}
