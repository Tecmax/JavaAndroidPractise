package com.objexample.encapsulation;

public class school_details {
public static void main(String[] args) {
	
	School amnah= new School();
	amnah.setAddress("BTM");
	amnah.setAge(10);
	amnah.setName("Amnah");
	amnah.setPhone_number(123456789);
	System.out.println(amnah.getAddress());
	System.out.println(amnah.getAge());
	System.out.println(amnah.getName());
	System.out.println(amnah.getPhone_number());
	
}
}
