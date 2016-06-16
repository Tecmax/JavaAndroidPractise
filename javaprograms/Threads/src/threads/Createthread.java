package threads;
public class Createthread implements Runnable
{

    @Override
    public void run() {
        System.out.println("My thread is running");
    }
    
    public static void main(String[] args){
        Threads t=new Threads();
        Thread t1=new Thread(t);
         t1.start();
        
    }
}
