package Examples;

abstract class A {
	abstract void m1();
	int m2(){
		return 1;
	}
	int m3(){
		return 0;
	}
}
class B extends A{

	@Override
	void m1() {
		System.out.println("abstract m1 method");		
	}
	public static void main(StringExample[] args) {
		B b=new B();
		C c=new C();
		b.m2();
		b.m1();
		b.m3();
		c.m2();
		c.m3();
		c.m1();
	}
}
class C extends B{
	void display(){
		System.out.println("this is C display method");
	}
	@Override
	void m1() {
		// TODO Auto-generated method stub
		System.out.println("hi");
	}
}