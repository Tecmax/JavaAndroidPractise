package com.mahesh.Threads;

public class RunExam {
	public void run() {
		for (int i = 1; i <= 3; i++) {
			System.out.println(i);
		}
	}

	public static void main(String args[]) {
		Thread th1 = new Thread(new RunMethodExample(), "th1");
		Thread th2 = new Thread(new RunMethodExample(), "th2");
		th1.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (int i = 0; i <3; i++) {
			System.out.println(i);
		}
//		th2.start();
	}
}
