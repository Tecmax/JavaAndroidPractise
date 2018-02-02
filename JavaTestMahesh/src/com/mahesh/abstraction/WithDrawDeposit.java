package com.mahesh.abstraction;

import com.mahesh.methods.Bank;

public class WithDrawDeposit extends Bank {
	public static void main(String[] args) {
		Bank obj = new WithDrawDeposit();
//		obj.depositCash(10000);
		obj.welcome();
	}
	private void depositCash(int i) {
		System.out.println("Deposited amount " + i);
	}
	@Override
	public void depositcash(double d) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void creditcash(double d) {
		// TODO Auto-generated method stub
		
	}
}
