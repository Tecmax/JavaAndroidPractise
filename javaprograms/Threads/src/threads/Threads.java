package threads;
public class Threads extends Thread{
    
        public void run(){
            System.out.println("My thread is running");
        }
        public static void main(String[] args) {
            Threads t=new Threads();
            t.start();
            
        
    } 
}
