package chapters.multithreading.multi02threadclass;

public class TestThread {

	   public static void main(String args[]) {
	      ThreadDemo T1 = new ThreadDemo( "Thread-1");
	      T1.start();
	      
	      ThreadDemo T2 = new ThreadDemo( "Thread-2");
	      T2.start();
	   }   
	}