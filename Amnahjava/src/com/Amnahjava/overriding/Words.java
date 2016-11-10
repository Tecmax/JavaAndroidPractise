package com.Amnahjava.overriding;

public class Words {
	public static void main(String[] args) {
		Words obj = new Words();
		obj.Add();
		obj.Sub();
		obj.mult();
		for (String string : args) {
			System.out.println(string);

		}
		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i]);

		}
	}

	private void Add() {
		System.out.println("add");
	}

	private void Sub() {
		System.out.println("sub");
	}

	private void mult() {
		System.out.println("mult");
	}
}
