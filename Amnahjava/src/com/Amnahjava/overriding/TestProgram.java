package com.Amnahjava.overriding;

public class TestProgram extends AK1 implements roshni2, khatun1{

	public void school() {
		System.out.println("school");
	}  

	public void college() {
		System.out.println("college");
	}

	public static void main(String[] args) {
		System.out.println("dsdsds");
		TestProgram obj = new TestProgram();
		obj.school();
		obj.college();
		obj.home();
		obj.Newschool();
	}

	}
abstract class AK1 extends Newname { // implements khatun

	void home() {
		System.out.println("home");
	}
}

interface khatun1 {
	public void school();

}

interface roshni2 {
	public void college();
}

abstract class Newname {
	void Newschool() {
		System.out.println("gcv");
	}
}