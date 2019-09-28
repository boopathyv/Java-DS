package chapters.multithreading.multi06Join;

//My task is the tread class

class Task implements Runnable {

	@Override
	public void run() {
		int i = 0;

		while (i < 5) {
			System.out.println("My Thread");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			++i;
		}

	}
}

class SecondTask implements Runnable {

	@Override
	public void run() {
		int i = 0;

		while (i < 5) {
			System.out.println("Second Thread");
			try {
//				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			++i;
		}

	}
}

//TEST
public class Sample {

	public static void main(String[] args) throws InterruptedException {

		// Create one object of Task Thread class
		System.out.println("Main Thread Started");

		Task mytask = new Task();
		SecondTask secondTask = new SecondTask();

		Thread t1 = new Thread(mytask);
		t1.start();
		Thread t2 = new Thread(secondTask);
		System.out.println("Child Thread Started");
		System.out.println("Main is waiting for child thread to finish");
		t1.join();
		t2.start();
		t2.join();
		System.out.println("Main Thread ends");

	}
}