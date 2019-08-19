package questions.pattern;

public class PatternNumber {

	public static void main(String[] args) {
		int space = 3;
		int count = 0; 
		for (int i = 1; i <= 4; i++,space--) {
			String stars = "";
			for (int j = 1; j <= space; j++) {
				stars += " ";
			}
			for (int j = i; j >= 1; j--) {
				stars += (count+j)+" ";
			}
			count += i;
			System.out.println(stars);
		}
		space = 0;
		for (int i = 4; i >= 1; i--,space++) {
			String stars = "";
			for (int j = 1; j <= space; j++) {
				stars += " ";
			}
			for (int j = 0; j < i; j++) {
				stars += (count-j)+" ";
			}
			count -= i;
			System.out.println(stars);
		}
	}
}


//	  1  
//   3 2
//  6 5 4
//10 9 8 7
//10 9 8 7 
//  6 5 4 
//   3 2 
//    1