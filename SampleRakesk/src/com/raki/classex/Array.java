package com.raki.classex;

import java.util.ArrayList;
import java.util.Iterator;

public class Array {
	public static void main(String args[]){
	
	ArrayList<String> al =new ArrayList<String>();
	
	al.add("rakesh");
	al.add("raki");
	al.add("rak");
	
	Iterator itr=al.listIterator();
	while(itr.hasNext()){
		System.out.println(itr.next());
	}
	
	

}
}
