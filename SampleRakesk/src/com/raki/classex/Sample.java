package com.raki.classex;

public class Sample {
	
	public static void main(String[] args) {
		int dsa = sum(10,10);
		sum(10f,10f);
		sum(10f,10);
		sum(10,10f);
		sum(10,(int) 10.8);
	}

	private static float sum(float f, float g) {
		System.out.println("am in float method"+10);
		return f+g;
		
	}

	private static int sum(int i, int j) {
		System.out.println("am in int method");
		return i+j;
		
	}
	
	private static float sum(float i, int j){
		System.out.println("am in  float int method" );
		
		return i+j;
		
	}

}
