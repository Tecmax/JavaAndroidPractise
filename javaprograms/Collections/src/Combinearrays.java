import java.util.ArrayList;
public class Combinearrays {
    public static void main(String [] args)
    {
        ArrayList<String> arraylist1=new ArrayList<String>();
        arraylist1.add("SWETHA");
        arraylist1.add("SREERAM");
        arraylist1.add("RAVI");
        ArrayList<String> arraylist2=new ArrayList<String>();
        arraylist2.add("sgd");
        arraylist2.add("edhsrd");
        arraylist2.add("ewte");
        ArrayList<String> arraylist3=new ArrayList<String>();
        arraylist2.add("1");
        arraylist2.add("2");
        arraylist2.add("4");
        ArrayList<String> al= new ArrayList<String>();
        al.addAll(arraylist1);
        al.addAll(arraylist2);
        al.addAll(arraylist3);
        for(String temp: al){
            System.out.println(temp);
        }
    }
    
}
