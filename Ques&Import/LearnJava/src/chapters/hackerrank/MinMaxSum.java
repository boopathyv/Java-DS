package chapters.hackerrank;

import java.math.BigInteger;

public class MinMaxSum {

	public static void main(String[] args) {
		int[] arr = {5,5,5,5,5};
		int min = Integer.MAX_VALUE;
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			int number = arr[i];
			if(number < min) {
				min = number;
			}
			if(number > max) {
				max = number;
			}
		}
		BigInteger minSum = BigInteger.valueOf(0);
		BigInteger maxSum = BigInteger.valueOf(0);
		boolean firstMin = false;
		boolean firstMax = false;
		for (int i = 0; i < arr.length; i++) {
			int number = arr[i];
			if(min == number && !firstMin) {
				firstMax = true;
			}else if(min != number || firstMax) {
				maxSum = maxSum.add(BigInteger.valueOf(number));
			}
			
			if(max == number && !firstMin) {
				firstMin = true;
			}else if(max != number || firstMin) {
				minSum = minSum.add(BigInteger.valueOf(number));
			}
		}
		System.out.println(minSum+ " "+maxSum);
	}
}
