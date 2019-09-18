package chapters.basic;

import java.util.concurrent.CompletableFuture;

public class Asynchronous {

	public static void main(String[] args) {
		Asynchronous async = new Asynchronous();
		async.async();
	}

	private void async() {
		try {
			Integer accept = CompletableFuture.supplyAsync(this::callhere).get();
			System.out.println(accept);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
	
	public int callhere() {
		return 99;
	}
	
	public void printHere(String a) {
		System.out.println(a);
	}
}
