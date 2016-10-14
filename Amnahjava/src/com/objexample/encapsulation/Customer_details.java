package com.objexample.encapsulation;

public class Customer_details {
	public static void main(String[] args) {
		Customer amnah = new Customer();
		amnah.setAddress("BTM");
		amnah.setProduct(3);
		amnah.setName("big bazaar");
		amnah.setTotal(345);
		amnah.setPhone_number(1234567890);
		System.out.println(amnah.getAddress());
		System.out.println(amnah.getProduct());
		System.out.println(amnah.getName());
		System.out.println(amnah.getTotal());
		System.out.println(amnah.getPhone_number());
	}

}
