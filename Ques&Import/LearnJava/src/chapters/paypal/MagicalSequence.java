package chapters.paypal;

import java.util.Scanner;

public class MagicalSequence {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter No. of TestCases");
		int testCase = sc.nextInt();
		for (int i = 0; i < testCase; i++) {
			System.out.println("Enter No.");
			int number = sc.nextInt();
			testAndPrint(number);
		}
	}

	private static void testAndPrint(int number) {
		// TODO Auto-generated method stub
		
	}
}
