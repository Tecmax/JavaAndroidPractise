package Examples;

public class Two {
	int num1,num2;
	public void setnum(int num1){
		if(num1/2 != 0){
			System.out.println("odd number");
		}else{
			System.out.println("even number");
		}		
	}
	public void setnumm(int num2){
		if(num2/2 == 0){
			System.out.println("even number");
		}else{
			System.out.println("odd number");
		}
	}
}