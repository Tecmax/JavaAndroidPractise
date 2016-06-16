package DesignPatterns.AbstractFactory;

public class AbstractFactoryPattern {
	public static void main(String[] args) {
		FatherCalling FatherCalling = FactoryProducer.getFactory("FATHER");
//		Mothercalling mothercalling = FactoryProducer.getFactory("MOTHER");
	}
}
