package DesignPatterns.SIngleton;

public class One {
	 //create an object of One
	   private static One instance = new One();

	   //make the constructor private so that this class cannot be
	   //instantiated
	   private One(){}

	   //Get the only object available
	   public static One getInstance(){
	      return instance;
	   }

	   public void showMessage(){
	      System.out.println("Hello World!");
	   }
}
