package com.mahesh.Threads;

public class CreateThread extends Thread {
	@Override
	public void run() {
		super.run();
		System.out.println("hello");
	}

	public static void main(String args[]) {
		CreateThread obj = new CreateThread();
		obj.start();
		obj.run();
	}
}
