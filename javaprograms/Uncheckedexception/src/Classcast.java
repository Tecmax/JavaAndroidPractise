public class Classcast {
    public static void main(String[] args){
       
        try{
        Object obj=new Integer(100);
        System.out.println((String)obj);
        }
        catch(ClassCastException e)
        {
            System.out.println("class cannot convert as string");
        }
        
    }
    
}
