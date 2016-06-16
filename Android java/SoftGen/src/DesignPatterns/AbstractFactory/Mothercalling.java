package DesignPatterns.AbstractFactory;

public class Mothercalling extends AbstractFactory{

	@Override
	Father getSon(String Father) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	Mother getDaughter(String MotherCall) {
		// TODO Auto-generated method stub
		if(MotherCall == null){
	         return null;
	      }		
	      if(MotherCall.equalsIgnoreCase("Son1")){
	         return new Daughter1();
	         
	      } else if(MotherCall.equalsIgnoreCase("Son2")){
	         return new Daughter2();
	         
	      } else if(MotherCall.equalsIgnoreCase("Son3")){
	         return new Daughter3();
	      }
		return null;
	}
}