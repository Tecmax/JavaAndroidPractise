package com.Amnahjava.overriding;

//interface khatun {
//	public void school();
//
//}
//
//interface roshni { // a extends b implements c,d 2. e extends a, imple,c,d.....
//					// a,b is abs c,d is interface e is main
//	public void college();
//}
//
//abstract class Newname {
//	void Newschool() {
//		System.out.println("gcv");
//	}
//}

abstract class AK extends Newname { // implements khatun

	void home() {
		System.out.println("home");
	}
}

public class Amnah extends AK implements roshni, khatun {
	// public void school() {
	// System.out.println("school");
	// }
	//
	// public void college() {
	// System.out.println("college");
	// }
	public static void main(String[] args) {
		System.out.println("ddd");
		// Amnah obj = new Amnah();
		// obj.school();
		// obj.college();
		// obj.home();
		// obj.Newschool();
	}
}