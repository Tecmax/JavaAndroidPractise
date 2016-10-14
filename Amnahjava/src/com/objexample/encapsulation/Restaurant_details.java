package com.objexample.encapsulation;

public class Restaurant_details {
	public static void main(String[] args) {
		Restaurant Food_love= new Restaurant();
		Food_love.setName("Foody");
		Food_love.setCost(654);
		Food_love.setOrder("chinese");
		Food_love.setPhone_number(123456789);
		System.out.println(Food_love.getName());
		System.out.println(Food_love.getCost());
		System.out.println(Food_love.getOrder());
		System.out.println(Food_love.getPhone_number());
	}

}
