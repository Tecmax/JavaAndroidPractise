package com.raki.classex;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayFor {
	public static void main(String args[]){
		ArrayList<String>  al=new ArrayList<String>();
		al.add("hi");
		al.add("hello");
		al.add("hi");
		
		Iterator itr=al.iterator();
		for(String s:al)
			System.out.println(s);
	}

}
