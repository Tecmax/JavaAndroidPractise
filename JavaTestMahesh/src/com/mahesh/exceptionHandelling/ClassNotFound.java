package com.mahesh.exceptionHandelling;

public class ClassNotFound {
	private static final String CLASS_TO_LOAD = 
			"com.mahesha.exceptionHandelling.ExceptionChecked";

	public static void main(String[] args) {
		Class loadedClass;
		try {
			loadedClass = Class.forName(CLASS_TO_LOAD);
			System.out.println("Class " + loadedClass + " found successfully!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
