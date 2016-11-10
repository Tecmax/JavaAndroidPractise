package com.basic;

import java.util.HashSet;

class Emp {
	private int age;

	public Emp(int age) {
		//super();
		this.age = age;
	}

	public int hashCode() {
		return age;
	}
	
	public boolean equals( Object obj )
	{
		boolean flag = false;
		Emp emp = ( Emp )obj;
		if( emp.age == age )
			flag = true;
		return flag;
	}
}

public class TestEmp {
	public static void main(String[] args) {
		Emp emp1 = new Emp(30);
		System.out.println("emp1.hashCode()--->>>" + emp1.hashCode());
		int originalHashCode = System.identityHashCode(emp1);
		System.out.println("Original hashCode of Emp---->>>"+originalHashCode);
		
		Emp e1=new Emp(23);
		Emp e2=new Emp(29);
		Emp e3=new Emp(24);
		Emp e4=new Emp(25);
		Emp e5=new Emp(26);
		Emp e6=new Emp(27);
		Emp e7=new Emp(28);
		
		HashSet<Emp> hs=new HashSet<Emp>();
		
		hs.add(e1);
		hs.add(e2);
		hs.add(e3);
		hs.add(e4);
		hs.add(e5);
		hs.add(e6);
		hs.add(e7);
		
		System.out.println("emp1.equals(emp2)--->>>"+e1.equals(e2));
		System.out.println("emp1.equals(emp2)--->>>"+e2.equals(e4));
		System.out.println("HashSet Size--->>>"+hs.size());
		System.out.println("hs.contains( new Emp(25))--->>>"+hs.contains(new Emp(25)));
		System.out.println("hs.remove( new Emp(24)--->>>"+hs.remove( new Emp(24)));
		System.out.println("Now HashSet Size--->>>"+hs.size());
		
	}
}
