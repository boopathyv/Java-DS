package questions.primenumber;

import java.util.Scanner;

public class PrimeNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER THE NO OF TEST CASES");
		int testCases = sc.nextInt();
		for (int i = 1; i <= testCases; i++) {
			System.out.println("ENTER THE NUMBER");
			int number = sc.nextInt();
			StringBuilder sb = new StringBuilder(String.valueOf(number));
			sb.reverse();
			int reverseNumber = Integer.parseInt(sb.toString());
			test(number,reverseNumber);
		}
	}

	private static void test(int number, int reverseNumber) {
		boolean isPrimeNumber = checkForPrimeNo(number);
		boolean isPrimeReverseNumber = checkForPrimeNo(reverseNumber);
		if(isPrimeNumber && isPrimeReverseNumber) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
		
	}

	private static boolean checkForPrimeNo(int number) {
		for (int i = 2; i < number/2; i++) {
			if(number % i == 0) {
				return false;
			}
		}
		return true;
	}
}
