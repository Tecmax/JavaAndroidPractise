package com.raki.classex;

public class Student {
	
		void display(int rollno, String name) {
		
	
		System.out.println(rollno+" " + name);

	}

	void display(int rollno, int name) {
		System.out.println(+rollno + name);
	}

	public static void main(String args[]) {

		Student s1 = new Student();
		Student s2 = new Student();
		s1.display(10,"rakesh");
		s2.display(10,20);

	}

}
