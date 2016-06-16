package  com.swetha.exceptionhandling;
import java.lang.String;
public class StringIndexBoundException {
    public static void main(String[] args){
        try{
        String ABC="Hello World";
        char ch=ABC.charAt[50];
        }
        catch(StringIndexOutOfBoundsException e){
            System.out.println("stringindexbound exception");
        }
        
}
}