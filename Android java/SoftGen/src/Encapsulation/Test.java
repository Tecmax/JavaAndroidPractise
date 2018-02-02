package Encapsulation;
import java.util.Scanner;

public class Test {
public static void main(String args[]){
	Bikes obj = new Bikes();	
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the bike name");
	String name = sc.next();
	System.out.println("Enter the bike price");
	int price = sc.nextInt();
	System.out.println("Enter the bike speed");
	double speed = sc.nextDouble();
	System.out.println("Enter the bike brand");
	String brand = sc.next();
	System.out.println("Enter the bike color");
	String color = sc.next();
	System.out.println("Enter the bike milage");
	int milage = sc.nextInt();
	
	obj.setName(name);
	obj.setPrice(price);
	obj.setSpeed(speed);
	obj.setBrand(brand);
	obj.setColor(color);
	obj.setMilage(milage);
	
	System.out.println("Bike Name is "+obj.getName());
	System.out.println("Bike price is "+obj.getPrice());
	System.out.println("Bike speed is "+obj.getSpeed());
	System.out.println("Bike brand is "+obj.getBrand());
	System.out.println("Bike color is "+obj.getColor());
	System.out.println("Bike milage is "+obj.getMilage());
	
	sc.close();
	}
}
