package MethodOverloading;

public class MO1 {
	public void disp(double c, int a) {

		System.out.println(c + " " + a);
	
		
	}

	public void disp(int b, double d) {
		System.out.println(b + " " + d);
	}

	public static void main(String[] args) {
		MO1 obj = new MO1();
		obj.disp(10.5, 5);
		obj.disp(10, 21.5);
	}
}