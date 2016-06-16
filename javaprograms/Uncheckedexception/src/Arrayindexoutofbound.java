public class Arrayindexoutofbound {
    public static void main(String[] args){
        int result[]={890,760,980};
        try{
        
        System.out.println("the result value of"+result[4]);
        }
        catch(ArrayIndexOutOfBoundsException e){
        System.out.println("There is ArrayIndexOutOfBound Exception");
   }
}
}