package com.Amnahjava.overriding;

abstract class AMNAH {
	abstract void add();
	

	void sub1() {
		System.out.println("sub");
	}
	void sub1(int i){
		i=54;
		System.out.println(i);
	
	}

}
abstract class Khatun extends AMNAH //we can't have instance of the body
{
	void mul()
	{
		System.out.println("mul");
	}
	void add()
	{
		System.out.println("abstract one");
	}
}


class Name extends Khatun{
	public static void main(String[] args) {
		Name obj = new Name();
		obj.add();
		obj.sub1();
		obj.mul();
	}

	@Override
	void add() {
		// TODO Auto-generated method stub
		System.out.println("child class");
	}
}
