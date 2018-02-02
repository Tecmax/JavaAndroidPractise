package MethodOverloading;

public class Employ {
	
	public void emp(String a){
		System.out.println("The name of employ is " +a);
	}
	
	public void emp(int b,String a){
		System.out.println("The name of employ is " +a);
		System.out.println("The salary of employ is " +b);
	}
	
	public void emp(int a,String b,long c){
		System.out.println("The name of salary is " +a);
		System.out.println("The name of name is " +b);
		System.out.println("The name of mob.no is " +c);
	}
	public static void main(String[] args) {
		Employ obj = new Employ();
		obj.emp("ravi");
		obj.emp(5000, "jeev");
		obj.emp(6000, "praveen", 987456789);
	}
	
}
