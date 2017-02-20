package com.mahesh.methods;

public abstract class Bank {
	public abstract void depositcash(double d);

	public abstract void creditcash(double d);

	public void welcome() {
		System.out.println("Icici Welcome You");
	}
}