package chapters.Classes;

public class Inner {

	public static void main(String[] args) {
		Outer.Inner in = new Outer().new Inner();
		in.getMethod();
	}
	
}

class Outer{
	
	class Inner{
		public void getMethod() {
			System.out.println("Inside Outer");
		}	
	}
}
