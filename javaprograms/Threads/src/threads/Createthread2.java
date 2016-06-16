package threads;
public class Createthread2 implements Runnable{

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public static void main(String[] args){
        Threads t=new Threads();
        Thread t1=new Thread(t);
         t1.start();
    
}
}
