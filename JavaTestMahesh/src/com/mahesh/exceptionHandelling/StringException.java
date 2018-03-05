package com.mahesh.exceptionHandelling;

public class StringException {
	public static void main(String[] args) {
		try {
			Object obj = null;
			obj.toString();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}
}
