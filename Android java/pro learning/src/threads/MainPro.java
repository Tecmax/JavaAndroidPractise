package threads;

public class MainPro extends Thread {

		public void run(){
			System.out.println("thread running");
		}
	public static void main(String[] args) {
		
		MainPro mp = new MainPro();
		
			mp.start();
			
		}

}
