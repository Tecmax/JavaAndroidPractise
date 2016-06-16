import java.util.ArrayList;
public class Compare {
     public static void main(String [] args)
     {
          ArrayList<String> al1= new ArrayList<String>();
          al1.add("hi");
          al1.add("hello");
          al1.add("how r u");
          al1.add("ok");
          al1.add("bye");

          ArrayList<String> al2= new ArrayList<String>();
          al2.add("awesome");
          al2.add("good");
          al2.add("ok");
          al2.add("bye");
          ArrayList<String> al3= new ArrayList<String>();
          for (String temp : al1)
              al3.add(al2.contains(temp) ? "Yes" : "No");
          System.out.println(al3);
          ArrayList<Integer> al4= new ArrayList<Integer>();
          for (String temp2 : al1)
               al4.add(al2.contains(temp2) ? 1 : 0);
          System.out.println(al4);
          
  

          
     }
    
}
