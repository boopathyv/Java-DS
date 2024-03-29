package chapters.paypal;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Nonnegative {

	
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter No. of TestCases");
//		int testCase = sc.nextInt();
//		for (int i = 0; i < testCase; i++) {
//			System.out.println("Enter No.");
//			String number = sc.next();
//		}
		testAndPrint("3773561366613203692478122629384");
	}

	private static void testAndPrint(String number) {
		String binaryRep = getBinaryRepresentation(number);
		int length = binaryRep.length();
		List<String> list = new ArrayList<>();
		if(length == 1 && !binaryRep.equals("0")) {
			list.add(binaryRep);
		}else {
			int count = 1;
			for (int i = 0; i < binaryRep.length() && count<=binaryRep.length(); i++) {
				String subString = binaryRep.substring(i,i+count);
				if(checkForOnez(subString)) {
					list.add(subString);
				}
				if(i+count == binaryRep.length()) {
					i = -1;
					count++;
				}
			}
		}
		System.out.println(list.size());
	}

	private static boolean checkForOnez(String subString) {
		int count = 0;
		for (int i = 0; i < subString.length(); i++) {
			if(subString.substring(i, i+1).equals("1")) {
				count++;
			}
		}
		return count%2 == 0 ? false : true;
	}

	private static String getBinaryRepresentation(String number) {
		return BigDecimal.valueOf(Double.parseDouble(number)).toBigInteger().toString(2);
	}
}
