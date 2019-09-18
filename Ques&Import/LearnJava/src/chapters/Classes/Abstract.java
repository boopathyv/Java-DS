package chapters.Classes;

class AbstractInner{
	public AbstractInner main(String[] args) {
		return this;
	}
	
}

public abstract class Abstract {
	
	public static void main(String[] args) {
		System.out.println(Abstract.getB());
		
	}

	private int a;
	private static int b;
	public Abstract(int a) {
		this.a = a;
	}
	
	public static int getB() {
		return 23;
	}
	
	public abstract void getA();
}