package DesignPatterns;

public class FatherPattern {
	public static void main(String[] args) {
		FatherCalling fatherCalling = new FatherCalling();

	      //get an object of Son1 and call its draw method.
	      Father Son1 = fatherCalling.getSon("Son1");

	      //call call method of Son1
	      Son1.call();

	      //get an object of Son2 and call its draw method.
	      Father Son2 = fatherCalling.getSon("Son2");

	      //call call method of Son2
	      Son2.call();

	      //get an object of Son3 and call its draw method.
	      Father Son3 = fatherCalling.getSon("Son3");

	      //call call method of Son3
	      Son3.call();
	   }
}
