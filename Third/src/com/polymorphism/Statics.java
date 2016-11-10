package com.polymorphism;
import java.lang.Math;

class Statics {
	static String college="ITS";		//THIS STATIC CANNOT BE IN THE MAIN METHOD
	 
	  public static void main(String[] args) {
		  int result;
		  final int room=28;		//HERE WE CANNOT PLACE STATIC. ONLY F!NAL OR VOID IS PERMITTED
		  
		  result=Math.min(20,10);
		  
		  System.out.println(result);
		  System.out.println(Math.max(100,200));
		  
	    display(room);  //calling without object
	    Statics t = new Statics();
	    t.show();  //calling using object
	    System.out.println(room);
	  }
	 
	  static void display(int room) {
	    System.out.println("Programming is amazing.");
	    System.out.println("college and room "+":"+college+" "+room);
	  }
	 
	  void show(){
	    System.out.println("Java is awesome.");
	  }
	}

/*
 * package com.instanceofjava;
class StaticDemo
{
static int a=m1();
 
static int m1(){
 
System.out.println("variable a is created");
return 10;
 
} 
 
static int b=m2();
 
static int m2(){
 
System.out.println("variable b is created");
return 20;

} 
 
public static void main(String [] args){
  
 System.out.println("in main method");
 System.out.println("a="+a);
 System.out.println("b="+b);


 
}
}
output: 

variable a is created
variable b is created
in main method
10
20






package com.instanceofjava;
 
public class StaticDemo {
 
 static int x=10;
 
public static void main(String[] args) {
 
 StaticDemo obj=new StaticDemo();
 
System.out.println(x);
 
obj.x=30;
 
System.out.println(x);
 
StaticDemo obj2=new StaticDemo();
 System.out.println(obj2.x); 
 
System.out.println(StaticDemo.x); // Recommended way to access static variables

}
}

Output:

10
30
30
30

*/


