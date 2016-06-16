package Examples;

public class One {
	public static void main(StringExample[] args) {
		try{
			int a=20,b=0;
			int c = a/b;
			System.out.println("the result of c is: " + c);
		}catch(ArithmeticException e){
			System.out.println("There is an exception called AE.");
		}
	}
}
