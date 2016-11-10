package com.basic;

class Parent {}

class Child1 extends Parent{}

class Child2 extends Parent{}

class Child3 extends Child1{}

class InstanceOf{
	public static void main(String[] args) {
		Parent p=new Parent();
		Child1 c1=new Child1();
		Child2 c2=new Child2();
		Child3 c3=new Child3();
		
		System.out.println(c1 instanceof Parent);
		System.out.println(c2 instanceof Parent);
		System.out.println(p instanceof Parent);
		System.out.println(p instanceof Child1);
		System.out.println(c3 instanceof Child1);
//		 gives error!!!		System.out.println(c3 instanceof Child2);
		
		p=c1;
		
		System.out.println();
		System.out.println(p instanceof Child1);
		System.out.println(p instanceof Child2);
		
	}
}
