package chapters.multithreading.multi04synchronization;

import java.util.ArrayList;
import java.util.List;

class PrintDemos {
		  List<String> list = new ArrayList<>();

		public void add(String string) {
			list.add(string);
			System.out.println("add..."+list);
		}
		
		public void addAt(int index ,String string) {
			list.add(index, string);
			System.out.println("addAt..."+list);
		}
		
		public void remove(int index) {
			list.remove(index);
			System.out.println("remove..."+list);
		}
		
		public void clear() {
			list.clear();
			System.out.println("clear..."+list);
		}
}

		class ThreadDemoz extends Thread {
		   private Thread t;
		   private String threadName;
		   PrintDemos  PD;

		   ThreadDemoz( String name,  PrintDemos pd) {
		      threadName = name;
		      PD = pd;
		   }
		   
		   public void run() {
			   synchronized (PD) {
				   if(threadName.equals("add")) {
					   PD.add("boopathy");
				   }else if(threadName.equals("addAt")) {
					   PD.addAt(0,"harish");
				   }else if(threadName.equals("remove")) {
					   PD.remove(0);
				   }else if(threadName.equals("clear")) {
					   PD.clear();;
				   }
		      System.out.println("Thread " +  threadName + " exiting.");
			   }
		   }

		   public void start () {
		      System.out.println("Starting " +  threadName );
		      if (t == null) {
		         t = new Thread (this, threadName);
		         t.start ();
		      }
		   }
		}

		public class MyExample {

		   public static void main(String args[]) {
			   PrintDemos PD = new PrintDemos();

		      ThreadDemoz T1 = new ThreadDemoz( "add", PD );
		      ThreadDemoz T2 = new ThreadDemoz( "addAt", PD );
		      ThreadDemoz T3 = new ThreadDemoz( "remove", PD );
		      ThreadDemoz T4 = new ThreadDemoz( "clear", PD );

		      T4.start();
		      T1.start();
		      T2.start();
		      T3.start();

		      // wait for threads to end
		      try {
//		    	  T1.join();
//		    	  T2.join();
//		    	  T3.join();
//		    	  T4.join();
		        System.out.println("Final Result:");
		        System.out.println(PD.list);
		      } catch ( Exception e) {
		         System.out.println("Interrupted");
		      }
		   }
		}