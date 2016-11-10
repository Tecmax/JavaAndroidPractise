package com.polymorphism;

import java.awt.Color;
//import java.awt.Color;
import java.util.ArrayList;

/**
 * Java Program to demonstrate what is abstract class and abstract method in
 * Java, how to use them, when to use them with a practical example.
 *
 * @author Javin Paul
 */

class AbstractEx {

	public static void main(String args[]) {
		Fruit mango = new Mango(Color.YELLOW, true); // mango is seasonal
		Fruit banana = new Banana(Color.YELLOW, false); // banana is not
														// seasonal

		//Fruit gt;
		ArrayList<Fruit> platter = new ArrayList<Fruit>();
		platter.add(mango);
		platter.add(banana);
		serve(platter);
	}

	public static void serve(ArrayList<Fruit> platter) {
		System.out.println("Preparing fruits to serve");
		for (Fruit f : platter) {
			f.prepare();
		}
	}
}

/*
 * Abstract class to represent Fruit, defined only essential properties of Fruit
 * here and make things abstract which is different for different fruits.
 */
abstract class Fruit {
	private Color color;
	private boolean seasonal;

	public Fruit(Color color, boolean seasonal) {
		this.color = color;
		this.seasonal = seasonal;
	}

	/*
	 * This is an abstract method, see it doesn't have method body, only
	 * declaration/
	 */

	public abstract void prepare();

	public Color getColor() {
		return color;
	}

	public boolean isSeasonal() {
		return seasonal;
	}
}

/**
 * A concrete class to extend Fruit, since Mango IS-A Fruit extending Fruit is
 * justified. it got all properties of fruit, and it defines how to prepare
 * mango for eating.
 */

class Mango extends Fruit {

	public Mango(Color color, boolean seasonal) {
		super(color, seasonal);
	}

	@Override
	public void prepare() {
		System.out.println("Cut the Mango");
	}
}

/*
 * Another concrete class to extend Fruit.
 */

class Banana extends Fruit {

	public Banana(Color color, boolean seasonal) {
		super(color, seasonal);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void prepare() {
		System.out.println("Peal the Banana");
	}
}
