package com.tecmax.methodExamples;

import java.util.ArrayList;

public class arrays {
	public class array {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
	             ArrayList<String> a=new ArrayList<String>();
	             a.add("nan");
	             a.add("madhuri");
	             a.add("swetha");
	             a.add("dileep");
	             System.out.println(a);
	             a.remove("swetha");
	             System.out.println(a);
	             int pos=a.indexOf("Theja");
	             String str=a.get(12);
	             int numberofitems=a.size();
	             System.out.println("current array List posiion Stringvalue size is:"+"\n"+a+"\n"+numberofitems);
	             
		}

	}

	public static String[] asList;

}
