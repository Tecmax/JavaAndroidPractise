package DesignPatterns.AbstractFactory;

public class Factory extends AbstractFactory{

	@Override
	public Mother getDaughter(String DaughterCall) {
		// TODO Auto-generated method stub
		if(DaughterCall == null){
	         return null;
	      }		
	      if(DaughterCall.equalsIgnoreCase("Daughter1")){
	         return new Daughter1();
	         
	      } else if(DaughterCall.equalsIgnoreCase("Daughter2")){
	         return new Daughter2();
	         
	      } else if(DaughterCall.equalsIgnoreCase("Daughter3")){
	         return new Daughter3();
	      }
		return null;
	}

	@Override
	Father getSon(String Father) {
		// TODO Auto-generated method stub
		return null;
	}

}
