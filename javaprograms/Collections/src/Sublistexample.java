import java.util.ArrayList;
import java.util.List;
public class Sublistexample {
   public static void main(String a[]){
     ArrayList<String> al = new ArrayList<>();
     al.add("alpha");
     al.add("beta");
     al.add("cupcake");
     al.add("donut");
     al.add("eclair");
     al.add("froyo");

     System.out.println("Original ArrayList Content: "+al);
     ArrayList<String> al2 = new ArrayList<>(al.subList(1, 3));
     System.out.println("SubList stored in ArrayList: "+al2);
     List<String> list = al.subList(1, 5);
     System.out.println("SubList stored in List: "+list);
  }
    
}
