public class Nullpointer {
    public static void main(String[] args){
        try{
        
        String ABC=null;
        System.out.println(ABC.length());
        }
        catch(NullPointerException e){
            System.out.println("nullpointer exception");
        }
        
}
}
