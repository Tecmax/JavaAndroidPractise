package com.mahesh.exceptionHandelling;

public class Illegal {
	static Percentage percentage;
	public static void main(String[] args) {
		percentage = new Percentage(988);
		System.out.println(percentage.getValue());
	}
}
