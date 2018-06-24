package com.tecmax.methodExamples;

import java.awt.List;
import java.util.ArrayList;

public class arraylisttoarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList <Integer> list=new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		Integer []intArray=new Integer[list.size()];
		list.toArray(intArray);
		for(Integer integer:intArray) {
			System.out.println(integer);
		}
		
	}

}
