package com.mahesh.Threads;

public class MultithreadingDemo implements Runnable {

	public void start() {
		System.out.println("My thread is in fbdh state.");
	}

	public static void main(String args[]) {

		try {
			System.out.println("Hello");
			MultithreadingDemo obj = new MultithreadingDemo();
			Thread ob = new Thread(obj);
			ob.start();
			System.out.println("Hello W");
//			ob.start();
			Thread.sleep(4000);
			System.out.println("Hello X");
			ob.run();
			
		} catch (IllegalThreadStateException e) {
			System.out.println("Connot Start Thread Twice");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		
		System.out.println("Running From Thread Instance");

	}
}
