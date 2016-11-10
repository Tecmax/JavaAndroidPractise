package com.Strings;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
//import java.util.ListIterator;

public class Reverse4 {
public static void main(String[] args) {
	String i="Be in present";
	char[] hello=i.toCharArray();
	List<Character>trial1=new LinkedList<>();
	for(char c:hello)
		trial1.add(c);
	Collections.reverse(trial1);
//	ListIterator li=trial1.listIterator();
//	while(li.hasNext()){
//		System.out.print(li.next());
//	}
	for(char k: trial1){
		System.out.print(k);
	}
}
}
