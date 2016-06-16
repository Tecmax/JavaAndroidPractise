package DesignPatterns.AbstractFactory;

public abstract class AbstractFactory {
	abstract Father getSon(String Father);
	abstract Mother getDaughter(String Mother);
}
