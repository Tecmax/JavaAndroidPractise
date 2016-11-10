package com.polymorphism;

public class Construct {
	int a, b;

	Construct(int x, int y) {
		a = x;
		b = y;
		System.out.println(a+","+b);
	}

	public static void main(String[] args) {
		new Construct(10, 20);
	}
}

/*
package instanceofjava;
class Sample{							//DEFAULT CONSTRUCTOR
int a,b
Sample(){
a=37;
b=46;
}
 
public static void main(String[] args){
 
 Sample obj=new Sample();
  System.out.println(obj.a);
  System.out.println(obj.b);
 
}
}



package instanceofjava;
class Sample{							//PARAMETERIZED CONSTRUCTOR
int a,b
Sample(int x, int y){
a=x;
b=y;
}
 
public static void main(String[] args){
 
 Sample obj=new Sample(37,46);
  System.out.println(obj.a);
  System.out.println(obj.b);
 
}
}


package instanceofjava;
class Sample{
int a,b 
Sample(){								//CONSTRUCTOR OVERLOADING
this(1,2);
 System.out.println("Default constructor");
 
}
Sample(int x , int y){
 
this(1,2,3); 
a=x;
b=y;
 System.out.println("Two argument constructor");
 
}
 
Sample(int a , int b,int c){
 System.out.println("Three argument constructor")
}
public static void main(String[] args){
 
 Sample obj=new Sample();
  System.out.println(obj.a);
  System.out.println(obj.b);
 
}
}

*/



