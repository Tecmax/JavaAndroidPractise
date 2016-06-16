interface AB{
    void play();
    void dance();
}
interface BC extends AB{
    void add();
    void sub();
    
}
interface CA extends BC{
    void result();
    void mul();
}
public class ABC implements CA{
   
    @Override
    public void result() {
        int a=100,b=10;
        int c=a/b;
        System.out.println("This will display the result"+c);
    }

    @Override
    public void mul() {
        int p=40,q=5;
        int r=p*q;
         System.out.println("This will display the multiplication result");
    }

    @Override
    public void add() {
        int a=20,b=10;
        int c=a+b;
        System.out.println("This will display the addition result");
    }

    @Override
    public void sub() {
         int a=20,b=10;
        int c=a-b;
        System.out.println("This will display the substraction result");
    }

    @Override
    public void play() {
        System.out.println("they can play");
    }

    @Override
    public void dance() {
        System.out.println("they can dance");
    }
    public static void main(String[] args){
       
  ABC obj=new ABC();
   obj.result();
   obj.add();
   obj.dance();
   obj.mul();
   obj.sub();
   obj.play();

    } 
}
