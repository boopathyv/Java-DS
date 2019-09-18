package chapters.Classes;

public class Static {
	
	public static void main(String[] args) {
		MainStatic.InnerStatic innerStatic = new MainStatic.InnerStatic();
		System.out.println(innerStatic.getA());
	}

}


class MainStatic {

	static class InnerStatic {

		public static String getA() {
			return "AA";
		}
	}
}
