package chapters.hackerrank;

public class PrintStairCase {

	public static void main(String[] args) {
		int num = 6;
		
		StringBuilder str = new StringBuilder("");
		for (int i = 1; i <= num; i++) {
			if(i>1) {
				str.append("\n");
			}
			for (int space = 1; space <= num; space++) {
				if(space > num-i) {
					str.append("#");
				}else {
					str.append(" ");
				}
			}
		}
		
		System.out.println(str.toString());
	}
}
