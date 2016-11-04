package com.Amnahjava.overriding;

abstract class Amnah {
	abstract void add();
	

	void sub() {
		System.out.println("sub");
	}
	void sub(int i){
		i=54;
		System.out.println(i);
	
	}

}
abstract class Khatun extends Amnah //we can't have instance of the body
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
		obj.sub();
		obj.mul();
	}

	@Override
	void add() {
		// TODO Auto-generated method stub
		System.out.println("child class");
	}
}
