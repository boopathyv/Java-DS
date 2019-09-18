package chapters.exceptions;

public class Finally {
	
	public static void main(String[] args) {
		Finally fin = new Finally();
		fin.check();
	}
	
	private void check() {
		try {
			throw new Error();
		}finally {
			System.out.println("Finally");
		}

	}

}
