package Exceptions;

public class C3 {
	public static void main(String[] args) {
		int a = 10 + 20;
		String c = null;
		try {

			float b = a / 70;
			c.substring(22 / 7);
			c = new String("ABC");
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			System.out.println("hello world...!!!   " + a);
		}

		c.length();

	}
}
