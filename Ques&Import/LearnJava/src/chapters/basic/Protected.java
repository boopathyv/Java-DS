package chapters.basic;

public class Protected extends Basic{

	
	public static void main(String[] args) {
		Protected pro = new Protected();
		pro.check();
	}

	private void check() {
		//public
		System.out.println(google);
		//protected
		System.out.println(hibaby);
		//no modifier
		System.out.println(dude);
		//private
//		System.out.println(common);
	}
}
