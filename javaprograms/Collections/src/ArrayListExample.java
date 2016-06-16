
import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String args[]) {
     ArrayList<String> obj = new ArrayList<String>();
          obj.add("alpha");
	  obj.add("beta");
	  obj.add("cupcake");
	  obj.add("donut");
	  obj.add("eclair");
      System.out.println(" the array list is:"+obj);

	  obj.add(0, "froyo");
	  obj.add(1, "gingerbread");
          obj.add(2, "honeycomb");
      System.out.println(" the added array list is:"+obj);

	  obj.remove("cupcake");
	  obj.remove("donut");

	  System.out.println(" the  array list is:"+obj);
          obj.remove(4);
          System.out.println(" array list is:"+obj);
   }
    }



