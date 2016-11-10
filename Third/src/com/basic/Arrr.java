package com.basic;

/*class Super {

	int a, b;

	void add() {

		System.out.println((a + b));

	}

}

public class Arrr extends Super {

	void show() {

		System.out.println("this is sub class show() method");

	}

	public static void main(String[] args) {

		Arrr obj = new Arrr();
		
		obj.add();

		obj.a = 1;
		obj.b = 2;

		obj.add();
		obj.show();

	}
}

*/


public class Arrr {
 
void add(){
    System.out.println("No-arg method");
}
 
void add(int i){
    System.out.println("int-arg method");
}    
 
void add(String str){
    System.out.println("String-arg method");
}
 
void add(float d){
    System.out.println("float-arg method");
}
 
void add(int a, int b){
    System.out.println("2 int-arg method");
}
void add(int a, float b, boolean x){
	System.out.println("Different data types as parameters");
	System.out.print(a+",");
	System.out.print(b+",");
	System.out.print(x);
}
 
public static void main(String[] args){
 
    Arrr obj= new Arrr();
 
    obj.add();
    obj.add(10);
    obj.add(1.2f);
    obj.add("java");
    obj.add(1, 2); 
    obj.add(1,1.2f,true);
 
}
}





