package DesignPatterns;

public class FatherCalling {
	//use getSon method to get object of type father
	   public Father getSon(String SonCall){
	      if(SonCall == null){
	         return null;
	      }		
	      if(SonCall.equalsIgnoreCase("Son1")){
	         return new Son1();
	         
	      } else if(SonCall.equalsIgnoreCase("Son2")){
	         return new Son2();
	         
	      } else if(SonCall.equalsIgnoreCase("Son3")){
	         return new Son3();
	      }
	      
	      return null;
	   }
}