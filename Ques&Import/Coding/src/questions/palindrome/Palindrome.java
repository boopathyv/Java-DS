package questions.palindrome;

import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER No. OF TEST CASES");
		int testCases = sc.nextInt();
		for (int i = 1; i <= testCases; i++) {
			System.out.println("TEST CASE "+i);
			System.out.println("Enter Word");
			String word = sc.next();
			StringBuilder sb = new StringBuilder(word);
			sb.reverse();
			String reverseString = sb.toString();
			if(reverseString.equals(word)) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
	}

}
