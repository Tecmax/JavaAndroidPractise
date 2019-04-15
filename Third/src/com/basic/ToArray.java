package com.basic;

public class ToArray {
	public static void main(String[] args) {
		ToArray a = new ToArray();
		a.add();
		a.sub();
		System.out.println(args.length);
		for (String al : args) {
			System.out.println(al);
		}

		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}

	}

	void add() {
		System.out.println("Hai");
	}

	void sub() {

	}

}

class Hello extends ToArray {
	public static void main(String[] args) {
		String[] a={"hai","hello","hey","dude"};
		ToArray tt = new ToArray();
		tt.add();
		for (String al : args) {
			System.out.println(al);
		}

		//tt.main("hai");  			//args[i] or args.get[i]
		ToArray.main(a);
		main(a);
	}

}