package Abstraction;

abstract class LivingThings{
	abstract int legs();
	abstract String name();
	public void run(){
		System.out.println("this class is about animals");		
	}
	public String skin(){
		System.out.println("the skin of this animal is ");
		return null;
	}
}
public class AbstractAnimal extends LivingThings{

	@Override
	int legs() {

System.out.println("Legs");
		return 0;
	}

	
	String name() {
		System.out.println("name");
		return null;
	}
	public static void main(String[] args) {
		AbstractAnimal obj=new AbstractAnimal();
		obj.run();
		obj.legs();
		obj.name();
		String skintype = obj.skin();
	}
	
}

