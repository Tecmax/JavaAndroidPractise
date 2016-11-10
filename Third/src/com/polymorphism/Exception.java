package com.polymorphism;

/*public class Exception {
	public class Super {
	    int a,b;
	    void add(){
	        System.out.println("super class add() method");
	    }
	}


	public class Sub extends Super {
	 
	 void add() throws IOException{ // ERROR:     - Exception IOException is not compatible with
	                                                      //throws clause in  Super.add()
	        System.out.println("this is sub class add() method");
	}
	 
	    public static void main(String [] args){

	        Sub obj= new Sub();
	 
	    } 
	}
*/



 class Super1 {
	    int a,b;
	    void add() {
	        System.out.println("super class add() method");
	    }
	}



	public class Exception extends Super1 {
	 
	 void add() {// works fine
	        System.out.println("this is sub class add() method");
	}
	 
	    public static void main(String [] args){

	        Exception obj= new Exception();
	        obj.add();
	 
	    } 
}
