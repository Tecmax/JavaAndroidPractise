package com.basic;

class Adda{
	void sha(){
		System.out.println("Extra class");
		
	}
}

class Test {

	void show() {

		System.out.println("test class show() method");
	}
	void method(String s) {

		System.out.println("String-arg");

	}

	//void method(test obj){
		//System.out.println("hello");
	//}
	void method(Adda o){
		o.sha();
	}

}

 class Polym {

	void method(String s) {

		System.out.println("String-arg");

	}

	void method(Test obj) {

		System.out.println("method(Test obj)-arg");
		obj.show();
		obj.method("hai");
		//obj.method(new Test());
	}
	
	
	public static void main(String[] args) {

		Polym obj = new Polym();
		obj.method("polymorphism definition in oops");
		obj.method(new Test());								//using reference types.. this is chindi!!
		Test ob=new Test();
		//ob.method(new Test());
		ob.show();
		ob.method("namskara");
		C o=new C();
		o.print();
		o.display();
		ob.method(new Adda());
		Adda x=new Adda();
		x.sha();
	}
}
