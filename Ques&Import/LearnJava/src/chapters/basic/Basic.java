package chapters.basic;

public class Basic {
	
	protected int hibaby = 90;
	public int google = 76;
	int dude = 89;
	private int common = 89;
	
	public static void main(String[] args) {
		System.out.println(Another.DAYS_IN_WEEK);
		System.out.println(Another.c);
		
		Another another = new Another();
		System.out.println(another.a);
		
		Another.c = 80;
		System.out.println(Another.c);
		another.c = 90;
		System.out.println(another.c);
		
		
		System.out.println(another.d);
		
		// final cannot be changed
		// another.d = 90;
		
		// final cannot be changed
		// another.DAYS_IN_WEEK = 90;
		
		// cannot access private variable outside
		// System.out.println(another.b);
	}
}

class Another{
	// default public
	int a = 10;
	
	private int b = 10;
	
	static int c = 100;
	final int d = 90;
	static final int DAYS_IN_WEEK = 7;
	
	protected int g = 80;
}

