package coding.chargebee.hackerearth.practice1;

import java.util.Scanner;

public class MinimumValue {

	public static void main(String[] args) {
		System.out.println("Enter the length of the Array");
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        long sum = 0;
        for (int i = 0; i < length; i++) {
        	sum += sc.nextLong();
		}
        long minNumber = sum/length+1;
        System.out.println(minNumber);
	}
}
