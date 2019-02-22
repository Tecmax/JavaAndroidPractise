package com.raki.classex;

import java.util.ArrayList;
import java.util.Iterator;

import com.raki.classex.ArrayStudent;

 class ArrayStudent {
	
	
		public class Student {

	}


		int rollno;
		String name;
		int age;
		ArrayStudent(int rollno,String name,int age){
			this.rollno=rollno;
			this.name=name;
			this.age=age;
		}
	
	
	public static void main(String args[]){
		ArrayStudent s1=new ArrayStudent(1,"aa",2);
		ArrayStudent s2=new ArrayStudent(2,"b",3);
		ArrayStudent s3=new ArrayStudent(3,"d",5);
		
		
	
	ArrayList<ArrayStudent> al=new ArrayList<ArrayStudent>();
	al.add(s1);
	al.add(s2);
	al.add(s3);	
	Iterator<ArrayStudent> itr=al.iterator();
	
	for(ArrayStudent s:al){
		System.out.println(s);
	}

}
}
