package com.tecmax.methodExamples;

import java.util.LinkedHashMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class map {

	public static void main(String[] args) {
		LinkedHashMap<String,Integer>set= new LinkedHashMap<String,Integer> ();
		set.put("hello",100);
		set.put("hi",200);
		set.put("hello1",300);
		set.put("are",400);
	for (Map.Entry m: set.entrySet())
		System.out.println(m.getValue()+""+m.getKey());
	
	}

	}

