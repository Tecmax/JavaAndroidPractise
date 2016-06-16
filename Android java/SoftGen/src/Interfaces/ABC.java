package Interfaces;
interface AB{
	void ADD();
	void Sub();
}
interface BC extends AB{
	void Mod();
	void Test();
}
interface CA extends BC{
	void Play();
	void dance();
}
public class ABC implements CA{	
	public void Play() {
		// TODO Auto-generated method stub
		System.out.println("hello i can play");
	}
	public void dance() {
		// TODO Auto-generated method stub
		System.out.println("hello i can dance");
	}
	public void Mod() {
		// TODO Auto-generated method stub
		System.out.println("hello i can modulus");
	}
	public void Test() {
		// TODO Auto-generated method stub
		System.out.println("hello i can test");
	}
	public void ADD() {
		// TODO Auto-generated method stub
		System.out.println("hello i can add");
	}
	public void Sub() {
		// TODO Auto-generated method stub
		System.out.println("hello i can subtract");
	}
	public static void main(String[] args) {
		ABC obj = new ABC();
		AB obj1 = new ABC();
		obj.Play();
		obj.dance();		
		obj.Mod();
		obj.Test();
		obj.Sub();
		obj1.ADD();
		obj1.Sub();
	}	
}	