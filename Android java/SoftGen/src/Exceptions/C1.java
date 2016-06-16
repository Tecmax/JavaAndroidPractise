package Exceptions;

public class C1 {
	public static void main(String[] args) {
		int a = 5;
		int b = 0;
		int c;
		try {
			c = a / b;
		} catch (Exception e) {
			e.printStackTrace();

			int arr[] = { 1, 5, 2, 3 };
			try {
				arr[5] = 8;
			} catch (Exception e1) {
				e1.printStackTrace();

				try {
					String ab = null;
					ab.length();
				} catch (Exception e2) {
					e2.printStackTrace();
					
					int abc[];
					abc = new int[-3];
					try {
						System.out.println(abc.length);
					} catch (Exception e3) {
						e3.printStackTrace();
					}
				}

			}
		}
	}
}
