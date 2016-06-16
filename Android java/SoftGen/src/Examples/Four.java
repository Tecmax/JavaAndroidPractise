package Examples;

public class Four {
	public static void main(StringExample[] args) {
		try{
			int c[] = new int[-4];			
		}catch(NegativeArraySizeException e){
			System.out.println("it is an exception");
			e.printStackTrace();
		}
	}
}
