package Exceptions;

public class CNF {
	private static final String CLASS_TO_LOAD = "Examples.C4";
	
	public static void main(String[] args) {
		try{
			Class loadedclass = Class.forName(CLASS_TO_LOAD);
			System.out.println("class " + loadedclass + " found successfully");
		}catch(ClassNotFoundException e){
			System.out.println("A classnotfound exception was caught:" +e.getMessage());
			e.printStackTrace();
		}
	}
}
