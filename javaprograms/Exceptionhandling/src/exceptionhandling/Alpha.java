package exceptionhandling;
public class Alpha {
    public static void main(String[] args) {
            try{
               int a=10,b=0;
                int result=a/b;
                System.out.println("the result is"+result);
                }catch(ArithmeticException e){
                    System.out.println("there is an Arithmetic exception");
                }
   }
    }

