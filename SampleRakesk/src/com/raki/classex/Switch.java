package com.raki.classex;

public class Switch {
	
	public static void main(String args[]){
		char grade='A';
		switch(grade){
		
		case 'A':
		System.out.println("1st class");
		break;
		case 'B':
		System.out.println("2st class");
		break;
		case 'C':
		System.out.println("3rd class");
		break;
		
		default:
			System.out.println("Fail");
		
		
		}
		System.out.println("your Grade is " +grade);
		
	}

}
