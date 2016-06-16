public class Numberformat {
    public static void main(String[] args){
        try{
            String s="1234A";
            System.out.println((String) s);
        }
        catch(NumberFormatException e){
            System.out.println("check the type");
            
        }
    }
    
}
