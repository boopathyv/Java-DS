package coding.chargebee.hackerearth.practice1;

import java.util.Scanner;

public class FizzBUzz {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for (int i = 0; i < testCases; i++) {
			int number = sc.nextInt();
			for (int j = 1; j <= number; j++) {
				if(j %3 ==0 && j %5==0) {
					System.out.println("FizzBuzz");
				}else if(j % 3 == 0) {
					System.out.println("Fizz");
				}else if(j % 5 == 0) {
					System.out.println("Buzz");
				}else {
					System.out.println(j);
				}
			}
		}
	}
}
