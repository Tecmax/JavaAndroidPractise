package DesignPatterns.SIngleton;

public class SingleTonPattern {
	public static void main(String[] args) {

	      //illegal construct
	      //Compile Time Error: The constructor SingleObject() is not visible
	      //SingleObject object = new SingleObject();

	      //Get the only object available
	      One object = One.getInstance();

	      //show the message
	      object.showMessage();
	   }
}
