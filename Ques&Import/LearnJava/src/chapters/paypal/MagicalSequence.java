package chapters.paypal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MagicalSequence {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter No. of TestCases");
		int testCase = sc.nextInt();
		for (int i = 0; i < testCase; i++) {
			System.out.println("Enter No.");
			String number = sc.next();
			testAndPrint(number);
		}
		List<String> testCasesList = Arrays.asList("26","1","0","100","675","8342","67591","426759","1182675",
				"52844118","1234567890","0000000000","3905202947924550","01234567899876543210","14215839450944124608");
		for (int i = 0; i < testCasesList.size(); i++) {
			testAndPrint(testCasesList.get(i));
		}
	}
	

	
//	List<String> testCasesList = Arrays.asList("1","0","0000","1234567890",
//			"41201953788963824033556555672","3000158","90540677470",
//			"188648824429847292479287385561746664");
//	for (int i = 0; i < testCasesList.size(); i++) {
//		testAndPrint(testCasesList.get(i));
//	}
	
	//TestCases
	//41201953788963824033556555672
	//3000158
	//90540677470
	//188648824429847292479287385561746664

	private static void testAndPrint(String number) {
		List<String> list = getAllPossibleComb(number);
		List<String> contagiousList = checkForContagious(list);
		System.out.println(contagiousList.size());
	}

	private static List<String> checkForContagious(List<String> list) {
		List<String> resultList = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			String number = list.get(i);
			int totalSum = getSum(number);
			if(totalSum % 10 == 0) {
				resultList.add(number);
			}
		}
		return resultList;
	}

	private static int getSum(String number) {
		int[] arr = new int[number.length()];
		boolean toggle = false;
		for (int i = number.length()-1; i >= 0; i--) {
			if(!toggle) {
				arr[i] = Integer.parseInt(String.valueOf(number.charAt(i)));
				toggle = !toggle;
			}else {
				int val = Integer.parseInt(String.valueOf(number.charAt(i)));
				val = val*2;
				arr[i] = val;
				if(val >= 10) {
					String value = String.valueOf(val);
					val = Integer.parseInt(String.valueOf(value.charAt(0))) + 
								Integer.parseInt(String.valueOf(value.charAt(1)));
					arr[i] = val;
				}
				toggle = !toggle;
			}
		}
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}

	private static List<String> getAllPossibleComb(String number) {
		List<String> resultList = new ArrayList<>();
		int distant = 1;
		for (int i = 0; i < number.length(); i++) {
			if(i+distant <= number.length()) {
				resultList.add(number.substring(i, i+distant));
			}
			if(i+1 == number.length() && distant < number.length()) {
				i = -1;
				++distant;
			}
		}
		return resultList;
	}
}
