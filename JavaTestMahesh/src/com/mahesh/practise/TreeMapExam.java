package com.mahesh.practise;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapExam {
	public static void main(String[] args) {
		TreeMap<Integer, Stde> hm = new TreeMap<Integer, Stde>();
		hm.put(108, new Stde("Vijay", 1));
		hm.put(103, new Stde("Ravi", 7));
		hm.put(106, new Stde("Amit", 5));
		hm.put(101, new Stde("Bhanu", 3));
		for (Map.Entry m : hm.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
		}
	}
}
