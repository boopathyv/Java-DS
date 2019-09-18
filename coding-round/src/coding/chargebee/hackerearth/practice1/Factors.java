package coding.chargebee.hackerearth.practice1;

import java.util.Scanner;

class Factors {
    
	public static void main(String args[] ) throws Exception {
		System.out.println("Enter Two Nos.");
        Scanner sc = new Scanner(System.in);
        long firstNumber = sc.nextLong();
        long secondNumber = sc.nextLong();
        int count = 0;
        long end = 0;
        long lastDivisor = 0;
        long lastDividend = 0;
        if(firstNumber < secondNumber) {
        	lastDivisor = firstNumber;
        	lastDividend = secondNumber;
        	end = firstNumber/2 + 1;
        }else {
        	lastDivisor = secondNumber;
        	lastDividend = firstNumber;
        	end = secondNumber/2 + 1;
        }
        for (int i = 1; i <= end; i++) {
			if(firstNumber % i == 0 && secondNumber % i == 0) {
				System.out.println(i);
				count++;
			}
		}
        if(lastDividend % lastDivisor == 0 && lastDivisor != 1) {
        	System.out.println(lastDivisor);
        	count++;
        }
        System.out.println("total: "+count);
    }
}
