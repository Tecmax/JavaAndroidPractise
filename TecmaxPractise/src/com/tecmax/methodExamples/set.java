package com.tecmax.methodExamples;

import java.util.HashSet;
import java.util.Iterator;

public class set {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
HashSet<String> set= new HashSet<String>();
set.add("hello");
set.add("hi");
set.add("hello1");
set.add("are");
boolean isremoved= set.remove( "hi");
System.out.println("value after removed is"+isremoved);
System.out.println(set.size());
Iterator<String> itr= set.iterator();
while (itr.hasNext()){
System.out.println(itr.next());

}
	}

}
