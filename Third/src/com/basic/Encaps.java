package com.basic;

public class Encaps {
	
	public int i;
	  private String name;
	  private int rno;
	  public String address="Kathriguppe";
	 
	public String getName() {
	       return name;
	 }
	 
	public void setName(String name) {
	        this.name = name;
	} 

	public int getRno() {
	       return rno;
	}
	 
	public void setRno(int rno) {
	     this.rno = rno;
	}
	 
	public String getAddress() {
	        return address;
	};
	 
	 public void setAddress(String address) {
	    this.address = address;
	};
	 
	public void showInfo(){
	 
	      System.out.println("Name: "+getName());
	      System.out.println("R.No: "+getRno());
	}
	
	public static void main(String[] args) {
		
		Encaps e=new Encaps();
		e.getName();
		e.setName("Sagar");
		e.setRno(5);
		e.setAddress("Banashankari");
		e.showInfo();
		//int i=8;
		int rno=7;
		e.showInfo();
		System.out.println(rno);
		//System.out.println(address); it is error
		//main(new String[0]);
		
	}
}
