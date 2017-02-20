package com.mahesh.overriding;

public class ChildA extends ParentA {
	public static void main(String[] args) {
		ChildA obj= new ChildA();
		obj.smilingFace();
		obj.patience();
		obj.enginer();
//		String[] acc= {"sds","dsd","sdsds"};
//		obj.main(acc);
	}
	void smilingFace(){
		System.out.println("Aksha Smile");
	}
	void enginer(){
		System.out.println("enginer");
	}
}

class ParentA {
	void patience() {
		System.out.println("Dads Patience");
	}
	void smilingFace(){
		System.out.println("MomS Smile");
	}
	public static void main(String[] args) {
		ParentA obj = new ParentA();
		obj.smilingFace();
		obj.patience();
	}

}